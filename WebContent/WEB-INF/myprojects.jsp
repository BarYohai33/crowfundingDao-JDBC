<!DOCTYPE html>
<html>
<head>
<%@ include file="menu.jsp" %>

<title>Insert title here</title>
</head>
<c:if test="${ empty sessionScope.email }">
       <c:redirect url="/signup"/>
</c:if>
<body>
<h1 style="text-align: center;">My Projects</h1>
<form method="post">
<div class="col-md-6 col-md-offset-3">
  <label for="titre">Titre :</label>
  <input type="text" class="form-control" id="titre" name="titre">
</div>

<div class="col-md-6 col-md-offset-3" >
  <label for="projet">Détails du projet :</label>
  <textarea class="form-control" rows="10" id="projet" name="projet"></textarea>
</div>

<div class="col-md-6 col-md-offset-3" style="text-align:center;">
<br>
<button type="submit" class="btn btn-success" style="center">Editer mon projet</button>
</div>
</form>


</body>
</html>