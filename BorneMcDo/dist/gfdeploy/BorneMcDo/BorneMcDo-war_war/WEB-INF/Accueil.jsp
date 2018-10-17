<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" />
        <title>Accueil</title>
        <!-- FLC : D'après IMG_1283.jpg -->
    </head>
    <body>
        <c:url value="Controller?section=ScMenu" var="menu" />
        <c:import url="${menu}"/>
        ${message}
        <div class="container">
            <!-- FLC -->
            <h1 class="text-center">Souhaitez-vous accéder à vos avantages<br />avec votre identifiant client ?</h1>
            <div class="row justify-content-center">
                <div class="col">
                    <!-- FLC -->
                    <c:url value="Controller?section=ScChoixConnexion&choix=Oui" var="urlchoixOui" />
                    <a class="btn btn-choix-evide mx-auto" href="${urlchoixOui}" name="choixOui">oui</a>
                    <h4 class="text-center">Je m'identifie</h4>
                    <!-- FLC -->
                    <p class="text-center">Mon prénom sera affiché sur<br />les écrans suivants</p>
                </div>
                <div class="col">
                    <!-- FLC -->
                    <c:url value="Controller?section=ScChoixConnexion&choix=Non" var="urlchoixNon" />
                    <a class="btn btn-choix-evide mx-auto" href="${urlchoixNon}" name="choixNon">non</a>
                    <h4 class="text-center">Je ne m'identifie pas</h4>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
