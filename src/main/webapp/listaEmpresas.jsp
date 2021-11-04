<%@ page import="java.util.List" %>
<%@ page import="br.com.alura.gerenciador.servlet.Empresa" %><%--
  Created by IntelliJ IDEA.
  User: SANKHYA
  Date: 04/11/2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<html>
<head>
    <title>Empresas Cadastradas</title>
</head>
<body>
<ul>
    <%
        List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
        for (Empresa empresa : lista) {
    %>
    <li><%=empresa.getNome()%>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>
