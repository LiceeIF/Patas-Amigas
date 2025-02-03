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
                <button>Sobre nós</button>
            </div>

        <div>
            Animais <a href="">ver mais...</a>
            <div>
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
        <div>
            Adotantes <a href="">ver mais...</a>
        </div>
        <div>
            Tutores <a href="">ver mais...</a>
        </div>
        <div>
            Funcionarios <a href="">ver mais...</a>
        </div>
    </div>
</body>
</html>