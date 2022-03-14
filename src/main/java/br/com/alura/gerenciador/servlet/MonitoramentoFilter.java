package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");
        //executa a ação
        chain.doFilter(request,response);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de Execução da ação: " + acao + ". " + (depois - antes));
    }


}
