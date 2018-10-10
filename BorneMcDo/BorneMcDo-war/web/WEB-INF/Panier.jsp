<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<p>Prix total : ${prixTotal}<br></p>

${panierVide}

<c:forEach var="a" items="${listeArticle}">
    ${a.nom}<br>
</c:forEach>

