<!DOCTYPE html>
<html>
<head>
<%@ include file="menu.jsp" %>

<title>Home</title>



</head>
<body>
<c:if test="${ !empty sessionScope.email }">
        <p>Vous êtes ${ sessionScope.email }!</p>
    </c:if>
 <h1 class="center-element">Les projet de SupCrowFunder</h1>

           
        
 <div class="container">
  <div class="row">

  
 
    <c:forEach var="edit" items="${ edits }">
    <div class="col-md-3 col-md-push-1" style="border: 1px solid; margin-top:20px; margin-bottom:20px; margin-left:20px; margin-right:20px; ">
     
   <h3 style="background-color:#eee;" class="center-element"> <c:out value="${ edit.titre }"/>
    </h3>
   
   <p> <c:out value="${ edit.projet }"/>
    <a href="crowdfunding/details"> <br>Details</a>
    </p>
    
    
    </div>
    </c:forEach>
   
  

    
  </div>
 
  <br>
  </div>
  
<c:out value="Au revoir !" />


</body>
</html>