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
<title>Add Teacher</title>
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<jsp:include page="../header.jsp"></jsp:include>

<%
SubjectDao sd = new SubjectDao();
List<Subject> subjects = sd.getSubjects();
%>
<div class="login-page login-border">
	<h1 class="center-text">Add Teacher</h1>
	<form action="<%=request.getContextPath()%>/teacher" method="post">
		<div>
			<label class="form-label">First Name</label> <input
				class="form-input" type="text" name="fname" required />
		</div>
		<div>
			<label class="form-label">Last Name</label> <input class="form-input"
				type="text" name="lname" required />
		</div>
		<div>
			<label class="form-label">Learning Expert Grade</label> <input
				class="form-input" type="number" min=1 max=12 step=1 name="let"
				required />
		</div>
		<div>
			<label class="form-label">Subject Expert</label> <select name="set"
				class="form-input" required>
				<%for (int i = 0; i < subjects.size(); i++) { %>
					<option value="<%=subjects.get(i).getSubject() %>"/><%=subjects.get(i).getSubject() %></option>
				<% } %>
			</select>
		</div>
		<div>
			<label class="form-label">PhoneNo</label> <input class="form-input"
				type="text" name="phone" required />
		</div>
		<div>
			<label class="form-label">Email</label> <input class="form-input"
				type="email" name="email" required />
		</div>
		<div>
			<input class="btn m-r-50x" type="submit" value="Submit">
		</div>
	</form>
</div>


<body>

</body>
</html>