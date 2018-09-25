<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <!-- Brand -->
    <c:url value="Controller?section=ScMenu" var="url01" />
    <a class="navbar-brand" href="${url01}" ><img src="./images/logo.png" alt="logo" style="width: 40px; height: 40px;"></a>
    <!-- Links -->
    <ul class="navbar-nav">
        <li class="nav-item">
            <c:url value="Controller?section=ScAccueil" var="url02" />
            <a class="nav-link" href="${url02}">creer les données</a>
        </li>
    </ul>
</nav>