<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="pt-br">
<head>
    <title>Patas Amigas: Funcionário</title>
    <link rel="stylesheet" type="text/css" href="../css/doar.css">

</head>
<body>
    <header style="width: 98%; display: flex; align-items: center; justify-content: center;padding: 1rem; flex-direction: column;background-color: #ffffff";>
        <img src="images/logo amigos felizes.png" height="130px" alt="logo">
        <a href="/home">Voltar para página inicial</a>
    </header>
    <div id="main">
        funcionario
    </div>

    <div style="height: 300px;">
        <canvas id="grafico_especies"></canvas>
    </div>

    <div style="height: 300px;">
        <canvas id="grafico_racas"></canvas>
    </div>



    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const labelsEspecies = [];
        const dadosEspecies = [];

        const labelsRaca = [];
        const dadosRaca = [];
        

        const coresDisponiveis = [
            'rgba(255, 99, 132, 0.5)',
            'rgba(54, 162, 235, 0.5)',
            'rgba(255, 206, 86, 0.5)',
            'rgba(75, 192, 192, 0.5)',
            'rgba(153, 102, 255, 0.5)',
            'rgba(255, 159, 64, 0.5)'
        ];

        const bordasDisponiveis = [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
        ];

        <c:forEach var="animal" items="${especies}">
            labelsEspecies.push("${animal.tipo}");
            dadosEspecies.push(${animal.quantidade});
        </c:forEach>

        <c:forEach var="animal" items="${cachorros}">
            labelsRaca.push("${animal.tipo}");
            dadosRaca.push(${animal.quantidade});
        </c:forEach>

        const ctxEspecie = document.getElementById('grafico_especies').getContext('2d');
        const graficoEspecie = new Chart(ctxEspecie, {
            type: 'pie',
            data: {
                labels: labelsEspecies,
                datasets: [
                    {
                        label: 'Quantidade de Animais',
                        data: dadosEspecies,
                        backgroundColor: coresDisponiveis,
                        borderColor: bordasDisponiveis,
                        borderWidth: 1
                    }
                ]
            },
            options: {
                responsive: true,
                plugins: {
                    title: {
                        display: true,
                        text: 'Espécies de animais cadastrados',
                        font: {
                            size: 18,
                            weight: 'bold',
                            family: 'Arial, sans-serif'
                        }
                    }
                }
            }
        });

        const ctxRaca = document.getElementById('grafico_racas').getContext('2d');
        const graficoRaca = new Chart(ctxRaca, {
            type: 'pie',
            data: {
                labels: labelsRaca,
                datasets: [
                    {
                        label: 'Quantidade de Animais',
                        data: dadosRaca,
                        backgroundColor: coresDisponiveis,
                        borderColor: bordasDisponiveis,
                        borderWidth: 1
                    }
                ]
            },
            options: {
                responsive: true,
                plugins: {
                    title: {
                        display: true,
                        text: 'Raças de Cachorros',
                        font: {
                            size: 18,
                            weight: 'bold',
                            family: 'Arial, sans-serif'
                        }
                    }
                }
            }
        });
    </script>

</body>
</html>