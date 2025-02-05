<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<html lang="pt-br">
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/editar_perfil.css">
</head>
<body>
<div id="main">
    <form action="editar" method="POST" enctype="multipart/form-data">

        <label for="foto">Foto</label>
        <input class="text_label" type="file" name="foto" id="foto" required>

        <label for="nome">Nome</label>
        <input class="text_label" type="text" name="nome" id="nome" value="${perfil.nome}" required>

        <label for="genero">Gênero:</label>
        <select class="text_label" id="genero" name="genero" required>
            <option value="Homem" ${perfil.genero== 'Homem' ? 'selected' : ''}>Homem</option>
            <option value="Mulher" ${perfil.genero == 'Mulher' ? 'selected' : ''}>Mulher</option>
            <option value="Não Binário" ${perfil.genero == 'Não Binário' ? 'selected' : ''}>Não Binário</option>
            <option value="Intersexo" ${perfil.genero == 'Intersexo' ? 'selected' : ''}>Intersexo</option>
        </select>


        <label for="telefone">Telefone</label>
        <input class="text_label" placeholder="(00)00000-0000" type="text" name="telefone" id="telefone" value="${perfil.telefone}" maxlength="11" required>

        <label for="email">Email</label>
        <input class="text_label" type="email" name="email" id="email" required value="${perfil.email}">

        <label for="senha">Senha</label>
        <input class="text_label" type="password" name="senha" id="senha" required>

        <c:if test="${not empty mensagemErro}">
            <div class="erro-mensagem">
                <c:out value="${mensagemErro}"/>
            </div>
        </c:if>

        <input id="next_button" type="submit" value="Salvar">
    </form>
</div>
</body>
</html>
