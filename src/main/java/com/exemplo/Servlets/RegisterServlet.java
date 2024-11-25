package com.exemplo.Servlets;

import java.io.IOException;
import java.sql.SQLException;
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

import com.exemplo.dao.PessoaDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Adotante.Adotante;
import com.exemplo.model.Endereco.Endereco;
import com.exemplo.model.Funcionario.Funcionario;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.util.BuscaCEP;
import lombok.SneakyThrows;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mensagemErro", null);

        String senha = request.getParameter("senha");
        String confirmacaoSenha = request.getParameter("confirmacaoSenha");
        String cep = request.getParameter("cep");
        String nome = request.getParameter("nome");
        String dataDeNascimento = request.getParameter("dataDeNascimento");
        String numeroCasa = request.getParameter("numeroCasa");
        String genero = request.getParameter("genero");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");

        if (!senha.equals(confirmacaoSenha)) {
            redirecionarComErro(request, response, "Senhas não coincidem");
            return;
        }

        Pessoa p = Pessoa.builder()
                .nome(nome)
                .genero(Pessoa.GENERO.valueOf(genero))
                .telefone(telefone)
                .build();

        if (!adicionarEndereco(p, cep, numeroCasa, request, response)) {
            return;
        }

        if (!verificarCPF(p, cpf, request, response)) {
            return;
        }

        System.out.println(p.toString());

        HttpSession session = request.getSession();


        PessoaDao pessoaDao = new PessoaDao(p);

        try {
            pessoaDao.post();
            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            redirecionarComErro(request, response, e.getMessage());

        }



    }

    private void redirecionarComErro(HttpServletRequest request, HttpServletResponse response, String mensagemErro) throws ServletException, IOException {
        request.setAttribute("mensagemErro", mensagemErro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    private boolean adicionarEndereco(Pessoa p, String cep, String numeroCasa, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Endereco endereco = BuscaCEP.buscaEnderecoPelo(cep);
            endereco.setNumero(Integer.valueOf(numeroCasa));
            p.setEndereco(endereco);

            return true;
        } catch (Exception e) {
            redirecionarComErro(request, response, "CEP inválido");
            return false;
        }
    }

    private boolean verificarCPF(Pessoa p, String cpf, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            p.setCpf(cpf);
            return true;
        } catch (IllegalArgumentException e) {
            redirecionarComErro(request, response, "CPF inválido");
            return false;
        }
    }

}

