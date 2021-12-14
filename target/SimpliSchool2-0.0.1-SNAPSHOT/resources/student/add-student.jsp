<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="login-page login-border">
		<h1 class="center-text">Add Student</h1>
		<form action="<%=request.getContextPath()%>/student" method="post">
			<div>
				<label class="form-label">First Name</label> <input
					class="form-input" type="text" name="fname" required />
			</div>
			<div>
				<label class="form-label">Last Name</label> <input
					class="form-input" type="text" name="lname" required />
			</div>
			<div>
				<label class="form-label">Grade</label> <input class="form-input"
					type="number" min=1 max=12 step=1 name="grade" required />
			</div>
			<div>
				<input class="btn m-r-50x" type="submit" value="Submit">
			</div>
		</form>
	</div>
</body>
</html>