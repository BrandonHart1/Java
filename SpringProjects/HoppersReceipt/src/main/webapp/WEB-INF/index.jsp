<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Welcome Customer</h1>
	<h3>Name: <c:out value="${name}"/></h3>
	<h3>Item Name: <c:out value="${itemName}"/></h3>
	<h3>Price: <c:out value="${price}"/></h3>
	<h3>Description: <c:out value="${description}"/></h3>
	<h3>Vendor: <c:out value="${vendor}"/></h3>
</body>
</html>