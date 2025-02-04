package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.dao.PessoaDao;
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
import java.util.List;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        request.setAttribute("perfil", null);
        request.setAttribute("solicitacoes", null);

        String id = request.getParameter("id");


        Pessoa pessoa = null;

        if( id != null){
            PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());
            pessoa = pessoaDao.selectById(Long.valueOf(id));
        }
        else{
            pessoa = (Pessoa) request.getSession().getAttribute("usuario");
        }

        request.setAttribute("perfil", pessoa);

        RelacaoDao relacaoDao = new RelacaoDao(ConnectionFactory.getConnection());
        List<Relacao> relacoes =  relacaoDao.selectByUserId(pessoa.getId());
        request.setAttribute("relacoes", relacoes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/perfil.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
