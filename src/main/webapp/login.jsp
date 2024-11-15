<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patas Amigas</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<h1>Patas Amigas</h1>
<form action="login" method="POST">
    <label for="email">Email</label>
    <input type="email" name="email" id="email" required>

    <label for="senha">Senha</label>
    <input type="password" name="senha" id="senha" required>

    <a href="/register">Não tem uma conta? Crie!</a>
    <input id="sub_button" type="submit" value="Entrar">
</form>

<video class="background-video" autoplay loop muted playsinline>
    <source src="/video/Dogs playing outside. GUARANTEED to make you smile. Most watched video. top. let your dog listen(1).mp4" type="video/mp4">
</video>

</body>
</html>
