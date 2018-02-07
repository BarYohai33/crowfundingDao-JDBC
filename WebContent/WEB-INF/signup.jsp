<!DOCTYPE html>
<html>

<head>
<%@ include file="menu.jsp" %>
<title>Signup</title>
</head>
<body>
<c:if test="${ !empty sessionScope.email }">
       <c:redirect url="/home"/>
    </c:if>
<h2 class="center-element">S'enregistrer</h2>
<div class="container">
<!--<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>-->
  <form method="post" action="/crowdfunding/signup">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Entrez votre email" name="email" required="required">
    </div>
    <div class="form-group">
      <label for="firstname">Prénom:</label>
      <input type="text" class="form-control" id="firstname" placeholder="Entrez votre prénom" name="firstname" maxlength="25" required="required">
    </div>
        <div class="form-group">
      <label for="lastname">Nom:</label>
      <input type="text" class="form-control" id="lastname" placeholder="Entrez votre nom" name="lastname" maxlength="25" required="required">
    </div>
        <div class="form-group">
      <label for="password">Mot de passe:</label>
      <input type="password" class="form-control" id="password" placeholder="Entrez votre mot de passe" name="password" required="required">
    </div>
        <div class="form-group">
      <label for="password2">Mot de passe:</label>
      <input type="password" class="form-control" id="password2" placeholder="Répétez votre mot de passe" name="password2" required="required">
    </div>
    <div class="col-md-12 text-center"> 
    <button type="submit" class="btn btn-default">S'enregistrer</button>
    </div>
  </form>
 
  </div>
  <br>
  <div>
         <ul>
        <c:forEach var="user" items="${ users }">
            <li><c:out value="${ user.email }"/></li>
        </c:forEach>
    </ul> 
   </div> 
   <br><br>
</body>
</html>