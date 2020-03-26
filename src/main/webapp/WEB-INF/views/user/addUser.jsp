<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>

	<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
	
	${info }
	<form:form action="${contextPath}/users/save" method = "post" modelAttribute="user">
		<table>
			<tbody>
				<tr>
					<td>Firstname:</td>
					<td>
						<form:input path="firstname" id="firstname" />
					</td>
				</tr>
				<tr>
					<td>Lastname:</td>
					<td>
						<form:input path="lastname" id="lastname" />
					</td>
				</tr>
				<tr>
					<td>Username:</td>
					<td>
						<form:input path="username" id="username" />
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td>
						<form:input path="password" id="password" />
					</td>
				</tr>
				<tr>
					<td>
						<button id="save">Save</button>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>