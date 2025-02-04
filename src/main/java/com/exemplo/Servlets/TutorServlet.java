package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.dao.PessoaDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import lombok.SneakyThrows;

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

@WebServlet("/tutor")
public class TutorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tela_tutor.jsp");
        dispatcher.forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());

        Pessoa usuario = (Pessoa) req.getSession().getAttribute("usuario");
        System.out.println(usuario);
        Pessoa pessoa = (Pessoa) pessoaDao.updateTutor(
                usuario.getId()
        );
        System.out.println(pessoa);

        req.getSession().setAttribute("usuario", pessoa);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/doar.jsp");
        dispatcher.forward(req, resp);
    }
}
