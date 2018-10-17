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