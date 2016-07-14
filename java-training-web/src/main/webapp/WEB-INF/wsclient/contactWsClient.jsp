<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<title>Lesson for day 9</title>
	<meta charset="UTF-8">
</head>
<body>
	<h1>Contact List</h1>
	<ul>
		<c:forEach items="${contactList}" var="contact">
		<li>
			<c:out value="${contact.firstName} ${contact.lastName}" />
			<ul>
			<c:forEach items="${contact.contactDetailList}" var="contactDetail">
				<li>${contactDetail.contactDetailType.description}: ${contactDetail.details} </li>
			</c:forEach>
			</ul>
		</li>
		</c:forEach>
	</ul>
</body>
</html>