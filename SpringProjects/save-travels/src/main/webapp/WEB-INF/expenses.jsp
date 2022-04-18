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
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div class="card_head">
		<h1 class="col_white1">Save Travels</h1>
	</div>
	<form:form class="card" action="/expenses" method="POST" modelAttribute="expense">
	<div class="card_body">
		<form:label path="name">Expense Name: </form:label>
		<form:input path="name"/>
		<form:errors path="name"/>
		
		<form:label path="name">Vendor: </form:label>
		<form:input path="vendor"/>
		<form:errors path="vendor"/>
		
		<form:label path="name">Amount: </form:label>
		<form:input path="price"/>
		<%-- <form:errors path="price"/> --%>
		
		<form:label path="name">Description: </form:label>
		<form:textarea path="description"/>
		<form:errors path="description"/>
		<input class="btn_submit" type="submit" value="Submit"/>
	</div>
	</form:form>
</body>
</html>