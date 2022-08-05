<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page administrateur</title>
</head>
<body>
	<jsp:include page="included/_header.jsp"/>
	
	<h2>Ajout d'une news</h2>
	<fieldset>
		<form method="POST" action="<c:url value='/admin?formulaire=ajoutnews' />" >
			<input type="text" name="titre" placeholder="titre">
			<input type="text" name="description" placeholder="description">
			<input type="submit" value="Ajouter une news" >
		</form>
	</fieldset>
	
	<h2>Ajout d'un super user</h2>
	<fieldset>
		<form method="POST" action="<c:url value='/admin?formulaire=ajoutuser' />" >
			<input type="text" name="nom" placeholder="nom">
			<input type="text" name="prenom" placeholder="prenom">
			<input type="text" name="username" placeholder="username">
			<input type="text" name="password" placeholder="password">
			<input type="submit" value="Ajouter un Super User" >
		</form>
	</fieldset>

	<jsp:include page="included/_footer.jsp"/>
</body>
</html>