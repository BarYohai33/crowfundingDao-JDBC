<%@ page language="java" contentType="text/html;charset=iso-8859-1" pageEncoding="iso-8859-1" %>
<meta http-equiv='Content-Type' content='text/html;  charset=iso-8859-1' />
<link href="./ressources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./ressources/css/stylesheet.css" rel="stylesheet" type="text/css"/>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-collapse collapse" style="color:black;">
     	<ul class="nav navbar-nav navbar-center" >
            <li><a href="/crowdfunding/home">Accueil</a></li>
            <li><a href="/crowdfunding/about">A propos</a></li>
            <li><a href="/crowdfunding/categories">Catégories</a></li>
            <c:if test="${ empty sessionScope.email}"><li><a href="/crowdfunding/signup">S'enregistrer</a></li></c:if>
            <c:if test="${ empty sessionScope.email}"><li><a href="/crowdfunding/login">Connexion</a></li></c:if>
            <c:if test="${ !empty sessionScope.email}"><li><a href="/crowdfunding/myprojects">Editer un projet</a></li></c:if>
            <c:if test="${ !empty sessionScope.email}"><li><a href="/crowdfunding/logout" style="color:red;">${ sessionScope.firstname }</a></li></c:if>
            
            
        </ul>
    </div>
</nav>