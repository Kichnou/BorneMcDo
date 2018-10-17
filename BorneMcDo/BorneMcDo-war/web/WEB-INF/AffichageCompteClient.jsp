<%-- 
    Document   : AffichageCompteClient
    Created on : 1 oct. 2018, 11:32:39
    Author     : cdi315
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" />
        <title>Informations relatives au client</title>
    </head>
    <body class ="indentation">
        <c:url value="Controller?section=ScMenu" var="menu" />
        <c:import url="${menu}"/>
        ${message}
        <h1>Bonjour ${prenomClient} ${nomClient},</h1>
        <p>${infoEnseigne} ${infoNom} est heureux de vous accueillir.</p>
        <h2>Voici les informations contenues dans votre compte client :</h2>
        <p>Vous vous appelez ${prenomClient} ${nomClient}.</p>
        <p>Vous êtes notre membre numéro ${numeroMembre}.</p>
        <p>Actuellement, vous avez ${pointsFidelite} points de fidélité sur votre compte.</p>
        <h2>Que souhaitez-vous faire ?</h2>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col">
                    <c:url value="Controller?section=ScCatalogue" var="urlPasserUneCommande" />
                    <a class="btn btn-pleinlarge mx-auto" href="${urlPasserUneCommande}">Passer une commande</a>
                </div>
                <div class="col">
                    <c:url value="Controller?section=ScAccueil" var="urlAnnuler" />
                    <a class="btn btn-pleinlarge mx-auto" href="${urlAnnuler}">Annuler</a>
                </div>
            </div>
        </div>
    </body>
</html>
