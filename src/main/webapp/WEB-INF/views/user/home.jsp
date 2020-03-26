<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	
	<c:url var="addUserURL" value="/users/add"/>
	<c:url var="listAllUsersURL" value="/users"/>
	
<%-- 			<jsp:include page="UserLogout.jsp"></jsp:include> --%>
				<div>
					<a href="<c:out value="${addUserURL}"/>">Add user</a>
				</div>
				<br />
				<div>
					<a href="<c:out value="${listAllUsersURL}"/>">All users</a>
				</div>
				<div>
					=======================================================
				</div>
	

</body>
</html>