<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
</head>
<body>
<form action="register" method="POST">
    <img src="images/logo amigos felizes.png" height="200px" alt="logo">

    <div class="form-row">
        <div>
            <label for="nome"><b>Nome</b></label>
            <input class="text_label" type="text" name="nome" placeholder="Quirino Professor" id="nome" required>

            <label for="cpf"><b>CPF</b></label>
            <input class="text_label" placeholder="123.456.789-00" type="text" name="cpf" id="cpf" maxlength="11" required>

            <label for="genero"><b>Gênero</b></label>
            <select class="text_label" id="genero" name="genero">
                <option value="" disabled selected>Qual seu gênero</option>
                <option value="Homem">Homem</option>
                <option value="Mulher">Mulher</option>
                <option value="Não Binário">Não Binário</option>
                <option value="Intersexo">Intersexo</option>
            </select>

            <label for="telefone"><b>Telefone</b></label>
            <input class="text_label" placeholder="(00)00000-0000" type="text" name="telefone" id="telefone" maxlength="11" required>
        </div>
        <div>
            <label for="dataDeNascimento"><b>Data de Nascimento</b></label>
            <input class="text_label" type="date" name="dataDeNascimento" id="dataDeNascimento" required>

            <label for="email"><b>Email</b></label>
            <input class="text_label" placeholder="seu.email@email.com" type="email" name="email" id="email" required>

            <label for="senha"><b>Senha</b></label>
            <input class="text_label" placeholder="minhaSenhaCachorros" type="password" name="senha" id="senha" required>

            <label for="confirmacaoSenha"><b>Confirmação de senha</b></label>
            <input class="text_label" placeholder="minhaSenhaCachorros" type="password" name="confirmacaoSenha" id="confirmacaoSenha" required>
        </div>
    </div>

    <h3><a href="/login" style="margin-bottom: 2rem">Já tem uma conta? Entre!</a></h3>

    <c:if test="${not empty mensagemErro}">
        <div class="erro-mensagem">
            <c:out value="${mensagemErro}"/>
        </div>
    </c:if>

    <input id="next_button" type="submit" value="Cadastrar">
</form>

<video class="background-video" autoplay loop muted playsinline>
    <source src="/video/Dogs playing outside. GUARANTEED to make you smile. Most watched video. top. let your dog listen(1).mp4" type="video/mp4">
</video>
<script>
    const video = document.querySelector('.background-video');
    video.playbackRate = 0.75;
    $("#cpf").mask("000.000.000-00");
    $("#cep").mask("00000-000");
    $("#telefone").mask("(00)00000-0000");
</script>
</body>
</html>
