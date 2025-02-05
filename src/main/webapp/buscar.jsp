<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp" />

<html lang="pt-br">
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/buscar.css">
    <style>
        .opcoes {
            display: none;
            margin-top: 10px;
        }
    </style>
    <script>
        function toggleOpcoes(id) {
            document.getElementById('animal-opcoes').style.display = "none";
            document.getElementById('usuario-opcoes').style.display = "none";

            if (id) {
                document.getElementById(id).style.display = "block";
            }
        }
    </script>
</head>
    <body>
        <div id="main">
            <div id="buscar">
                <h2>Encontre amigos!</h2>

                <label class="categoria-label">
                    <input type="radio" name="categoria" value="animal" onclick="toggleOpcoes('animal-opcoes')">
                    <b>Animais</b>
                </label>

                <label class="categoria-label">
                    <input type="radio" name="categoria" value="usuario" onclick="toggleOpcoes('usuario-opcoes')">
                    <b>Usuários</b>
                </label>

                <div style="min-height: 250px; width: 100%">
                    <div id="animal-opcoes" class="opcoes">
                        <label><input type="checkbox" value="Cachorro"> Cachorro</label>
                        <label><input type="checkbox" value="Gato"> Gato</label>
                        <label><input type="checkbox" value="Passaro"> Pássaro</label>
                        <label><input type="checkbox" value="Reptil"> Réptil</label>
                        <label><input type="checkbox" value="Roedor"> Roedor</label>
                        <label><input type="checkbox" value="Peixe"> Peixe</label>
                        <label><input type="checkbox" value="Anfibio"> Anfíbio</label>
                    </div>

                    <div id="usuario-opcoes" class="opcoes">
                        <label><input type="checkbox" value="tutor"> Tutor</label>
                        <label><input type="checkbox" value="adotante"> Adotante</label>
                        <label><input type="checkbox" value="funcionario"> Funcionário</label>
                    </div>
                </div>
            </div>
            <div id="resultado">
                    lepo
            </div>
        </div>
    </body>
</html>
