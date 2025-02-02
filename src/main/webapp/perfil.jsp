<%--
  Created by IntelliJ IDEA.
  User: PC João
  Date: 01/02/2025
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>
        ${perfil.nome}
    </h3>
    <h4>
        ${perfil.cpf}
    </h4>
</body>
</html>
