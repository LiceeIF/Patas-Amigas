<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patas Amigas</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<form action="login" method="POST">
    <img src="images/logo amigos felizes.png" height="500px" alt="logo">

    <label for="email"><b>Email:</b></label>
    <input type="email" placeholder="john.doe@email.com" name="email" id="email" required>

    <label for="senha"><b>Senha:</b></label>
    <input type="password" placeholder="anima$F0fos" name="senha" id="senha" required>

    <h3><a href="/register">Não tem uma conta? Crie!</a></h3>
    <c:if test="${not empty mensagemErro}">
        <div class="erro-mensagem">
            <c:out value="${mensagemErro}"/>
        </div>
    </c:if>
    <input id="sub_button" type="submit" value="Entrar">
</form>

<video class="background-video" autoplay loop muted playsinline>
    <source src="/video/Dogs playing outside. GUARANTEED to make you smile. Most watched video. top. let your dog listen(1).mp4" type="video/mp4">
</video>

</body>
</html>
