<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
	<title>Lesson for day 9</title>
	<meta charset="UTF-8">
</head>
<body>
	<h1>Contact Info</h1>
	<c:if test="${not empty contact}">
	<div>
		<div>
			<span>First Name:</span>
			<span>
				<c:out value="${contact.firstName}" />
			</span>
		</div>
		<div>
			<span>Last Name:</span>
			<span>
				<c:out value="${contact.lastName}" />
			</span>
		</div>
		<div>
			<span>Birthday:</span>
			<span>
				<ftm:formatDate pattern="yyyy-MM-dd" value="${contact.birthday}" />
			</span>
		</div>
		<div>
			<span>Contact details:</span>
			<span>
				<ul>
					<c:forEach items="${contact.contactDetailList}" var="contactDetail">
					<li>
						<c:out value="${contactDetail.contactDetailType.description} : ${contactDetail.details}" />
					</li>
					</c:forEach>
				</ul>
			</span>
		</div>
	</div>
	</c:if>
	<c:if test="${empty contact}">
		Contact with id ${request.parameter[id]} was not found.
	</c:if>
</body>
</html>
