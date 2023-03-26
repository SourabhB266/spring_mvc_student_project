<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2px" style="width: 50%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
		</thead>

		<tbody style="text-align: center;">
			<c:forEach var="student" items="${list}">
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.address}</td>
					<td>${student.phone}</td>
					<td><a href="delete?id=${student.id}">delete</a></td>
					<td><a href="edit?id=${student.id}">edit</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>