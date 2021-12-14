<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>
	<div class="login-page login-border">
		<h1 class="center-text">Add Student</h1>
		<form action="<%=request.getContextPath()%>/student" method="post">
			<div>
				<label class="form-label">Student Id</label> <input
					class="form-input" type="text" name="id"
					value="${student.getStudentId()}" readonly />
			</div>
			<div>
				<label class="form-label">First Name</label> <input
					class="form-input" type="text" name="fname"
					value="${student.getFname()}" required />
			</div>
			<div>
				<label class="form-label">Last Name</label> <input
					class="form-input" type="text" name="lname"
					value="${student.getLname()}" required />
			</div>
			<div>
				<label class="form-label">Grade</label> <input class="form-input"
					type="number" min=1 max=12 step=1 name="grade"
					value="${student.getGrade()}" required />
			</div>
			<div>
				<label class="form-label">Status</label> <select name="status">
					<option value="active"
						${student.getStatus()=='ACTIVE'?'selected': ''}>Active</option>
					<option value="inactive"
						${student.getStatus()=='INACTIVE'?'selected': ''}>Inactive</option>
				</select>
			</div>
			<div>
				<input class="btn m-r-50x" type="submit" value="Submit">
			</div>
		</form>
	</div>
</body>
</html>