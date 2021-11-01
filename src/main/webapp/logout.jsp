<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank you</title>
</head>
<body>
<%
session.invalidate();
%>
<b>
<h1>Thanks you, session has been terminated.</h1>
<a href="Login.jsp"><button class="btn btn-primary">Login</button></a>
</b>
</body>
</html>