<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patas Amigas</title>
    <link rel="stylesheet" type="text/css" href="css/register.css">

    <script>
        function toggleFormFields() {
            var contaTipo = document.querySelector('input[name="contaTipo"]:checked').value;
            if (!contaTipo) return; 
            document.getElementById('tutorFields').style.display = 'none';
            document.getElementById('funcionarioFields').style.display = 'none';
            document.getElementById('adotanteFields').style.display = 'none';

            if (contaTipo === 'tutor') {
                document.getElementById('tutorFields').style.display = 'block';
            } else if (contaTipo === 'funcionario') {
                document.getElementById('funcionarioFields').style.display = 'block';
            } else if (contaTipo === 'adotante') {
                document.getElementById('adotanteFields').style.display = 'block';
            }
        }
    </script>
</head>
<body>
    <h1>Patas Amigas</h1>
    <form action="register" method="POST">
        <label><input type="radio" name="contaTipo" value="tutor" onclick="toggleFormFields()"> Tutor</label>
        <label><input type="radio" name="contaTipo" value="funcionario" onclick="toggleFormFields()"> Funcionário</label>
        <label><input type="radio" name="contaTipo" value="adotante" onclick="toggleFormFields()"> Adotante</label>

        <div id="tutorFields" style="display:none;">
            <label for="">Nome</label>
            <input type="text" name="nome">
            
            <label for="">Data de Nascimento</label>
            <input type="date" name="dataDeNascimento">
        
            <label for="">CPF</label>
            <input type="text" name="cpf" maxlength="11">

            <label for="">CEP</label>
            <input type="text" name="cep">

            <label for="">Número</label>
            <input type="text" name="numeroCasa">

            <label for="">Telefone</label>
            <input type="text" name="telefone" maxlength="11">

            <label for="">Email</label>
            <input type="text" name="email">

            <label for="">Senha</label>
            <input type="password" name="senha">

            <label for="">Confirmação de senha</label>
            <input type="password" name="confirmacaoSenha">

            <input type="submit" value="Cadastrar">
        </div>

        <div id="funcionarioFields" style="display:none;">
            <label for="">Nome</label>
            <input type="text" name="nome">
            
            <label for="">Data de Nascimento</label>
            <input type="date" name="dataDeNascimento">
        
            <label for="">CPF</label>
            <input type="text" name="cpf" maxlength="11">

            <label for="">CEP</label>
            <input type="text" name="cep">

            <label for="">Número</label>
            <input type="text" name="numeroCasa">

            <label for="">Telefone</label>
            <input type="text" name="telefone" maxlength="11">

            <label for="">Email</label>
            <input type="text" name="email">

            <label for="">Senha</label>
            <input type="password" name="senha">

            <label for="">Confirmação de senha</label>
            <input type="password" name="confirmacaoSenha">

            <input type="submit" value="Cadastrar">

        </div>

        <div id="adotanteFields" style="display:none;">
            <label for="">Nome</label>
            <input type="text" name="nome">
            
            <label for="">Data de Nascimento</label>
            <input type="date" name="dataDeNascimento">
        
            <label for="">CPF</label>
            <input type="text" name="cpf" maxlength="11">

            <label for="">CEP</label>
            <input type="text" name="cep">

            <label for="">Número</label>
            <input type="text" name="numeroCasa">

            <label for="">Telefone</label>
            <input type="text" name="telefone" maxlength="11">

            <label for="">Email</label>
            <input type="text" name="email">

            <label for="">Senha</label>
            <input type="password" name="senha">

            <label for="">Confirmação de senha</label>
            <input type="password" name="confirmacaoSenha">

            <input type="submit" value="Cadastrar">

        </div>
   
    </form>
    <video  class="background-video" autoplay loop muted plays-inline>
        <source src="/video/Dogs playing outside. GUARANTEED to make you smile. Most watched video. top. let your dog listen(1).mp4" type="video/mp4">
    </video>

    <script>
        const video = document.querySelector('.background-video');
        video.playbackRate = 0.75;
    </script>
</body>
</html>
