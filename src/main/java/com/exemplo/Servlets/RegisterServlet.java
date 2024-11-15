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



@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoConta = request.getParameter("contaTipo");

        String nome = request.getParameter("nome");
        String dataDeNascimento = request.getParameter("dataDeNascimento");
        String cpf = request.getParameter("cpf");
        String cep = request.getParameter("cep");
        String numeroCasa = request.getParameter("numeroCasa");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Busca para ver se não tem ninguem com email, nome ou cpf já cadastrado. Se sim, retornar erro

      if (Objects.equals(tipoConta, "tutor")) {
          Tutor t = Tutor.builder()
                  .nome(nome)
                  .dataDeNascimento(parseDate(dataDeNascimento))
                  .cpf(cpf)
                  .endereco(cep + " " + numeroCasa)
                  .telefone(telefone)
                  .email(email)
                  .senha(senha)
                  .build();

          System.out.println(t.toString());
      }

      else if (Objects.equals(tipoConta, "funcionario")) {
          Funcionario f = Funcionario.builder()
                  .nome(nome)
                  .dataDeNascimento(parseDate(dataDeNascimento))
                  .cpf(cpf)
                  .endereco(cep + " " + numeroCasa)
                  .telefone(telefone)
                  .email(email)
                  .senha(senha)
                  .build();
      }

      else if (Objects.equals(tipoConta, "adotante")) {
          Adotante a = Adotante.builder()
                  .nome(nome)
                  .dataDeNascimento(parseDate(dataDeNascimento))
                  .cpf(cpf)
                  .endereco(cep + " " + numeroCasa)
                  .telefone(telefone)
                  .email(email)
                  .senha(senha)
                  .build();
      }

      // Criar no banco usando generico
      RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
      dispatcher.forward(request, response);
    }
    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr); // Ajuste conforme o formato necessário
        } catch (ParseException e) {
            return null;  // Lidar com erro de conversão, se necessário
        }
    }
}
