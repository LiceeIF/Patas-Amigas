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
import java.util.List;

@WebServlet("/animal")
public class AnimalPerfilServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        session.setAttribute("animal",null);
        if (id != null) {
            AnimalDao animalDao = new AnimalDao(ConnectionFactory.getConnection());
            Animal animal = animalDao.selectById(Long.valueOf(id));

            session.setAttribute("animal", animal);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/animal.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pesquisa.jsp");
            dispatcher.forward(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Animal animal = (Animal) session.getAttribute("animal");

        if (animal != null) {
            Pessoa usuario = (Pessoa) req.getSession().getAttribute("usuario");

            RelacaoDao relacaoDao = new RelacaoDao(ConnectionFactory.getConnection());
            Relacao relacao = relacaoDao.selectByAnimalId(animal);

            Solicitacao solicitacao = new Solicitacao(
                    animal.getId(),
                    relacao.getIdUsuario(),
                    usuario.getId(),
                    Boolean.FALSE
            );

            SolicitacaoDao solicitacaoDao = new SolicitacaoDao(ConnectionFactory.getConnection());
            solicitacaoDao.insert(solicitacao);
        } else {
            System.out.println("Erro: Animal não encontrado!");
            resp.sendRedirect("errorPage.jsp");
        }
    }
}
