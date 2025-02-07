<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="pt-br">
<head>
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>

    <style>

        :root{
            --zidexvalue: -3;
        }

        @keyframes next {
            50% {
                transform: translate(-600px, 0);
            }
            100% {
                z-index: var(--zidexvalue);
            }
        }

        .photos img:nth-child(1) {
            z-index: 1;
            transform: rotate(7deg) translate(-20px, -20px);
            animation: next 1.4s 12s  forwards;
        }

        .photos img:nth-child(2) {
            z-index: -1;
            transform: rotate(-5deg) translate(80px, -60px);
            animation: next 1.4s 24s  forwards;
        }



    </style>


    <div id="main">

        <div id="logo_div">

            <img src="images/logo amigos felizes.png" height="500px" alt="logo">
            <h2  style="text-align:center; margin:1rem; max-width: 40%; font-weight: lighter">Bem-vindo ao Patas Amigas! Nosso site conecta pessoas dispostas a adotar um pet a animais em busca de um lar. Aqui, você encontrará cães, gatos e outros animais prontos para serem parte da sua vida. Adote um amigo e transforme a vida de um animalzinho com muito amor e carinho!</h2>
            <div style="margin-top: 1rem">
                <a style="width: 50%" href="/login"><b>Login!</b></a>
                <a style="width: 50%" href="/register"><b>Cadastrar</b></a>
            </div>


        </div>


        <div class="photos">

            <img src="images/happy_pitubl.jpg"   alt="smilling pitbull">
            <img src="images/bird.jpg" alt="happy bird">
        </div>



    </div>
    <div class="github">
        <div class="colaboradores">
            <button id="gitAna"><img src="https://avatars.githubusercontent.com/u/125521908?v=4" alt="Foto Alice"></button>
            <span>Alice Maria</span>
        </div>

        <div class="colaboradores">
            <button id="gitAna"><img src="https://avatars.githubusercontent.com/u/125326119?v=4" alt="Foto Ana"></button>
            <span>Ana Luísa</span>
        </div>

        <div class="colaboradores">
            <button id="gitCarlos"><img src="https://avatars.githubusercontent.com/u/126599111?v=4" alt="Foto Carlos"></button>
            <span>Carlos Alberto</span>
        </div>

        <div class="colaboradores">
            <button id="gitJoao"><img src="https://avatars.githubusercontent.com/u/127232326?v=4" alt="Foto João"></button>
            <span>João Augusto</span>
        </div>
    </div>
        <script>
            let zIndexValue = -3;

            const photos = document.querySelectorAll('.photos img');

            photos.forEach(img => {
                img.addEventListener('animationend', () => {
                    zIndexValue--;

                    document.documentElement.style.setProperty('--zidexvalue', zIndexValue);
                });
            });
        </script>
</body>
</html>