<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand -->
    <c:url value="Controller?section=ScAccueil" var="url01" />
    <a class="navbar-brand" href="${url01}" ><img src="./images/logo.png" alt="logo" style="width: 40px; height: 40px;"></a>
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <c:url value="Controller?section=ScAccueil" var="accueil" />
            <a class="nav-link" href="${accueil}">créer les données</a>
        </li>
        <li class="nav-item">
            <c:url value="Controller?section=ScCatalogue" var="catalogue" />
            <a class="nav-link" href="${catalogue}">catalogue</a>
        </li>
        <li class="nav-item">
            <c:url value="Controller?section=ScCommande" var="commande" />
            <a class="nav-link" href="${commande}">commande</a>
<<<<<<< HEAD
        </li>        
=======
        </li>
        <li class="nav-item">
            <c:url value="Controller?section=ScCommande&ref=control" var="ecranControle" />
            <a class="nav-link" href="${ecranControle}">Ecran commandes cuisine</a>
        </li>
>>>>>>> 6fbaff333c0897ce0e03cd38111e09e9ea469373
    </ul>
</nav>