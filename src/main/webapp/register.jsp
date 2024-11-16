<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Exemplo de Página JSP</title>
</head>
<body>

    <c:choose>
        <c:when test="${sessionScope.conta == 'tutor'}">
            <p>Você está registrado como Tutor.</p>
        </c:when>
        <c:when test="${sessionScope.conta == 'adotante'}">
            <p>Você está registrado como Adotante.</p>
        </c:when>
        <c:when test="${sessionScope.conta == 'funcionario'}">
            <p>Você está registrado como Funcionário.</p>
        </c:when>
        <c:otherwise>
            <p>Tipo de conta não identificado.</p>
        </c:otherwise>
    </c:choose>
    
</body>
</html>
