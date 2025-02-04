package com.exemplo.Servlets;


import com.exemplo.dao.AnimalDao;
import com.exemplo.dao.SolicitacaoDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.model.Solicitacao.Solicitacao;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/solicitacoes")
public class SolicitacoesServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

        Pessoa pessoa = (Pessoa) request.getSession().getAttribute("usuario");

        SolicitacaoDao solicitacaoDao = new SolicitacaoDao(ConnectionFactory.getConnection());
        List<Solicitacao> solicitacoes = solicitacaoDao.selectSolicitacoesByPessoaId(pessoa.getId());

        request.setAttribute("solicitacoes", solicitacoes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/solicitacoes.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
