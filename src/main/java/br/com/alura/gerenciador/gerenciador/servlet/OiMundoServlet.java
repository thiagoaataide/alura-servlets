package br.com.alura.gerenciador.gerenciador.servlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//oi
@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Oi, mundo. Parabéns vc escreveu o primeiro servlet!");
        writer.println("</body>");
        writer.println("</html>");

        System.out.println("o servlet OiMundoServlet foi chamado");
    }
}
