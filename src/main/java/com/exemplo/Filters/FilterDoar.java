package com.exemplo.Filters;

import com.exemplo.model.Pessoa.Pessoa;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/doar", "/solicitacoes"})
public class FilterDoar implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Pessoa usuario = (Pessoa) httpRequest.getSession().getAttribute("usuario");

        if (usuario == null) {
            httpResponse.sendRedirect("/login");
            return;
        }

        if (!usuario.getTutor()) {
            httpResponse.sendRedirect("/tutor");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
