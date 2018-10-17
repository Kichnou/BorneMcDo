<%-- 
    Document   : ChoixPreferenceCommande
    Created on : 2 oct. 2018, 14:53:02
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
        <title>Sur place ou à emporter ?</title>
        <!-- D'après IMG_1285.jpg -->
    </head>
    <body>
        <c:url value="Controller?section=ScMenu" var="menu" />
        <c:import url="${menu}"/>
        ${message}
        <h1>Bonjour,</h1>
        <h2>Que souhaitez-vous faire avec votre commande ?</h2>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col">
                    <!-- Image cliquable : -->
                    <c:url value="Controller?section=ScChoixPreferenceCommande&choix=MangerSurPlace" var="urlMangerSurPlace" />
                    <a href="${urlMangerSurPlace}"><img src="./images/surplace.png" /></a>
                </div>
                <div class="col">
                    <!-- Image cliquable : -->
                    <c:url value="Controller?section=ScChoixPreferenceCommande&choix=EmporterVotreCommande" var="urlEmporterVotreCommande" />
                    <a href="${urlEmporterVotreCommande}"><img src="./images/aemporter.png" /></a>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col">
                    <c:url value="Controller?section=ScAccueil" var="urlAnnuler" />
                    <a class="btn btn-pleinlarge mx-auto" href="${urlAnnuler}">Annuler</a>
                </div>
            </div>
        </div>
    </body>
</html>
