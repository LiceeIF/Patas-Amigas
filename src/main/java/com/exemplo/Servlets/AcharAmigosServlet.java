package com.exemplo.Servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/achar_amigos")
public class AcharAmigosServlet extends HttpServlet {
    /*
    Só estou fazendo isso para pensar melhgor nas ideias askdkassdkasdkaskdk Não liguem

    Vai ser tipo uma forma de achar pets fofos e dar like

    Quando faz o get Chamar fazer um select de uns 30, quando o array chegar nos
    10 ultimos, fazer um select de 20

    Toda vez que ele apertar o botao ele vai verificar o tamanho do array

    Enquanto isso uma thread fica analisando Se ele curtiu ou não e quanto tempo ficou, com base nisso temos
    vai ter uma pontuação, vamos jogar a pontuação em um grafo e depois fazer um select com as especies de
    animais que o user mais gosta, ou nem precisa ser um grafo necessariamente

    */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/achar_amigos.jsp");
        /*
        Do while talvez?
         */
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

    }

}
