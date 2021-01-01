<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Ma sach</th>
			<th>Link bia</th>
			<th>Ten sach</th>
			<th>Chi tiet</th>
		</tr>
		<c:forEach items="${sachList}" var="sach">
			<tr>
				<td>${sach.masach}</td>
				<td>${sach.linkbia}</td>
				<td>${sach.tensach}</td>
				<td>${sach.chitiet}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>