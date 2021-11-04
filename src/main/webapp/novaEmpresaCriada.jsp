<%
    String nomeEmpresa = (String) request.getAttribute("empresa");
    System.out.println(nomeEmpresa);
%>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Nova Empresa Criada</title>
</head>
<body>
Empresa <%=nomeEmpresa%> cadastrada com sucesso!
</body>
</html>