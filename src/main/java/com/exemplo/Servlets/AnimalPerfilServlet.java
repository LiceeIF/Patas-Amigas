package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.dao.PessoaDao;
import com.exemplo.dao.RelacaoDao;
import com.exemplo.dao.SolicitacaoDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.model.Relacao.Relacao;
import com.exemplo.model.Solicitacao.Solicitacao;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/animal")
public class AnimalPerfilServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        session.setAttribute("animal", null);

        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();

            if (id != null) {
                AnimalDao animalDao = new AnimalDao(connection);
                Animal animal = animalDao.selectById(Long.valueOf(id));

                session.setAttribute("animal", animal);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/animal.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pesquisa.jsp");
                dispatcher.forward(request, response);
            }
        } finally {
            if (connection != null) {
                ConnectionFactory.closeConnection();
            }
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Animal animal = (Animal) session.getAttribute("animal");

        if (animal != null) {
            Pessoa usuario = (Pessoa) req.getSession().getAttribute("usuario");
            Connection connection = ConnectionFactory.getConnection();

            RelacaoDao relacaoDao = new RelacaoDao(connection);
            Relacao relacao = relacaoDao.selectByAnimalId(animal);

            PessoaDao pessoaDao = new PessoaDao(connection);
            Pessoa pessoa = pessoaDao.selectById(relacao.getUsuario().getId());

            Solicitacao solicitacao = new Solicitacao(
                    animal,
                    pessoa,
                    usuario,
                    Boolean.FALSE
            );

            SolicitacaoDao solicitacaoDao = new SolicitacaoDao(connection);
            solicitacaoDao.insert(solicitacao);

            ConnectionFactory.closeConnection();
            resp.sendRedirect( "/home");
        } else {
            System.out.println("Erro: Animal não encontrado!");
            resp.sendRedirect("errorPage.jsp");
        }
    }
}
