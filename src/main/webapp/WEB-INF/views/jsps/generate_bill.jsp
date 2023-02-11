<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new bill</title>
</head>
<body>
	<h2>create new Bill</h2>
	<form action="save" method="post">
		<pre>
First Name<input type="text" name="firstName" value="${ contact.firstName}"/>
Last Name<input type="text" name="lastName" value="${ contact.lastName}" />
Email<input type="text" name="email" value="${ contact.email}" />
Mobile<input type="text" name="mobile" value="${ contact.mobile}" />
	</pre>
	</form>
</body>
</html>