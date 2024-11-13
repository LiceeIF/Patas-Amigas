package com.exemplo.Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exemplo.model.Pessoa;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lepo = request.getParameter("userType");
        System.out.println(lepo);
        String nome = request.getParameter("nome");
        String dataDeNascimento = request.getParameter("dataDeNascimento");
        String cpf = request.getParameter("cpf");
        String cep = request.getParameter("cep");
        String numeroCasa = request.getParameter("numeroCasa");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmacaoSenha = request.getParameter("confirmacaoSenha");

        
    }
    
    
}
