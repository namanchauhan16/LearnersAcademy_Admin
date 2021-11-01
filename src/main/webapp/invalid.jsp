<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer errorcode = Integer.parseInt(request.getParameter("error"));
		if(errorcode == 1){
			out.println("<h3>Error, Pleas Enter a valid Username!");
	%>
	<%
		}else{
			out.println("<h3>Error, Password can't be blank!");
		}
	%>
	<br><a href="Login.jsp"><button class="btn btn-primary">Try again</button></a>
</body>
</html>