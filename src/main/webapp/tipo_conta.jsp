<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patas Amigas</title>
    <link rel="stylesheet" type="text/css" href="css/tipo_conta.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
</head>
<body>
<h1>Patas Amigas</h1>

<div id="register_div">
    <form action="tipo_conta" method="post">

    <div id="step-1">
        <button value="tutor"  type="submit" name="tipo_conta">
            <svg fill="#000000" height="80px" width="80px" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 326.577 326.577" xml:space="preserve">
            <path d="M275.201,55.683c-30.025-9.884-69.769-15.327-111.912-15.327c-42.142,0-81.887,5.443-111.913,15.327
                C8.913,69.662,0,87.578,0,100.146v59.709c0,12.568,8.913,30.484,51.376,44.462c22.988,7.567,51.681,12.52,82.778,14.43
                c4.218,7.774,11.461,13.673,20.135,16.126v10.688h-12.238c0.002-0.105,0.003-0.212,0.003-0.317c0-9.22-7.501-16.721-16.721-16.721
                c-9.22,0-16.721,7.501-16.721,16.721c0,4.77,2.007,9.079,5.222,12.128c-3.215,3.05-5.222,7.359-5.222,12.129
                c0,9.22,7.501,16.721,16.721,16.721c9.22,0,16.721-7.501,16.721-16.721c0-0.106-0.001-0.213-0.003-0.318h42.476
                c-0.002,0.106-0.003,0.212-0.003,0.318c0,9.22,7.501,16.721,16.722,16.721c9.219,0,16.72-7.501,16.72-16.721
                c0-4.77-2.008-9.08-5.222-12.129c3.214-3.049,5.222-7.358,5.222-12.128c0-9.22-7.5-16.721-16.72-16.721
                c-9.22,0-16.722,7.501-16.722,16.721c0,0.105,0.001,0.212,0.003,0.317h-12.238v-10.688c8.674-2.453,15.916-8.352,20.135-16.126
                c31.096-1.91,59.79-6.862,82.777-14.43c42.463-13.977,51.376-31.893,51.376-44.462v-59.71
                C326.577,87.577,317.664,69.661,275.201,55.683z M64.623,129.834c23.256-8.26,56.936-14.338,98.666-14.338
                c41.729,0,75.41,6.078,98.665,14.338c-27.257,7.82-61.892,12.102-98.665,12.102S91.879,137.654,64.623,129.834z M308.577,100.145
                c0,5.408-6.088,13.102-22.017,20.677c-4.082-2.117-8.704-4.19-13.917-6.198v-40.8C299.058,83.038,308.577,93.381,308.577,100.145z
                M57.004,72.781c28.257-9.302,66.003-14.425,106.284-14.425c33.559,0,65.336,3.567,91.354,10.133v40.232
                c-26.054-7.268-57.889-11.226-91.354-11.226c-39.399,0-76.57,5.466-104.666,15.391c-7.187,2.539-13.335,5.203-18.606,7.937
                C24.088,113.248,18,105.554,18,100.146C18,93.125,28.247,82.248,57.004,72.781z M163.289,218.126
                c-8.338,0-15.123-6.784-15.123-15.124c0-8.339,6.784-15.123,15.123-15.123c8.338,0,15.123,6.784,15.123,15.123
                C178.411,211.342,171.627,218.126,163.289,218.126z"/>
            </svg>
            <strong>Tutor</strong><br>
            Responsável pelo cuidado e bem-estar do pet. Você pode adotar um animal e oferecer um lar amoroso.
        </button>
        
        <button value="adotante"  type="submit" name="tipo_conta">
            <svg fill="#000000"  width="80px" height="80px" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg"><title>ionicons-v5-n</title><path d="M490.39,182.75c-5.55-13.19-14.77-22.7-26.67-27.49l-.16-.06a46.46,46.46,0,0,0-17-3.2h-.64c-27.24.41-55.05,23.56-69.19,57.61-10.37,24.9-11.56,51.68-3.18,71.64,5.54,13.2,14.78,22.71,26.73,27.5l.13.05a46.53,46.53,0,0,0,17,3.2c27.5,0,55.6-23.15,70-57.65C497.65,229.48,498.78,202.72,490.39,182.75Z"/><path d="M381.55,329.61c-15.71-9.44-30.56-18.37-40.26-34.41C314.53,250.8,298.37,224,256,224s-58.57,26.8-85.39,71.2c-9.72,16.06-24.6,25-40.36,34.48-18.07,10.86-36.74,22.08-44.8,44.16a66.93,66.93,0,0,0-4.65,25c0,35.95,28,65.2,62.4,65.2,17.75,0,36.64-6.15,56.63-12.66,19.22-6.26,39.09-12.73,56.27-12.73s37,6.47,56.15,12.73C332.2,457.85,351,464,368.8,464c34.35,0,62.3-29.25,62.3-65.2a67,67,0,0,0-4.75-25C418.29,351.7,399.61,340.47,381.55,329.61Z"/><path d="M150,188.85c11.9,14.93,27,23.15,42.52,23.15a42.88,42.88,0,0,0,6.33-.47c32.37-4.76,52.54-44.26,45.92-90C242,102.3,234.6,84.39,224,71.11,212.12,56.21,197,48,181.49,48a42.88,42.88,0,0,0-6.33.47c-32.37,4.76-52.54,44.26-45.92,90C132,157.67,139.4,175.56,150,188.85Z"/><path d="M313.16,211.53a42.88,42.88,0,0,0,6.33.47c15.53,0,30.62-8.22,42.52-23.15,10.59-13.29,17.95-31.18,20.75-50.4h0c6.62-45.72-13.55-85.22-45.92-90a42.88,42.88,0,0,0-6.33-.47C315,48,299.88,56.21,288,71.11c-10.6,13.28-18,31.19-20.76,50.44C260.62,167.27,280.79,206.77,313.16,211.53Z"/><path d="M111.59,308.8l.14-.05c11.93-4.79,21.16-14.29,26.69-27.48,8.38-20,7.2-46.75-3.15-71.65C120.94,175.16,92.85,152,65.38,152a46.4,46.4,0,0,0-17,3.2l-.14.05C36.34,160,27.11,169.54,21.58,182.73c-8.38,20-7.2,46.75,3.15,71.65C39.06,288.84,67.15,312,94.62,312A46.4,46.4,0,0,0,111.59,308.8Z"/></svg>
            <strong>Adotante</strong><br>
            Se você quer dar um lar para um animal, essa opção é para você.
        </button>
        
        <button value="funcionario" type="submit" name="tipo_conta">
            <svg fill="#000000" height="80px" width="80px" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 310.883 310.883" xml:space="preserve">
            <path d="M299.459,174.267c0,0-16.433-71.773-16.707-72.356c-3.429-10.694-17.078-19.279-40.725-25.565
                c-23.243-6.181-53.993-9.584-86.586-9.584c-32.592,0-63.343,3.403-86.586,9.584c-23.657,6.29-37.308,14.879-40.729,25.58
                c-0.272,0.578-16.702,72.342-16.702,72.342C4.778,176.576,0,182.879,0,190.312c0,18.79,17.893,33.075,53.18,42.458
                c27.533,7.32,63.85,11.353,102.261,11.353c0.002,0,0.004,0,0.006,0c38.41,0,74.724-4.031,102.255-11.352
                c35.287-9.383,53.18-23.668,53.18-42.459C310.883,182.879,306.105,176.576,299.459,174.267z M211.452,189.198
                c0,7.987-6.498,14.486-14.485,14.486c-7.755,0-14.107-6.124-14.471-13.79h-54.11c-0.365,7.666-6.715,13.79-14.469,13.79
                c-7.988,0-14.486-6.499-14.486-14.486c0-3.783,1.458-7.232,3.842-9.815c-2.384-2.583-3.842-6.032-3.842-9.815
                c0-7.987,6.499-14.486,14.486-14.486c7.754,0,14.104,6.124,14.469,13.79h54.11c0.364-7.666,6.716-13.79,14.471-13.79
                c7.987,0,14.485,6.499,14.485,14.486c0,3.783-1.458,7.232-3.842,9.815C209.994,181.966,211.452,185.415,211.452,189.198z
                M235.357,120c-21.545,5.448-49.926,8.449-79.916,8.449c-29.99,0-58.371-3.001-79.916-8.449
                c-20.722-5.24-28.012-10.998-29.796-13.382c1.8-2.425,9.104-8.177,29.8-13.409c21.544-5.448,49.924-8.448,79.912-8.448
                c29.987,0,58.367,3,79.911,8.448c20.654,5.223,27.97,10.961,29.789,13.395C263.329,109.033,256.023,114.773,235.357,120z"/>
            </svg>
            <strong>Funcionário</strong><br>
            Funcionário do abrigo responsável por gerenciar o processo de adoção e cuidar dos pets.
        </button>

    </div>
</form>

    <a href="/login">Já tem uma conta? Entre!</a>
</form>

<video class="background-video" autoplay loop muted playsinline>
    <source src="/video/Dogs playing outside. GUARANTEED to make you smile. Most watched video. top. let your dog listen(1).mp4" type="video/mp4">
</video>


<script src="js/register.js"></script> 
</body>
</html>
