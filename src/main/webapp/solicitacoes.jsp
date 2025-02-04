<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<html>
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/solicitacoes.css">

</head>
<body>
<div id="main">

        <c:if test="${not empty solicitacoes}">
            <h2>
                Solicitações de adoção:
            </h2>
            <c:forEach var="solicitacao" items="${solicitacoes}">
                <div class="solicitacao_div">
                    <p>
                        <a href="/perfil?id=${solicitacao.solicitador.id}">
                                ${solicitacao.solicitador.nome}
                        </a> quer adotar ${solicitacao.animal.nome}.
                    </p>

                    <button>
                        Recusar
                    </button>

                    <form method="POST" action="${pageContext.request.contextPath}/aceitar_solicitacao?id_animal=${solicitacao.animal.id}&id_novo_dono=${solicitacao.solicitador.id}&id_antigo=${solicitacao.dono.id}">
                        <input type="submit" value="Aceitar adoção!">
                    </form>

                </div>
            </c:forEach>
        </c:if>



    <c:if test="${empty solicitacoes}">
        <p>Não há solicitações para exibir.</p>
    </c:if>

</div>

</body>
</html>
