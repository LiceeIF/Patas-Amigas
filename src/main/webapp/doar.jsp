<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp" />

<html lang="pt-br">
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/doar.css" id="estilo">
</head>
<body>
<div id="main">
    <h2>Doe seu amiguinho!</h2>
    <form action="doar" method="POST" enctype="multipart/form-data" id="form_doar">
        <div class="form-content">
            <div class="form-column">
                <label for="nome">Nome 🖊️</label>
                <input type="text" name="nome" id="nome" required placeholder="Nome do animal">

                <label for="especie">Espécie 🌳</label>
                <select name="especie" id="especie" required>
                    <option value="" disabled selected>Selecione uma espécie</option>
                </select>

                <label for="raca">Raça ⛰️</label>
                <select name="raca" id="raca" required>
                    <option value="" disabled selected>Selecione uma raça</option>
                </select>

                <label for="sexo">Sexo ⚧️:</label>
                <select class="text_label" id="sexo" name="sexo" required>
                    <option value="" disabled selected>Sexo do animal</option>
                    <option value="Macho">Macho</option>
                    <option value="Fêmea">Fêmea</option>
                </select>
            </div>

            <div class="form-column">
                <label for="historico_medico">Histórico Médico 💊</label>
                <input placeholder="Doença X" name="historico_medico" id="historico_medico" required>

                <label for="data_de_nascimento">Data de Nascimento 📅</label>
                <input type="date" name="data_de_nascimento" id="data_de_nascimento" required>

                <label for="data_de_resgate">Data de Resgate 📅</label>
                <input type="date" name="data_de_resgate" id="data_de_resgate" required>

                <label for="foto">Foto 📷</label>
                <input type="file" name="foto" id="foto" required>
            </div>
        </div>

        <div>
            <input id="mandar" type="submit" value="Doar!">
        </div>
    </form>

    <c:if test="${not empty mensagem}">
        <div class="mensagem">
            <c:out value="${mensagem}"/>
        </div>
    </c:if>
</div>

<script src="/js/doar.js"></script>
</body>
</html>
