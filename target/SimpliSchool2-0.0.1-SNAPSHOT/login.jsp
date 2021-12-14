<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.school.dao.SubjectDao"%>
<%@ page import="com.school.dao.UserDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="resources/css/login.css" />
</head>
<body>
	<%
session.removeAttribute("username");
session.removeAttribute("password");
session.removeAttribute("role");
%>

	<%
	SubjectDao sd = new SubjectDao();
	if (sd.getSubjectCount() == 0) {
		sd.setSubjects();
	}

	UserDao ud = new UserDao();
	if (ud.getUserCount() == 0) {
		ud.setUsers();
	}
	%>
	<form action="<%=request.getContextPath()%>/login" method="post"
		class="login-page login-border">
		<div class="imgcontainer">
			<img src="resources/img/school-management-icon.png" alt="Avatar"
				class="avatar">
		</div>
		<div class="container">
			<label for="uname"><b>Username</b></label><input type="text"
				placeholder="Enter Username" name="username" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>

		</div>
	</form>
</body>
</html>