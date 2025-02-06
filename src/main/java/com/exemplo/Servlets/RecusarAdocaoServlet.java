package com.exemplo.Servlets;

import com.exemplo.dao.SolicitacaoDao;
import com.exemplo.db.ConnectionFactory;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/recusar_adocao")
public class RecusarAdocaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();

            Long idAnimal = Long.valueOf(req.getParameter("idAnimal"));
            Long idDono = Long.valueOf(req.getParameter("idDono"));
            Long idSolicitador = Long.valueOf(req.getParameter("idSolicitador"));

            SolicitacaoDao solicitacaoDao = new SolicitacaoDao(connection);
            solicitacaoDao.deleteById(idAnimal, idDono,idSolicitador);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/solicitacoes");
            dispatcher.forward(req, resp);
        }
        finally {
            assert connection != null;
            connection.close();
        }
    }

}
