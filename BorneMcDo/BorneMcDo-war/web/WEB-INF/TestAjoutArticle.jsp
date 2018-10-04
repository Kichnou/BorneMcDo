<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--<a href="Controller?section=ScPanier?article=${article.id}">Ajouter article : ${article.nom}</a>--%>
        <c:url value="Controller?section=ScPanier&article=${article.id}" var="panier" />
        <a class="nav-link" href="${panier}">Ajouter article : ${article.nom}</a>
    </body>
</html>
