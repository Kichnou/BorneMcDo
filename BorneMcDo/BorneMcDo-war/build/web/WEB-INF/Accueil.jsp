<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <c:url value="Controller?section=ScAccueil" var="url02" />
            <a class="nav-link" href="${url02}">creer les données</a>
        <p>message : ${message}</p>
    </body>
</html>
