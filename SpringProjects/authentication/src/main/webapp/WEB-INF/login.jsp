<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome!</h1>
	<h4>Join our growing community.</h4>
		<form:form class="card" action="/register" method="POST" modelAttribute="newUser">
		<div>
			<h2>Register</h2>
				<form:errors path="userName" />
				<form:input placeholder="User Name" path="userName" />
				
				<form:errors path="email" />
				<form:input placeholder="Email" path="email" />
				
				<form:errors path="password" />
				<form:input placeholder="Password" path="password" />
				
				<form:errors path="confirm" />
				<form:input placeholder="Confirm Password" path="confirm" />
				
				<input class="btn_submit" type="submit" value="Submit" />
		</div>
		</form:form>
		
		<form:form class="card" action="/login" method="POST" modelAttribute="newLogin">		
		<div>
			<h2>Log In</h2>
				<form:errors path="email" />
				<form:input placeholder="Email" path="email" />
				
				<form:errors path="password" />
				<form:input placeholder="Password" path="password" />
				
				<input class="btn_submit" type="submit" value="Login" />
		</div>
		</form:form>
</body>
</html>