<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Subject</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="login-page login-border">
		<c:if test="${sessionScope.role == 'admin'}">
			<form action="<%=request.getContextPath()%>/subject" method="post">
				<table class="list">
					<tr>
						<td><input type="text" name="id" value="${subject.getSubjectid()}" disabled/></td>
						<td><input type="text" placeholder="Subject Name" name="subject" value="${subject.getSubject()}" /></td>
						<td><input type="text" placeholder="Grade" name="grade" value="${subject.getGrade()}" /></td>
						<td><input type="submit" value="Add Subject"/></td>
						<td>
					</tr>
				</table>
			</form>
		</c:if>
		<h1 class="m-t-40x">Subject List</h1>
		<table class="list">
			<tr>
				<th>Subject Id</th>
				<th>Subject Name</th>
				<th>Grade</th>
				<c:if test="${sessionScope.role == 'admin'}">
					<th></th>
					<th></th>
				</c:if>
			</tr>
			<c:forEach items="${subjects}" var="subject">
				<tr>
					<td><c:out value="${subject.getSubjectid()}" /></td>
					<td><c:out value="${subject.getSubject()}" /></td>
					<td><c:out value="${subject.getGrade()}" /></td>
					<c:if test="${sessionScope.role == 'admin'}">
						<td><a
							href="<%=request.getContextPath()%>/subject?flag=edit&id=${subject.getSubjectid()}">Edit</a></td>
						<td><a
							href="<%=request.getContextPath()%>/subject?flag=delete&id=${subject.getSubjectid()}">Delete</a></td>
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