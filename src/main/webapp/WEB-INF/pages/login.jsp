<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loginje</title>
</head>
<body>
	<jsp:include page="included/_header.jsp"/>
	<h1>Bienvenue dans Login</h1>
	<p>
		<c:out value="${ auth }"/>
	</p>
	<fieldset>
		<form method="POST" action="<c:url value='/login' />" >
			<input type="text" name="username" placeholder="username">
			<input type="text" name="password" placeholder="password">
			<input type="submit" value="Se connecter" >
		</form>
	</fieldset>
	<jsp:include page="included/_footer.jsp"/>	
</body>
</html>