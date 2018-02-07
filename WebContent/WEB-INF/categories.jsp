<!DOCTYPE html>
<html>
<head>
<%@ include file="menu.jsp" %>
<title>Categories</title>
</head>
<body>
<c:if test="${ !empty sessionScope.email }">
        <p>Vous êtes ${ sessionScope.email }!</p>
    </c:if>
<h1>this is the categories page</h1>
</body>
</html>