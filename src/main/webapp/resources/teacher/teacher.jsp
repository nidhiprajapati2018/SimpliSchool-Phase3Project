<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Record</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="login-page login-border">
		<c:if test="${sessionScope.role == 'admin'}">
			<a
				href="<%=request.getContextPath()%>/resources/teacher/add-teacher.jsp"
				class="btn">Add Teacher</a>
			<br />
		</c:if>
		<h1 class="m-t-40x">Teacher List</h1>
		<table class="list">
			<tr>
				<th>Teacher ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Learning Expert Grade</th>
				<th>Subject Expert</th>
				<th>Phone NO</th>
				<th>Email</th>
				<c:if test="${sessionScope.role == 'admin'}">
					<th></th>
					<th></th>
				</c:if>
			</tr>
			<c:forEach items="${teachers}" var="teacher">
				<tr>
					<td><c:out value="${teacher.getTeacherid()}" /></td>
					<td><c:out value="${teacher.getFname()}" /></td>
					<td><c:out value="${teacher.getLname()}" /></td>
					<td><c:out value="${teacher.getLet()}" /></td>
					<td><c:out value="${teacher.getSet()}" /></td>
					<td><c:out value="${teacher.getPhone()}" /></td>
					<td><c:out value="${teacher.getEmail()}" /></td>
					<c:if test="${sessionScope.role == 'admin'}">
						<td><a
							href="<%=request.getContextPath()%>/teacher?flag=edit&id=${teacher.getTeacherid()}">Edit</a></td>
						<td><a
							href="<%=request.getContextPath()%>/teacher?flag=delete&id=${teacher.getTeacherid()}">Delete</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<script>
	if (window.history.replaceState) {
		window.history.replaceState(null, null, window.location.href);
	}
</script>
</html>