package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramAcao = req.getParameter("acao");


        String nome = null;
        String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

        try {
            Class classe = Class.forName(nomeDaClasse); //Carregar a classe com o nome
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(req,resp);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServletException(e);
        }

        String[] tipoEEdereco = nome.split(":");
        if (tipoEEdereco[0].equals("forward")) {
            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + tipoEEdereco[1]);
            rd.forward(req, resp);
        } else {
            resp.sendRedirect(tipoEEdereco[1]);
        }


    }
}
