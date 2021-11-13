<%--
  Created by IntelliJ IDEA.
  User: SANKHYA
  Date: 04/11/2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Empresas Cadastradas</title>
</head>
<body>

<c:if test="${not empty empresa}">
    Empresa ${empresa} cadastrada com sucesso!
</c:if>

<br/>
<br/>

Lista de empresas: <br/>

<ul>
    <c:forEach items="${empresas}" var="empresa">
        <%--            Ambas Expression Languages tem o mesmo resutado.--%>
        <%--            <%=empresa.getNome()%>--%>
        <li>
                ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
            <a href="/gerenciador/mostraEmpresa?id=${empresa.id}">Editar</a>
            <a href="/gerenciador/removeEmpresa?id=${empresa.id}">Remover</a>
        </li>
    </c:forEach>

</ul>

</body>
</html>
