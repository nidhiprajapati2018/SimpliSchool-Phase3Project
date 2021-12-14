<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Record</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="login-page login-border">
		<c:if test="${sessionScope.role == 'admin'}">
			<a
				href="<%=request.getContextPath()%>/resources/student/add-student.jsp"
				class="btn">Add Student</a>
			<br />
		</c:if>
		<h1 class="m-t-40x">Student List</h1>
		<table class="list">
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Grade</th>
				<th>Status</th>
				<c:if test="${sessionScope.role == 'admin'}">
					<th></th>
					<th></th>
				</c:if>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.getStudentId()}" /></td>
					<td><c:out value="${student.getFname()}" /></td>
					<td><c:out value="${student.getLname()}" /></td>
					<td><c:out value="${student.getGrade()}" /></td>
					<td><c:out value="${student.getStatus()}" /></td>
					<c:if test="${sessionScope.role == 'admin'}">
						<td><a
							href="<%=request.getContextPath()%>/student?flag=edit&id=${student.getStudentId()}">Edit</a></td>
						<td><a
							href="<%=request.getContextPath()%>/student?flag=delete&id=${student.getStudentId()}">Delete</a></td>
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