<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp" />

<html lang="pt-br">
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/home.css">
</head>
<body>
    <div id="main">
        <img id="imagem_fofa" src="images/imagem%20home.png" width="1360" alt="logo">
            <div>
                <p>
                    Está procurando amigos para acompanhar seus dias e não sabe como? Olhe as rede com novos companheiros, encontre lojas para acessórios e adote um novo amigo.
                </p>
            </div>

        <div>
            <b>Animais: </b> <a href="/pesquisar">ver mais...</a>
            <div style="border-bottom: 4px solid rgba(242,120,161,0.44); margin-bottom: 2rem; border-radius: 7px">
                <c:forEach items="${animais}" var="animal">
                    <c:if test="${not empty animal.fotoBase64}">
                        <div class="botoes_menu">
                            <a href="animal?id=${animal.id}" >
                                <img src="data:image/jpeg;base64,${animal.fotoBase64}" width="210" height="210" alt="Foto do animal">
                            </a>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>