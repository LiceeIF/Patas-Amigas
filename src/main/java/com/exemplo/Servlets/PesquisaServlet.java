package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.dao.PessoaDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

@WebServlet("/pesquisar")
public class PesquisaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        RequestDispatcher dispatcher = req.getRequestDispatcher("/buscar.jsp");
        dispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            String categoria = req.getParameter("categoria");
            String[] opcoes = req.getParameterValues("opcoes");
            List<?> resultados = new ArrayList<>();

            if(Objects.equals(categoria, "animal")){
                AnimalDao animalDao = new AnimalDao(connection);
                resultados = animalDao.listarPorEspecie(opcoes);
            }
            else if(Objects.equals(categoria, "usuario")){                
                PessoaDao pessoaDao = new PessoaDao(connection);
                resultados = pessoaDao.select();
            }

            req.setAttribute("resultados", resultados);
            req.setAttribute("categoria", categoria);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/buscar.jsp");
            dispatcher.forward(req, resp);
        }
        finally {
            assert connection != null;
            connection.close();
        }
    }
}
