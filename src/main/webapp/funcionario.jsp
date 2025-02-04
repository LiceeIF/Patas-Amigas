<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="pt-br">
<head>
    <title>Patas Amigas: Funcionário</title>
    <link rel="stylesheet" type="text/css" href="../css/doar.css">

</head>
<body>
    <header style="width: 98%; display: flex; align-items: center; justify-content: center;padding: 1rem; flex-direction: column;background-color: #ffffff";>
        <img src="images/logo amigos felizes.png" height="130px" alt="logo">
        <a href="/home">Voltar para página inicial</a>
    </header>
    <div id="main">
        funcionario
    </div>
    <c:forEach var="animal" items="${racas}">
        <p>${animal.quantidade} ${animal.tipo}</p>
    </c:forEach>

    <c:forEach var="usuario" items="${usuarios}">
        <p>${usuario.quantidade} ${usuario.tipo}</p>
    </c:forEach>
</body>
</html>