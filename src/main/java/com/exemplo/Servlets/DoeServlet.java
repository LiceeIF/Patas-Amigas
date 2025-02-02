package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/doar")
@MultipartConfig(maxFileSize = 16177215)
public class DoeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/doar.jsp");


        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            String especie = req.getParameter("especie");
            String raca = req.getParameter("raca");
            String sexo = req.getParameter("sexo");
            String historicoMedico = req.getParameter("historico_medico");
            String dataResgateString = req.getParameter("data_de_resgate");
            String dataNascimentoString = req.getParameter("data_de_nascimento");

            Part filePart = req.getPart("foto");
            InputStream fotoStream = (filePart != null && filePart.getSize() > 0) ? filePart.getInputStream() : null;

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date dataDeNascimento = formato.parse(dataNascimentoString);
            Date dataDeResgate = formato.parse(dataResgateString);

            Animal animal = new Animal(
                    nome,
                    especie,
                    raca,
                    Animal.ADOCAO.BuscandoNovoDono,
                    fotoStream,
                    dataDeResgate,
                    historicoMedico,
                    sexo,
                    dataDeNascimento
            );

            AnimalDao animalDao = new AnimalDao(ConnectionFactory.getConnection());

            Pessoa usuario = (Pessoa) req.getSession().getAttribute("usuario");

            animalDao.inserirAnimal(animal, usuario.getId(), fotoStream);

            req.setAttribute("mensagem", "Animal cadastrado com sucesso!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
            dispatcher.forward(req, resp);

        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
            req.setAttribute("mensagem", "Erro ao cadastrar animal: " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/doar.jsp");
            dispatcher.forward(req, resp);

        } catch (ParseException e) {
            e.printStackTrace();
            req.setAttribute("mensagem", "Erro ao processar as datas: " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/doar.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
