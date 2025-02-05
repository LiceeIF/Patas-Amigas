package com.exemplo.Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/pesquisar")
public class PesquisaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/buscar.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoria = req.getParameter("categoria");
        String[] opcoes = req.getParameterValues("opcoes");

        List<String> resultados = new ArrayList<>();

        if (categoria != null && opcoes != null) {
            for (String opcao : opcoes) {
                resultados.add(opcao);
            }
        }


        req.setAttribute("resultados", resultados);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/buscar.jsp");
        dispatcher.forward(req, resp);
    }
}
