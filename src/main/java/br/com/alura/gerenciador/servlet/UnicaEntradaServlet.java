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

        HttpSession session = req.getSession();
        boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado")  == null;
        boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if (ehUmaAcaoProtegida && usuarioNaoEstaLogado){
            resp.sendRedirect("entrada?acao=LoginForm"); ;
            return;
        }

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

//        if (paramAcao.equals("ListaEmpresas")) {
//            System.out.println("Ação - Listando Empresas");
//
//            ListaEmpresas acao = new ListaEmpresas();
//            nome = acao.executa(req, resp);
//
//
//        } else if (paramAcao.equals("RemoveEmpresa")) {
//            System.out.println("Ação - Remove Empresa");
//
//            RemoveEmpresa acao = new RemoveEmpresa();
//            nome = acao.executa(req, resp);
//
//        } else if (paramAcao.equals("MostraEmpresa")) {
//            System.out.println("Ação - Mostrando dados da Empresa");
//
//            MostraEmpresa acao = new MostraEmpresa();
//            nome = acao.executa(req, resp);
//
//        } else if (paramAcao.equals("AlteraEmpresa")) {
//            System.out.println("Ação - Alterando os dados da Empresa");
//
//            AlteraEmpresa acao = new AlteraEmpresa();
//            nome = acao.executa(req, resp);
//
//        } else if (paramAcao.equals("NovaEmpresa")) {
//            System.out.println("Ação - Nova Empresa");
//
//            NovaEmpresa acao = new NovaEmpresa();
//            nome = acao.executa(req, resp);
//        } else if(paramAcao.equals("NovaEmpresaForm")){
//            System.out.println("Ação - Fórmulário Empresa");
//            NovaEmpresaForm acao = new NovaEmpresaForm();
//            nome = acao.executa(req,resp);
//        }


    }
}
