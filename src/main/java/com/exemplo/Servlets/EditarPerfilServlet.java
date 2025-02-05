package com.exemplo.Servlets;

import com.exemplo.dao.PessoaDao;
import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Pessoa.Pessoa;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

@WebServlet("/editar")
@MultipartConfig(maxFileSize = 52428800)
public class EditarPerfilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pessoa pessoa = (Pessoa) req.getSession().getAttribute("usuario");

        req.setAttribute("perfil", pessoa);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/editar_perfil.jsp");
        dispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Pessoa pessoa = (Pessoa) req.getSession().getAttribute("usuario");

            String nome = req.getParameter("nome");
            String genero = req.getParameter("genero");
            String telefone = req.getParameter("telefone");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            Part filePart = req.getPart("foto");
            InputStream fotoStream = (filePart != null && filePart.getSize() > 0) ? filePart.getInputStream() : null;

            System.out.println(nome);
            pessoa.setNome(nome);
            pessoa.setGenero(genero);
            pessoa.setTelefone(telefone);
            pessoa.setEmail(email);
            pessoa.setSenha(senha);
            pessoa.setFoto(fotoStream);

            PessoaDao pessoaDao = new PessoaDao(connection);
            pessoaDao.updatePessoa(pessoa);

            req.getSession().setAttribute("usuario", pessoa);

            resp.sendRedirect("perfil.jsp");
        }
        finally {
            if (connection != null) {
                ConnectionFactory.closeConnection();
            }
        }

    }
}
