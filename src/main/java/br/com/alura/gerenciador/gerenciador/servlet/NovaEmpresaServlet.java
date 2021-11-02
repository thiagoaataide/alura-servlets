package br.com.alura.gerenciador.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("Cadastrando nova empresa");
        String nomeEmpresa = req.getParameter("nome");

        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>cadastrando nova empresa: " + nomeEmpresa + " </body></html>");

    }
}
