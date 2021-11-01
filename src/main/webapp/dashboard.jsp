
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TMC Academy</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp?error=1");
		}
	%>
	<div class="container mt-3">
		<h1>Dashboard</h1>
		<br>
		  <h3>You can search for</h3>
		  <a href="students"> <button class="btn btn-primary">List of Students</button></a><br>
		  <br><a href="teachers"><button class="btn btn-primary">List of Teachers</button></a><br>
		  <br><a href="subjects"><button class="btn btn-primary">List of Subjects</button></a><br>
		  <br><a href="classes"><button class="btn btn-primary">List of Classes</button></a><br>
		  <br><a href="classA"><button class="btn btn-primary">Record of Class A</button></a><br>
		  <br><a href="classB"><button class="btn btn-primary">Record of Class B</button></a><br>
		  <br><a href="classC"><button class="btn btn-primary">Record of Class C</button></a><br>
		  <br><a href="classD"><button class="btn btn-primary">Record of Class D</button></a><br>
		  <br><a href="classE"><button class="btn btn-primary">Record of Class E</button></a><br>
		<br><br><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
	</div>

</body>
</html>