package br.com.alura.gerenciador.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<ul>");
        for (Empresa empresa : lista) {
            writer.println("<li>" + empresa.getNome() + "</li>");

        }
        writer.println("</ul>");

        writer.println("</html></body>");


    }
}
