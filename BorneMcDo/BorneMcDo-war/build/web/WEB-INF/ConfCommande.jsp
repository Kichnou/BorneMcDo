<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" />
        <title>Confirmation commande</title>
    </head>
    <body>
        <c:url value="Controller?section=ScMenu" var="menu"/>
        <c:import url="${menu}"/>
        <h1 class="text-center">Votre commande est-elle exacte?<br/></h1>
        <div class="container">  
            <c:if test="${!noSandwich}">
                <div class="row btn-cadre-conf">
                    <p class="col-12 sandwich">${nbSandwichs} SANDWICH<c:if test="${nbSandwichs > 1}">S</c:if></p><br/>
                    <c:forEach var="a" items="${sandwichs}">
                        <div class="col-2 artCom">
                            <img src="${a.unArticle.image}" height="90px" width="109px"/>
                            ${a.unArticle.nom}
                        </div>
                    </c:forEach>
                </div>  
            </c:if>
            <c:if test="${!noSalades}">
                <div class="row btn-cadre-conf">
                    <p class="col-12 sandwich">${nbSalades} SALADE<c:if test="${nbSalades > 1}">S</c:if></p><br/></p><br/>
                    <c:forEach var="a" items="${salades}">
                        <div class="col-2 artCom">
                            <img src="${a.unArticle.image}" height="90px" width="109px"/>
                            ${a.unArticle.nom}
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!noFrites}">
                <div class="row btn-cadre-conf">
                    <p class="col-12 sandwich">${nbFrites} FRITE<c:if test="${nbFrites > 1}">S</c:if></p><br/>
                    <c:forEach var="a" items="${frites}">
                        <div class="col-2 artCom">
                            <img src="${a.unArticle.image}" height="90px" width="109px"/>
                            ${a.unArticle.nom}
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!noBoissons}">
                <div class="row btn-cadre-conf">
                    <p class="col-12 sandwich">${nbBoissons} BOISSON<c:if test="${nbBoissons > 1}">S</c:if></p><br/>

                    <c:forEach var="a" items="${boissons}">
                        <div class="col-2 artCom">
                            <img src="${a.unArticle.image}" height="90px" width="109px"/>
                            ${a.unArticle.nom}
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!noSauces}">
                <div class="row btn-cadre-conf">
                    <p class="col-12 sandwich">${nbSauces} SAUCE<c:if test="${nbSauces > 1}">S</c:if></p><br/>
                    <c:forEach var="a" items="${sauces}">
                        <div class="col-2 artCom">
                            <img src="${a.unArticle.image}" height="90px" width="109px"/>
                            ${a.unArticle.nom}
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!noDesserts}">
                <div class="row btn-cadre-conf">
                    <p class="col-12 sandwich">${nbDesserts} DESSERT<c:if test="${nbDesserts > 1}">S</c:if></p><br/>
                    <c:forEach var="a" items="${desserts}">
                        <div class="col-2 artCom">
                            <img src="${a.unArticle.image}" height="90px" width="109px"/>
                            ${a.unArticle.nom}
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${!noCadeaux}">
                <div class="row btn-cadre-conf">
                    <p class="col-12 sandwich">${nbCadeaux} CADEAUX<c:if test="${nbCadeaux > 1}">S</c:if></p><br/>
                    <c:forEach var="a" items="${cadeaux}">
                        <div class="col-2 artCom">
                            <img src="${a.unArticle.image}" height="90px" width="109px"/>
                            ${a.unArticle.nom}
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </div>


        <br/><br/>
        <div class="container">
            <a class="btn btn-danger" href="Controller?section=ScCommande&ref=cancel">Continuer la commande</a>
            <a class="btn btn-confirm" href="Controller?section=ScCommande&ref=conf">Finaliser la commande</a>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
