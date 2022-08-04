<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>header</title>
</head>
<body>
	<p>Header</p>
	<nav>
		<ul>
			<li>
				<a href="<c:url value='/welcome' />"> Welcome </a>			
			</li>			
			<li>
				<a href="<c:url value='/about' />"> About </a>			
			</li>	
			<li>
				<a href="<c:url value='/contact' />"> Contact</a>			
			</li>	
			<li>
				<a href="<c:url value='/login' />"> Login </a>			
			</li>	
		</ul>
	</nav>
	

</body>
</html>