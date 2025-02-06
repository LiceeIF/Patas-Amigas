<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp" />

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Patas Amigas 🐾</title>
    <link rel="stylesheet" type="text/css" href="../css/tutor.css">
</head>
<body>
<div id="main">
    <div>
        <h3>
            🐶🐱 Quer doar um animalzinho?
            Se tornar um tutor!🐢
        </h3>

        <p style="text-align: center">
            Ao se tornar um tutor, você oferece a um animal a oportunidade de ter um lar cheio de amor e cuidados, contribuindo para o bem-estar dele. Além disso, ao doar animais, você ajuda a reduzir o número de animais abandonados, dando a eles uma chance de viver em um ambiente mais seguro e acolhedor. Como tutor, você não só ganha um amigo leal e companheiro, mas também ajuda a criar um mundo melhor para todos os animais.
        </p>

        <form action="tutor" method="POST">
            <button type="submit" class="btn-tutor">Eu aceito ser um tutor</button>
        </form>
    </div>

</div>
</body>
</html>
