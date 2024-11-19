package com.exemplo.Servlets;

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

import com.exemplo.model.Adotante.Adotante;
import com.exemplo.model.Funcionario.Funcionario;
import com.exemplo.model.Pessoa.Pessoa;



@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mensagemErro", null);
        String nome = request.getParameter("nome");
        String dataDeNascimento = request.getParameter("dataDeNascimento");
        String cep = request.getParameter("cep");
        String numeroCasa = request.getParameter("numeroCasa");
        String senha = request.getParameter("senha");
        String confirmacaoSenha = request.getParameter("confirmacaoSenha");
        String genero = request.getParameter("genero");
        
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        

        if (!senha.equals(confirmacaoSenha)){
            request.setAttribute("mensagemErro", "Senhas não conhecidem");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Pessoa p = Pessoa.builder()
            .nome(nome)
            .endereco(cep + " " + numeroCasa)
            .build();
        
        try{
            p.setCpf(cpf);
        }
        catch (IllegalArgumentException e){
            request.setAttribute("mensagemErro", "CPF inválido");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        }

        HttpSession session = request.getSession();


        //Insert do coiso e session 

    }
}

