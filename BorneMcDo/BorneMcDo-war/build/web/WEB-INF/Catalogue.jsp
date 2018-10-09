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
        <title>Catalogue</title>
    </head>
    
    <script language="javascript">
        
        function getxmlhttp() {
        xmlhttp= null;
        if( window.XMLHttpRequest) { // Mozilla
            xmlhttp= new XMLHttpRequest();
        } else {
            if( window.ActiveXObject) { // IE
                try { xmlhttp= new ActiveXObject( "Msxml2.XMLHTTP");
                } catch (e) { xmlhttp= new ActiveXObject( "Microsoft.XMLHTTP");
                }
            } else {
                alert( "Votre navigateur ne supporte pas XMLHttpRequest");
            }
        }
        return xmlhttp;
    }

    function go() {
        url= "Controller?section=ScPanier&article=";
        // alert( url);

        xmlhttp= getxmlhttp();
        xmlhttp.onreadystatechange=xmlhttpChange;
        xmlhttp.open("GET",url,true);
//      xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xmlhttp.send(null);
    }

    function xmlhttpChange() {
        if (xmlhttp.readyState==4) { // if xmlhttp shows "loaded"
            if (xmlhttp.status==200) { // if "OK"
                s= xmlhttp.responseText;
                // alert( "("+s+")");
                d = document.getElementById("panier");
                d.innerHTML= "coucou";
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
<<<<<<< HEAD
                <div class="col-7">
                    <div class="row d-flex wrap">
                        <c:forEach var="s" items="${central}">
                            <div class="col-4">
                                <div class="cat-centre">

                                    <a href="Controller?section=ScCatalogue&cat=${s.nom}">
                                        <img src="${s.image}"/>
                                        <p>${s.nom}</p>
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                  
   
                        <c:forEach var="a" items="${article}">
                            <div class="col-4">
                                <div class="cat-article">
                                    <img src="${a.image}"/>
                                    <p>${a.nom}</p>
                                    <a class="btn-plein" href="Controller?section=ScPanier&article=${a.id}" onclick="go()">ajouter</a>
                                </div>
                            </div>
                        </c:forEach>
                        <c:forEach var="t" items="${boissons}">
                            <p>${t.nom}</p>
                        </c:forEach>
                        <c:forEach var="b" items="${burgers}">
                            <p>${b.nom}</p>
                            <img src="${b.image}"/>
                            <br>
                        </c:forEach>
                    </div>
=======
<div class="col-7" id="contenu">
    <div class="row d-flex wrap">
        <c:forEach var="a" items="${article}">
            <div class="col-4">
                <div class="cat-article">
                    <img class="cat-article" src="${a.image}"/>
                    <p>${a.nom}</p>
                    <a class="btn-plein" href="Controller?section=ScPanier&article=${a.id}">${a.prix} €</a>
>>>>>>> 3ab5a08e5136eb42c5c3db0cb9058bec524fffae
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<!-- panier -->
                <div class="col-3">
                    <p>panier</p>
                    <c:url value="Controller?section=ScPanier&part=affichage" var="panier" />
                    <c:import url="${panier}"/>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
