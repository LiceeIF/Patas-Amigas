package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.dao.DtoDao;
import com.exemplo.dao.RegistroDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.dto.DtoGenerico;
import com.exemplo.model.Animal.Animal;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/funcionario")
public class FuncionarioServlet extends  HttpServlet{

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            DtoDao dtoDao = new DtoDao(connection);
            RegistroDao registroDao = new RegistroDao(connection);

            request.setAttribute("registros", registroDao.select());
            request.setAttribute("especies", dtoDao.especieAnimais());
            request.setAttribute("usuarios", dtoDao.tiposUsuarios());
            request.setAttribute("cachorros", dtoDao.quantidadeRaca("Cachorro"));
            request.setAttribute("gatos", dtoDao.quantidadeRaca("Gato"));
            request.setAttribute("passaros", dtoDao.quantidadeRaca("Passaro"));

            for(DtoGenerico dtoGenerico : dtoDao.quantidadeRaca("Passaro")){
                System.out.println(dtoGenerico.getTipo());
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/funcionario.jsp");
            dispatcher.forward(request, response);
        } finally {
            if (connection != null) {
                ConnectionFactory.closeConnection();
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/funcionario");
    }
}







