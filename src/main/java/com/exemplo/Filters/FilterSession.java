package com.exemplo.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class FilterSession implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getRequestURI();
        HttpSession session = httpRequest.getSession(false);

        if (path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".gif") || path.endsWith(".mp4")) {
            chain.doFilter(request, response);
            return;
        }

        if (path.endsWith("/login") || path.endsWith("/register") || path.equals("/")) {
            if (session != null && session.getAttribute("usuario") != null) {
                httpResponse.sendRedirect("/home");
                return;
            }
            chain.doFilter(request, response);
            return;
        }

        if (session == null || session.getAttribute("usuario") == null) {
            httpResponse.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
