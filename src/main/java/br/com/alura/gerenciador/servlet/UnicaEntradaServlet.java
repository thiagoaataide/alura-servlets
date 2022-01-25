package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.acao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramAcao = req.getParameter("acao");

        if (paramAcao.equals("ListaEmpresas")) {
            System.out.println("Ação - Listando Empresas");

            ListaEmpresas acao = new ListaEmpresas();
            acao.executa(req, resp);


        } else if (paramAcao.equals("RemoveEmpresa")) {
            System.out.println("Ação - Remove Empresa");

            RemoveEmpresa acao = new RemoveEmpresa();
            acao.executa(req,resp);

        } else if (paramAcao.equals("MostraEmpresa")) {
            System.out.println("Ação - Mostrando dados da Empresa");

            MostraEmpresa acao = new MostraEmpresa();
            acao.executa(req,resp);

        } else if(paramAcao.equals("AlteraEmpresa")){
            System.out.println("Ação - Alterando os dados da Empresa");

            AlteraEmpresa acao = new AlteraEmpresa();
            acao.executa(req,resp);

        } else if(paramAcao.equals("NovaEmpresa")){
            System.out.println("Ação - Nova Empresa");

            NovaEmpresa acao = new NovaEmpresa();
            acao.executar(req,resp);
        }
    }
}
