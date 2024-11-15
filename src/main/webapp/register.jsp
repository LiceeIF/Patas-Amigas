<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patas Amigas</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
</head>
<body>
<h1>Patas Amigas</h1>
<form action="register" method="POST">
    <div>
        <label>
            <input type="radio" name="contaTipo" value="tutor" onclick="toggleFormFields()" required> Tutor
        </label>
        <label>
            <input type="radio" name="contaTipo" value="funcionario" onclick="toggleFormFields()" required> Funcionário
        </label>
        <label>
            <input type="radio" name="contaTipo" value="adotante" onclick="toggleFormFields()" required> Adotante
        </label>

    </div>

    <label for="nome">Nome</label>
    <input type="text" name="nome" id="nome" required>

    <label for="dataDeNascimento">Data de Nascimento</label>
    <input type="date" name="dataDeNascimento" id="dataDeNascimento" required>

    <label for="cpf">CPF</label>
    <input placeholder="123.456.789-00" type="text" name="cpf" id="cpf" maxlength="11" required>

    <div>
        <label for="cep">CEP</label>
        <input placeholder="12345-678" type="text" name="cep" id="cep" required>

        <label for="numeroCasa">Número</label>
        <input type="number" name="numeroCasa" id="numeroCasa" required>
    </div>

    <label for="telefone">Telefone</label>
    <input placeholder="(00)00000-0000" type="text" name="telefone" id="telefone" maxlength="11" required>

    <label for="email">Email</label>
    <input type="email" name="email" id="email" required>

    <label for="senha">Senha</label>
    <input type="password" name="senha" id="senha" required>

    <label for="confirmacaoSenha">Confirmação de senha</label>
    <input type="password" name="confirmacaoSenha" id="confirmacaoSenha" required>

    <a href="/login">Já tem uma conta? Entre!</a>
    <input id="sub_button" type="submit" value="Cadastrar">
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
