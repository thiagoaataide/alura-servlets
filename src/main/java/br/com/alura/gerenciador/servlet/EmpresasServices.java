package br.com.alura.gerenciador.servlet;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/empresas")
public class EmpresasServices extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empresa> empresas = new Banco().getEmpresas();

        String header = request.getHeader("Accept");

        if (header.endsWith("xml")){

            XStream xStream = new XStream();
            xStream.alias("empresa", Empresa.class);
            String xml = xStream.toXML(empresas);

            response.setContentType("applications/xml");
            response.getWriter().print(xml);
        } else if (header.endsWith("json")){

            Gson gson = new Gson();
            String json = gson.toJson(empresas);

            response.setContentType("application/json");
            response.getWriter().print(json);
        } else{
            response.setContentType("application/json");
            response.getWriter().print("{'message':'no content'}");
        }

    }
}
