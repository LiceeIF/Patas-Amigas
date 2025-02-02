<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp" />

<html lang="pt-br">
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/doar.css">
</head>
<body>
    <div id="main">
        <form action="doar" method="POST" enctype="multipart/form-data" id="form_doar">
            <label for="nome">Nome</label>
            <input type="text" name="nome" id="nome" required>

            <label for="nome">Espécie</label>
            <input type="text" name="especie" id="especie" required>

            <label for="nome">Raça</label>
            <input type="text" name="raca" id="raca" required>


            <label for="sexo">Sexo:</label>
            <select class="text_label" id="sexo" name="sexo" required>
                <option value="" disabled selected>Qual seu gênero</option>
                <option value="Macho">Macho</option>
                <option value="Fêmea">Fêmea</option>
            </select>

            <label for="historico_medico"></label>
            <textarea name="historico_medico" id="historico_medico" required></textarea>
    
            <label for="data_de_resgate">Data de Resgate</label>
            <input type="date" name="data_de_resgate" id="data_de_resgate" required>

            <label for="data_de_nascimento">Data de Nascimento</label>
            <input type="date" name="data_de_nascimento" id="data_de_nascimento" required>

            <label for="foto">Foto</label>
            <input type="file" name="foto" id="foto" required>

            <input type="submit" name="" id="">
        </form>

        <c:if test="${not empty mensagem}">
            <div class="mensagem">
                <c:out value="${mensagem}"/>
            </div>
        </c:if>


    </div>
</body>
</html>