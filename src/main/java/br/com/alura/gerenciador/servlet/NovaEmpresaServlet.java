package br.com.alura.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("Cadastrando nova empresa");
        String nomeEmpresa = req.getParameter("nome");
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        //chamar o JSP
        RequestDispatcher rd = req.getRequestDispatcher("/novaEmpresaCriada.jsp");
        req.setAttribute("empresa",empresa.getNome());
        rd.forward(req,resp);


    }
}
