<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.school.dao.SubjectDao"%>
<%@ page import="com.school.entity.Subject"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Teacher</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>

	<jsp:include page="../header.jsp"></jsp:include>
	<jsp:useBean id="subjects" class="com.school.dao.SubjectDao"></jsp:useBean>

	<div class="login-page login-border">
		<h1 class="center-text">Add Teacher</h1>
		<form action="<%=request.getContextPath()%>/teacher" method="post">
			<div>
				<label class="form-label">Teacher Id</label> <input
					class="form-input" type="text" name="id"
					value="${teacher.getTeacherid()}" readonly />
			</div>
			<div>
				<label class="form-label">First Name</label> <input
					class="form-input" type="text" name="fname"
					value="${teacher.getFname()}" required />
			</div>
			<div>
				<label class="form-label">Last Name</label> <input
					class="form-input" type="text" name="lname"
					value="${teacher.getLname()}" required />
			</div>
			<div>
				<label class="form-label">Learning Expert Grade</label> <input
					class="form-input" type="number" min=1 max=12 step=1 name="let"
					value="${teacher.getLet()}" required />
			</div>
			<div>
				<label class="form-label">Subject Expert</label> <select name="set"
					class="form-input" required>
					<c:forEach var="subject" items="${subjects.getSubjects()}">
						<option ${teacher.getSet().equals(subject.subject)?'selected': ''}
							value="${subject.subject}">${subject.subject}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<label class="form-label">Phone No</label> <input class="form-input"
					type="text" name="phone" value="${teacher.getPhone()}" required />
			</div>
			<div>
				<label class="form-label">Email</label> <input class="form-input"
					type="email" name="email" value="${teacher.getEmail()}" required />
			</div>
			<div>
				<input class="btn m-r-50x" type="submit" value="Submit">
			</div>
		</form>
	</div>

</body>
</html>