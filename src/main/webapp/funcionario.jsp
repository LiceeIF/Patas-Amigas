<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="pt-br">
<head>
    <title>Patas Amigas: Funcionário</title>
    <link rel="stylesheet" type="text/css" href="../css/funcionario.css">

</head>
<body>
    <header style="width: 98%; display: flex; align-items: center; justify-content: center;padding: 1rem; flex-direction: column;background-color: #ffffff";>
        <img src="images/logo amigos felizes.png" height="130px" alt="logo">
        <a href="/home">Voltar para página inicial</a>
    </header>
    <div id="main">
        <div id="graficos">
            <div>
                <div style="height: 400px;">
                    <canvas id="grafico_especies"></canvas>
                </div>
        
                <div style="height: 400px;">
                    <canvas id="grafico_racas"></canvas>
                </div>
            </div>
            
            <div>
                <div style="height: 400px;">
                    <canvas id="grafico_gato"></canvas>
                </div>
        
                <div style="height: 400px;">
                    <canvas id="grafico_passaro"></canvas>
                </div>
            </div>
        </div>
        <div style="max-height: 80%; overflow-x: auto; width: 100%; padding: 1rem;">
            <table width="100%" style="min-width: 800px;">
                <caption>Registros</caption>

                <tr>
                    <th>Id</th>
                    <th>Ação</th>
                    <th>Descrição</th>
                    <th>Id usuário</th>
                    <th>Data</th>
                </tr>
                <c:forEach var="registro" items="${registros}">
                    <tr>
                        <td>${registro.id}</td>
                        <td>${registro.tipoAcao}</td>
                        <td>${registro.descricao}</td>
                        <td>${registro.pessoaId}</td>
                        <td>${registro.dataAcao}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>


    </div>



    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const labelsEspecies = [];
        const dadosEspecies = [];

        const labelsRaca = [];
        const dadosRaca = [];

        const labelsGato = [];
        const dadosGato = [];

        const labelsPassaro = [];
        const dadosPassaro = [];
        

        const coresDisponiveis = [
        'rgba(255, 99, 132, 0.5)', 'rgba(54, 162, 235, 0.5)', 'rgba(255, 206, 86, 0.5)',
        'rgba(75, 192, 192, 0.5)', 'rgba(153, 102, 255, 0.5)', 'rgba(255, 159, 64, 0.5)',
        'rgba(255, 0, 0, 0.5)', 'rgba(0, 255, 0, 0.5)', 'rgba(0, 0, 255, 0.5)',
        'rgba(128, 0, 128, 0.5)', 'rgba(255, 165, 0, 0.5)', 'rgba(0, 128, 128, 0.5)',
        'rgba(255, 20, 147, 0.5)', 'rgba(139, 69, 19, 0.5)', 'rgba(0, 255, 255, 0.5)',
        'rgba(127, 255, 212, 0.5)', 'rgba(218, 112, 214, 0.5)', 'rgba(184, 134, 11, 0.5)',
        'rgba(85, 107, 47, 0.5)', 'rgba(255, 69, 0, 0.5)', 'rgba(47, 79, 79, 0.5)',
        'rgba(220, 20, 60, 0.5)', 'rgba(60, 179, 113, 0.5)', 'rgba(72, 61, 139, 0.5)',
        'rgba(30, 144, 255, 0.5)', 'rgba(240, 230, 140, 0.5)', 'rgba(123, 104, 238, 0.5)'
    ];
    
    const bordasDisponiveis = [
        'rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)',
        'rgba(255, 0, 0, 1)', 'rgba(0, 255, 0, 1)', 'rgba(0, 0, 255, 1)',
        'rgba(128, 0, 128, 1)', 'rgba(255, 165, 0, 1)', 'rgba(0, 128, 128, 1)',
        'rgba(255, 20, 147, 1)', 'rgba(139, 69, 19, 1)', 'rgba(0, 255, 255, 1)',
        'rgba(127, 255, 212, 1)', 'rgba(218, 112, 214, 1)', 'rgba(184, 134, 11, 1)',
        'rgba(85, 107, 47, 1)', 'rgba(255, 69, 0, 1)', 'rgba(47, 79, 79, 1)',
        'rgba(220, 20, 60, 1)', 'rgba(60, 179, 113, 1)', 'rgba(72, 61, 139, 1)',
        'rgba(30, 144, 255, 1)', 'rgba(240, 230, 140, 1)', 'rgba(123, 104, 238, 1)'
    ];
    

        <c:forEach var="animal" items="${especies}">
            labelsEspecies.push("${animal.tipo}");
            dadosEspecies.push(${animal.quantidade});
        </c:forEach>

        <c:forEach var="animal" items="${cachorros}">
            labelsRaca.push("${animal.tipo}");
            dadosRaca.push(${animal.quantidade});
        </c:forEach>
        
        <c:forEach var="animal" items="${gatos}">
            labelsGato.push("${animal.tipo}");
            dadosGato.push(${animal.quantidade});
        </c:forEach>
        
        <c:forEach var="animal" items="${passaros}">
            labelsPassaro.push("${animal.tipo}");
            dadosPassaro.push(${animal.quantidade});
        </c:forEach>
        

        const ctxEspecie = document.getElementById('grafico_especies').getContext('2d');
        const graficoEspecie = new Chart(ctxEspecie, {
            type: 'polarArea',
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
    
        const ctxGato = document.getElementById('grafico_gato').getContext('2d');
        const graficoGato = new Chart(ctxGato, {
            type: 'pie',
            data: {
                labels: labelsGato,
                datasets: [
                    {
                        label: 'Quantidade de Animais',
                        data: dadosGato,
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
                        text: 'Raças de Gato',
                        font: {
                            size: 18,
                            weight: 'bold',
                            family: 'Arial, sans-serif'
                        }
                    }
                }
            }
        });

        const ctxPassaro = document.getElementById('grafico_passaro').getContext('2d');
        const graficoPassaro = new Chart(ctxPassaro, {
            type: 'pie',
            data: {
                labels: labelsPassaro,
                datasets: [
                    {
                        label: 'Quantidade de Animais',
                        data: dadosPassaro,
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
                        text: 'Raças de Pássaros',
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