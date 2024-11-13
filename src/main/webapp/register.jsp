<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patas Amigas</title>
    <script>
        function toggleFormFields() {
            var userType = document.querySelector('input[name="userType"]:checked').value;
            
            document.getElementById('tutorFields').style.display = 'none';
            document.getElementById('funcionarioFields').style.display = 'none';
            document.getElementById('adotanteFields').style.display = 'none';

            if (userType === 'tutor') {
                document.getElementById('tutorFields').style.display = 'block';
            } else if (userType === 'funcionario') {
                document.getElementById('funcionarioFields').style.display = 'block';
            } else if (userType === 'adotante') {
                document.getElementById('adotanteFields').style.display = 'block';
            }
        }
    </script>
</head>
<body>
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
            <input type="text" name="cpf">
        </div>

        <div id="funcionarioFields" style="display:none;">
            <label for="">Nome</label>
            <input type="text" name="nome">
            
            <label for="">Data de Nascimento</label>
            <input type="date" name="dataDeNascimento">
        
            <label for="">CPF</label>
            <input type="text" name="cpf">
            
            <label for="">Cargo</label>
            <input type="text" name="cargo">
        </div>

        <div id="adotanteFields" style="display:none;">
            <label for="">Nome</label>
            <input type="text" name="nome">
            
            <label for="">Data de Nascimento</label>
            <input type="date" name="dataDeNascimento">
        
            <label for="">CPF</label>
            <input type="text" name="cpf">
            
            <label for="">CEP</label>
            <input type="text" name="cep">

            <label for="">Número</label>
            <input type="text" name="numeroCasa">
        </div>

        <!-- Campos comuns -->
        <label for="">Email</label>
        <input type="text" name="email">

        <label for="">Senha</label>
        <input type="password" name="senha">
        
        <label for="">Confirme a senha</label>
        <input type="password" name="confirmacaoSenha">

        <input type="submit" name="Enviar">
    </form>
</body>
</html>
