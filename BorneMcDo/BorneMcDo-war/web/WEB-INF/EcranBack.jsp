<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" />
        <title>Controle cuisine</title>
    </head>
    <body>
        <div class="container-fluid">

            <div class="row test">
                <c:forEach var="i" items="${comEnPrepa}">
                    <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3 control">
                        <h4 class="col-sm-12 titre">commande ${i.identifiantCourt}</h4><br/>
                        <p class="heure"><fmt:formatDate value="${i.heure}" pattern="dd/MM/yyyy HH:mm:ss"/></p>
                        <c:forEach var="a" items="${panier}">
                            <p class="article"> ${a.unArticle.nom}</p>
                        </c:forEach>
                        <%
                        //<p class="suping"> sans oignon</p>
                        //<p class="suping">nappage chocolat</p>
                        //<p class="suping">sans cacahuète</p>
                        %>
                    </div>
                </c:forEach>
            </div>

        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    </body>
</html>
