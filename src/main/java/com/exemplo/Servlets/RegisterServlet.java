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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataDeNascimentoDate = sdf.parse(dataDeNascimento);

        try{
            Pessoa p = new Pessoa(
                    nome,
                    dataDeNascimentoDate,
                    Pessoa.GENERO.valueOf(genero),
                    cpf,
                    telefone.replaceAll("\\D", ""),
                    email,
                    senha
            );

            PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());

            try {
                pessoaDao.inserir(p);
                response.sendRedirect("login.jsp");
            } catch (SQLException e) {
                redirecionarComErro(request, response, e.getMessage());
            }

        }
        catch (IllegalArgumentException err){
            redirecionarComErro(request, response, "CPF inválido");
        }

    }

    private void redirecionarComErro(HttpServletRequest request, HttpServletResponse response, String mensagemErro) throws ServletException, IOException {
        request.setAttribute("mensagemErro", mensagemErro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }
}

