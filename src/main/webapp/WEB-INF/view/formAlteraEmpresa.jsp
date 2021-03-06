<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/entrada?acao=AlteraEmpresa" var="linkServletNovaEmpresa"/>
<html>
<head>
    <title>Alteração de Empresa</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>
<form action="${linkServletNovaEmpresa}" method="post">
    Nome: <input type="text" name="nome" value="${empresa.nome}"/>
    Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
    <input type="hidden" name="id" value="${empresa.id}">

    <input type="submit"/>

</form>

</body>
</html>
