<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<html>
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/perfil.css">
</head>
<body>
<div id="main">

    <div id="info">
        <img src="data:image/jpeg;base64,${perfil.fotoBase64}" width="210" height="210" id="foto_perfil" alt="Foto do perfil">

        <h2>
            ${perfil.nome}
        </h2>
        <p>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

            <fmt:parseDate value="${perfil.dataDeNascimento}" var="dataNascimento" pattern="yyyy-MM-dd"/>
            <fmt:formatDate value="${dataNascimento}" var="dataNascimentoFormatada" pattern="dd/MM/yyyy"/>

        <p> <b>Data de Nascimento:</b> ${dataNascimentoFormatada}</p>
        <p> <b>Email:</b>  ${perfil.email}</p>

        <p> <b>Telefone:</b>  ${perfil.telefone}</p>

        <p> <b>Gênero:</b>  ${perfil.genero}</p>



        </p>
    </div>

    <div id="tags_div">
        <c:if test="${perfil.funcionario}">
            <div class="tags">
                <a href="funcionario">Funcionário</a>

            </div>
        </c:if>
        <c:if test="${perfil.adotante}">
            <div class="tags">
                <a href="">Adotante</a>
            </div>
        </c:if>
        <c:if test="${perfil.tutor}">
            <div class="tags">
                <a href="">Tutor</a>
            </div>
        </c:if>
        <c:if test="${perfil.adm}">
            <div class="tags">
                <p >Administrador</p>
            </div>
        </c:if>
    </div>
    <br>
    <h3>Animais: </h3>
    <div
    style="display: flex; align-items: center; justify-content: center; width: 80%">
        <c:forEach items="${relacoes}" var="relacao">
            <div class="botoes_menu">
                <a href="animal?id=${relacao.animal.id}" >
                    <img src="data:image/jpeg;base64,${relacao.animal.fotoBase64}" width="210" height="210" alt="Foto do animal">
                </a>
            </div>
        </c:forEach>
    </div>


    <c:if test="${logout_true}">
        <div style="display: flex; align-items: center; justify-content: center;">
            <form action="logout" method="post" style="margin: 0">
                <button style="padding: 0.4rem" id="logout" type="submit">Logout</button>
            </form>
            <div style="padding: 0.4rem" id="editar_button">
                <a href="editar">Editar Perfil</a>
            </div>
        </div>
    </c:if>


</div>
</body>
</html>
