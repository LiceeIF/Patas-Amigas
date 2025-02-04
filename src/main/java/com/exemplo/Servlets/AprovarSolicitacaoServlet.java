package com.exemplo.Servlets;

import com.exemplo.dao.RelacaoDao;
import com.exemplo.dao.SolicitacaoDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.model.Relacao.Relacao;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/aceitar_solicitacao")
public class AprovarSolicitacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
        dispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idNovo = req.getParameter("id_novo_dono");
        String idAntigo = req.getParameter("id_antigo");
        String idAnimal = req.getParameter("id_animal");

        if (idNovo == null || idAntigo == null || idAnimal == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parâmetros inválidos.");
            return;
        }

        Connection connection = null;
        try {
            Long novoDonoId = Long.parseLong(idNovo);
            Long antigoDonoId = Long.parseLong(idAntigo);
            Long animalId = Long.parseLong(idAnimal);

            connection = ConnectionFactory.getConnection();
            RelacaoDao relacaoDao = new RelacaoDao(connection);

            relacaoDao.deleteRelacao(antigoDonoId, animalId);

            Relacao relacao = new Relacao();
            relacao.setAnimal(new Animal(animalId));
            relacao.setUsuario(new Pessoa(novoDonoId));
            relacao.setRelacao("Dono");

            relacaoDao.insert(relacao);

            SolicitacaoDao solicitacaoDao = new SolicitacaoDao(connection);
            solicitacaoDao.deleteByAnimalId(animalId);

            resp.sendRedirect(req.getContextPath() + "/home");
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "IDs inválidos.");
        } finally {
            if (connection != null) {
                ConnectionFactory.closeConnection();
            }
        }
    }
}
