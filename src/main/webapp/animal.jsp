<%--
  Created by IntelliJ IDEA.
  User: PC João
  Date: 01/02/2025
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="header.jsp" />

<html lang="pt-br">
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/animal.css">

</head>
<style>
    #foto_div{
        width: 50%;
        height: 100%;
        background-image: url('data:image/jpeg;base64,${animal.fotoBase64}');
        background-size: cover;
        background-position: center;
    }
    @media (max-width: 768px) {
        #info, #foto_div {
            width: 100%;
            height: 100vh;
            margin-bottom: 1rem;
        }

        #main {
            flex-direction: column;
        }
    }
</style>
<body>

    <div id="main">
        <div id="foto_div">
        </div>


        <div id="info">
            <h2>${animal.nome}</h2>
            <h3>${animal.statusDeAdocao}</h3>
            <div class="infozinhas">
                <div class="alinha">
                    Especie: <p>${animal.especie}</p>
                </div>
                <div  class="alinha">
                    Raça: <p>${animal.raca}</p>
                </div>
                
            </div>
            <div class="infozinhas">
                <div  class="alinha">
                    Data de nascimento: <p>${animal.dataDeNascimento}</p>
                </div>
                <div  class="alinha">
                    Data de resgate: <p>${animal.dataDeResgate}</p>
                </div>
                
            </div>
            <div class="infozinhas">
                <div class="alinha">
                    Sexo:
                    <p>
                        ${animal.sexo == 'Macho' ? 'Macho ♂' : 'Fêmea ♀️'}
                    </p>
                </div>
                
                <div  class="alinha">
                    Data de resgate: <p>${animal.dataDeResgate}</p>
                </div>
                
            </div>
            <div class="infozinhas">
                <div class="alinha" style="height: 5rem;">
                    Histórico Médico 💊❤️‍:
                    <p>
                        ${animal.historicoMedico}
                    </p>
                </div>
                

                
            </div>
            <c:if test="${animal.statusDeAdocao == 'BuscandoNovoDono'}">
                <form method="POST" action="animal">
                    <input type="submit" value="Solicitar adoção">
                </form>

            </c:if>

        </div>
    </div>



</body>
</html>
