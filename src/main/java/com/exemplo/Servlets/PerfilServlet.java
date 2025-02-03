package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.dao.PessoaDao;
import com.exemplo.dao.SolicitacaoDao;
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

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        request.setAttribute("perfil", null);
        request.setAttribute("solicitacoes", null);

        String nome = request.getParameter("nome");
        SolicitacaoDao solicitacaoDao = new SolicitacaoDao(ConnectionFactory.getConnection());

        if( nome != null){
            PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());
            Pessoa pessoa = pessoaDao.selectByName(nome);
            request.setAttribute("perfil", pessoa);
            request.setAttribute("solicitacoes", solicitacaoDao.selectSolicitacoesByPessoaId(pessoa));
        }
        else{
            Pessoa pessoa = (Pessoa) request.getSession().getAttribute("usuario");
            request.setAttribute("perfil", pessoa);
            request.setAttribute("solicitacoes", solicitacaoDao.selectSolicitacoesByPessoaId(pessoa));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/perfil.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
