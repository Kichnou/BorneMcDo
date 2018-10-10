<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-2 text-center">
    <c:forEach var="s" items="${categorie}">
        <div class="cat">

            <a href="Controller?section=ScCatalogue&cat=${s.nom}">
                <img src="${s.image}"/>
                <p>${s.nom}</p>
            </a>
        </div>
    </c:forEach> 
</div>
