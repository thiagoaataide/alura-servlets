package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");

        String nome = null;
        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

        try {
            Class classe = Class.forName(nomeDaClasse); //Carregar a classe com o nome
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request,response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServletException(e);
        }

        String[] tipoEEdereco = nome.split(":");
        if (tipoEEdereco[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEdereco[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(tipoEEdereco[1]);
        }
    }
}
