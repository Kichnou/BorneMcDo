<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/style.css" />
        <script type="text/javascript" src="./js/jquery.js"></script>
        <script type="text/javascript" src="./js/naviguation.js"></script>
        <fmt:setLocale value="fr_FR"/>
        <title>Catalogue</title>
    </head>

    <script language="javascript">

        function getxmlhttp() {
            xmlhttp = null;
            if (window.XMLHttpRequest) { // Mozilla
                xmlhttp = new XMLHttpRequest();
            } else {
                if (window.ActiveXObject) { // IE
                    try {
                        xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                } else {
                    alert("Votre navigateur ne supporte pas XMLHttpRequest");
                }
            }
            return xmlhttp;
        }

        function go(idArticle) {
            url = "Controller?section=ScPanier&article=" + idArticle;
            //alert(url);

            xmlhttp = getxmlhttp();
            xmlhttp.onreadystatechange = xmlhttpChange;
            xmlhttp.open("GET", url, true);
            xmlhttp.send(null);
        }

        function xmlhttpChange() {
            if (xmlhttp.readyState == 4) {
                if (xmlhttp.status == 200) {
                    s = xmlhttp.responseText;
                    d = document.getElementById("panier");
                    d.innerHTML = "";
                    d.innerHTML = s;
                } else {
                    alert("Problem retrieving XML data");
                }
            }
        }

    </script>

    <body>
        <c:url value="Controller?section=ScMenu" var="menu" />
        <c:import url="${menu}"/>
        ${message}
        <div class="container-fluid">
            <div class="row">
                <div class="col-12" style="height: 20px;"></div>
            </div>
            <div class="row">
                <!-- section sidebar -->
                <%@include file="sidebar.jsp" %>
                <!-- section central -->   
                <div class="col-7" id="contenu">
                    <div class="row d-flex wrap">
                        <c:forEach var="c" items="${central}">
                            <div class="col-4">
                                <div class="cat-centre">
                                    <a class="cat-centre" href="Controller?section=ScCatalogue&cat=${c.nom}">
                                        <img class="cat-centre" src="${c.image}"/>
                                        <p class="cat-centre">${c.nom}</p>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                        <c:forEach var="a" items="${article}">
                            <div class="col-4">
                                <div class="cat-article">
                                    <img class="cat-article" src="${a.image}"/>
                                    <p class="text-center">${a.nom}</p>
                                    <a class="btn-plein" href="#" onclick="go(${a.id});
                                            return false">${a.prix} €</a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <!-- panier -->
                <div class="col-3">
                    <p>panier</p>
                    <div id="panier">
                        <c:url value="Controller?section=ScPanier" var="panier" />
                        <c:import url="${panier}"/>
                    </div>
                </div>                   

            </div>  
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
