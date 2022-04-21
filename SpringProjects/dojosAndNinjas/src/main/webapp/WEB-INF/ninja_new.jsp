<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="container p2 grid gap2">
		<div class="card">
			<div class="card_head">
				<h1 class="col_white1">New Ninja</h1>
			</div>
			
			
		</div>
	
		<form:form class="card" action="/ninja" method="POST" modelAttribute="ninja" >
			<div class="">
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="item">
						<form:option value="${item.id}">${item.name}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<div class = "card_body">
				<form:errors class="col_red" path="firstName"/>
				<form:input placeholder="First Name" path="firstName"/>
				
				<form:errors class="col_red" path="lastName"/>
				<form:input placeholder="Last Name" path="lastName"/>
				
				<form:errors class="col_red" path="age"/>
				<form:input placeholder="Age" path="age"/>
				
				<input class="btn_submit" type="submit" value="Create" />
			</div>
		</form:form>
	</div>
</body>
</html>
