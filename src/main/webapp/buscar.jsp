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

                <form method="POST" action="pesquisar">
                    <label class="categoria-label">
                        <input type="radio" name="categoria" value="animal" onclick="toggleOpcoes('animal-opcoes')">
                        <b>Animais</b>
                    </label>

                    <label class="categoria-label">
                        <input type="radio" name="categoria" value="usuario" onclick="toggleOpcoes('usuario-opcoes')">
                        <b>Usuários</b>
                    </label>

                    <div style="min-height: 325px; width: 100%">
                        <div id="animal-opcoes" class="opcoes">
                            <label><input type="checkbox" name="opcoes" value="Cachorro"> Cachorro</label>
                            <label><input type="checkbox" name="opcoes" value="Gato"> Gato</label>
                            <label><input type="checkbox" name="opcoes" value="Passaro"> Pássaro</label>
                            <label><input type="checkbox" name="opcoes" value="Reptil"> Réptil</label>
                            <label><input type="checkbox" name="opcoes" value="Roedor"> Roedor</label>
                            <label><input type="checkbox" name="opcoes" value="Peixe"> Peixe</label>
                            <label><input type="checkbox" name="opcoes" value="Anfibio"> Anfíbio</label>

                            <button type="submit" class="mandar">
                                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 50 50">
                                    <path d="M 21 3 C 11.621094 3 4 10.621094 4 20 C 4 29.378906 11.621094 37 21 37 C 24.710938 37 28.140625 35.804688 30.9375 33.78125 L 44.09375 46.90625 L 46.90625 44.09375 L 33.90625 31.0625 C 36.460938 28.085938 38 24.222656 38 20 C 38 10.621094 30.378906 3 21 3 Z M 21 5 C 29.296875 5 36 11.703125 36 20 C 36 28.296875 29.296875 35 21 35 C 12.703125 35 6 28.296875 6 20 C 6 11.703125 12.703125 5 21 5 Z"></path>
                                </svg>
                            </button>


                        </div>

                        <div id="usuario-opcoes" class="opcoes">
                            <button type="submit" class="mandar">
                                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" viewBox="0 0 50 50">
                                    <path d="M 21 3 C 11.621094 3 4 10.621094 4 20 C 4 29.378906 11.621094 37 21 37 C 24.710938 37 28.140625 35.804688 30.9375 33.78125 L 44.09375 46.90625 L 46.90625 44.09375 L 33.90625 31.0625 C 36.460938 28.085938 38 24.222656 38 20 C 38 10.621094 30.378906 3 21 3 Z M 21 5 C 29.296875 5 36 11.703125 36 20 C 36 28.296875 29.296875 35 21 35 C 12.703125 35 6 28.296875 6 20 C 6 11.703125 12.703125 5 21 5 Z"></path>
                                </svg>
                            </button>
                        </div>

                    </div>

                </form>


            </div>
            <div id="caixa">
                <div id="resultado" class="container">
                    <c:if test="${categoria == 'animal'}">
                        <c:forEach var="resultado" items="${resultados}">

                                <div class="card-animal">
                                    <img src="data:image/jpeg;base64,${resultado.fotoBase64}" width="210" height="210" alt="Foto do animal" style="border-radius: 25%; margin-bottom: 1rem; width: 220px; height: 220px">
                                    <a href="/animal?id=${resultado.id}" class="nome-animal">${resultado.nome}</a>

                                    <p>${resultado.especie}</p>
                                    <p>${resultado.raca}</p>

                                    <p>
                                        <c:choose>
                                            <c:when test="${resultado.sexo == 'Macho'}">
                                                ♂ Macho
                                            </c:when>
                                            <c:when test="${resultado.sexo == 'Fêmea'}">
                                                ♀ Fêmea
                                            </c:when>
                                            <c:otherwise>
                                                ${resultado.sexo}
                                            </c:otherwise>
                                        </c:choose>
                                    </p>
                                </div>

                        </c:forEach>
                    </c:if>
                    <c:if test="${categoria == 'usuario'}">
                        <c:forEach var="resultado" items="${resultados}">
                            <div class="card-animal">
                                <img src="data:image/jpeg;base64,${resultado.fotoBase64}" width="210" height="210" alt="Foto do usuário"
                                     style="border-radius: 25%; margin-bottom: 1rem; width: 220px; height: 220px">
                                <a href="/perfil?id=${resultado.id}" class="nome-animal">${resultado.nome}</a>

                                <c:if test="${not empty resultado.telefone}">
                                    <p>📞 ${resultado.telefone}</p>
                                </c:if>

                                <p>
                                    <c:choose>
                                        <c:when test="${resultado.genero eq 'Masculino'}">
                                            ♂ Masculino
                                        </c:when>
                                        <c:when test="${resultado.genero eq 'Feminino'}">
                                            ♀ Feminino
                                        </c:when>
                                        <c:otherwise>
                                            ${resultado.genero}
                                        </c:otherwise>
                                    </c:choose>
                                </p>

                                <p>
                                    <c:if test="${resultado.funcionario}">👨‍💼 Funcionário</c:if>
                                    <c:if test="${resultado.tutor}">🐾 Tutor</c:if>
                                    <c:if test="${resultado.adotante}">🏡 Adotante</c:if>
                                </p>
                            </div>
                        </c:forEach>
                    </c:if>

                </div>
            </div>
        </div>
    </body>
</html>
