package com.exemplo.Servlets;

import com.exemplo.Adotante.Adotante;
import com.exemplo.Funcionario.Funcionario;
import com.exemplo.Pessoa.Pessoa;
import com.exemplo.Tutor.Tutor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/tipo_conta")
public class ContaTipoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tipo_conta.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoConta = request.getParameter("tipo_conta");  

        HttpSession session = request.getSession();
        session.setAttribute("conta", tipoConta);  
        response.sendRedirect("register.jsp");  
    }
}

