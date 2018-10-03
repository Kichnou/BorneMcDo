<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" />
        <title>Catalogue</title>
    </head>
    <body>
        <c:url value="Controller?section=ScMenu" var="menu" />
        <c:import url="${menu}"/>
        ${message}
        <div class="container-fluid">
            <div class="row">
                <div class="col-12" style="height: 20px;"></div>
            </div>
            <div class="row">
                <div class="col-2 text-center">
                    <c:forEach var="s" items="${categorie}">
                        <div class="cat">
                            
                        <a href="Controller?section=ScCatalogue&ref=${s.nom}">
                            <img src="${s.image}"/>
                            <p>${s.nom}</p>
                        </a>
                        </div>
                    </c:forEach> 
                </div>

                <div class="col-7">
                    <div class="row d-flex wrap">

                        <c:forEach var="s" items="${central}">
                            <div class="col-4">
                                <div class="cat-centre">

                                    <a href="Controller?section=ScCatalogue&ref=${s.nom}">
                                        <img src="${s.image}"/>
                                        <p>${s.nom}</p>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                        <c:forEach var="t" items="${test}">
                            <div class="col-4">
                                <div class="cat-article">
                                    <img src="${t.image}"/>
                                    <p>${t.nom}</p>
                                    <a class="btn-plein" href="Controller?section=ScPanier&article=${t.id}">ajouter</a>
                                </div>
                            </div>
                        </c:forEach>    
                    </div>
                </div>
                <div class="col-3">
                    <p>panier</p>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
