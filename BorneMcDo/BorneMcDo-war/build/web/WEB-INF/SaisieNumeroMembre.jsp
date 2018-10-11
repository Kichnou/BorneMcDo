<%--
    Document   : SaisieNumeroMembre
    Created on : 28 sept. 2018, 09:58:18
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
        <title>Saisie de votre numéro de membre</title>
        <!-- Pas de photographie associée à cet écran -->
    </head>
    <body>
        <h1>Bonjour,</h1>
        <!-- FLCàfaire : il y a quelque chose qui m'echappe sur get et post -->
        <form action="Controller?section=ScSaisieNumeroMembre" method="post">
            <!--
                NOTA : Expression régulière pour saisir un nombre comportant au
                moins un chiffre et qui ne commence pas par zéro.
            -->
            <h2 class="text-center">
                <label for="numeroMembre">Veuillez saisir votre numéro de membre : </label><br />
                <input type="text" pattern="[1-9]+[0-9]*" title="Veuillez saisir un nombre comportant au moins un chiffre et ne commençant pas par zéro." name="numeroMembre" id="numeroMembre" required />
            </h2>    
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col">
                        <input type="submit" class="btn btn-plein mx-auto" value="Valider" />
                    </div>
                    <div class="col">
                        <c:url value="Controller?section=ScAccueil" var="urlAnnuler" />
                        <a class="btn btn-plein mx-auto" href="${urlAnnuler}">Annuler</a>
                    </div>
                </div>
            </div>
        </form>
        <p class="erreur">${messageErreurNumeroMembreInvalide}</p>
    </body>
</html>
