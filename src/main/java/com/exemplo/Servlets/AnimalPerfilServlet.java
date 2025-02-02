package com.exemplo.Servlets;

import com.exemplo.dao.AnimalDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/animal")
public class AnimalPerfilServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

        String id = request.getParameter("id");

        AnimalDao animalDao = new AnimalDao(ConnectionFactory.getConnection());

        Animal animal = animalDao.selectById(Long.valueOf(id));

        request.setAttribute("animal", animal);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/animal.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
