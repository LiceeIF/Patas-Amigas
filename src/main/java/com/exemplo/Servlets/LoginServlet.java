package com.exemplo.Servlets;

import com.exemplo.dao.PessoaDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Pessoa.Pessoa;
import lombok.SneakyThrows;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try{
            PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());

            Pessoa p = pessoaDao.select(
                    email,
                    senha
            );
            HttpSession session = request.getSession();
            session.setAttribute("usuario", p);
            response.sendRedirect("/home");

        }
        catch (IllegalArgumentException err){
            throw new IllegalArgumentException(err);
        }

    }

}
