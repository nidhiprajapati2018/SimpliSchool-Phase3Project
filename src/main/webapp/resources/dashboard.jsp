<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="resources/css/login.css" />
<link rel="stylesheet" href="resources/css/dashboard.css" />
</head>
<body>
<%@ include file="header.jsp" %>
	<section class="login-page login-border ">
		<div class="dash-card-container">
			<div class="dash-cards">
				<img src="resources/img/student.png" alt="Avatar"
					class="card-img"> <a class="no-underline card-label"
					href="<%=request.getContextPath()%>/student">Student</a>
			</div>
			<div class="dash-cards">
				<img src="resources/img/teacher.png" alt="Avatar"
					class="card-img"> <a class="no-underline card-label"
					href="<%=request.getContextPath()%>/teacher">Teacher</a>
			</div>
			<div class="dash-cards">
				<img src="resources/img/course.jpg" alt="Avatar"
					class="card-img"> <a class="no-underline card-label"
					href="<%=request.getContextPath()%>/subject">Subject</a>
			</div>
		</div>
	</section>
</body>
</html>