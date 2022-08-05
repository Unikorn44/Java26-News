<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<jsp:include page="included/_header.jsp"/>
	
	<p>
		<c:out value="${ user.username }"/>
	</p>
	<p>
		<c:out value="${ auth }"/>
	</p>
	
	<c:choose >
		<c:when test="${ sessionScope['auth']}">
			<div class="welcome">
				<a class="logout" href="<c:url value="/login?logoff=true"/>">se déconnecter</a>
			</div>
		</c:when>
	</c:choose>

	<div id="list">
		<c:forEach var="element" items="${ newsListRecup }">
			<c:out value="${element.dateArticle}"/>
			<c:out value="${element.titre}"/>
			<c:out value="${element.description}"/>
 			<p>--</p>
		</c:forEach>
	</div>
	
	<jsp:include page="included/_footer.jsp"/>
</body>
</html>