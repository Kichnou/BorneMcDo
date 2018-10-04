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
<<<<<<< HEAD
            <c:url value="Controller?section=ScCommande" var="commande" />
            <a class="nav-link" href="${commande}">commande</a>
=======
            <c:url value="Controller?section=ScTestAjoutArticle" var="testAjoutArticle" />
            <a class="nav-link" href="${testAjoutArticle}">Ajout article</a>
>>>>>>> a78c4681261c9d314caf2700cc7de48f06cebd0a
        </li>
    </ul>
</nav>