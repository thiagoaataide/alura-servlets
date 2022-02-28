<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Nova Empresa Criada</title>
</head>
    <body>
    <c:import url="logout-parcial.jsp"/>
    <c:if test="${not empty empresa}">
        Empresa ${empresa} cadastrada com sucesso!
    </c:if>

    <c:if test="${empty empresa}">
        Nenhuma empresa cadastrada.
    </c:if>
    </body>
</html>