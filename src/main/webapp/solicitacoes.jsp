<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<html>
<head>
    <title>Solicitações</title>
    <link rel="stylesheet" type="text/css" href="../css/solicitacoes.css">

</head>
<body>
<div id="main">
    <c:if test="${not empty solicitacoes}">
        <c:forEach var="solicitacao" items="${solicitacoes}">
            <p>
                <a href="/perfil?id=${solicitacao.solicitador.id}">
                        ${solicitacao.solicitador.nome}
                </a> quer adotar ${solicitacao.animal.nome}.
            </p>
        </c:forEach>
    </c:if>

    <c:if test="${empty solicitacoes}">
        <p>Não há solicitações para exibir.</p>
    </c:if>

</div>

</body>
</html>
