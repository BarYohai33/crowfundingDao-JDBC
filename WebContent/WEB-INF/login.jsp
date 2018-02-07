<!DOCTYPE html>
<html>
<head>
<%@ include file="menu.jsp" %>
<title>Login</title>
</head>
<body>
<c:if test="${ !empty sessionScope.email }">
       <c:redirect url="/home"/>
    </c:if>
<h2 class="center-element">Se connecter</h2>
<div class="container">
  <form method="post" action="/crowdfunding/login">
    <div class="form-group">
      <label for="email">Email:</label>
       <input type="email" placeholder="Entrez votre email" class="form-control" id="email" required="required" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Entrez votre mot de passe" name="password" size="20" maxlength="20" required="required">
    </div>
    <button type="submit" class="btn btn-default" value="Connexion">Se connecter</button>
   	<!-- <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>  -->
  </form>
     <ul>
        <c:forEach var="login" items="${ logins }">
            <li><c:out value="${ login.email }" /> <c:out value="${ login.password }" /></li>
        </c:forEach>
    </ul> 
</div>
</body>
</html>