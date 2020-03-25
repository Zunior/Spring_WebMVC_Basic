<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
	Lista usera:
	<br />
	<table>
		<thead>
			<tr>
				<th>Firstname</th>  
				<th>Lastname</th>
				<th>Username</th>
				<th>Password</th> 
			</tr>
		</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><p>${user.getFirstname()}</p><br/></td>
						<td><p>${user.getLastname()}</p><br/></td>
						<td><p>${user.getUsername()}</p><br/></td>
						<td><p>${user.getPassword()}</p><br/></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>

</body>
</html>