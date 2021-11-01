<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>TMC Academy</title>
</head>
<body>
	<%
	String students = request.getParameter("students");
	if (Objects.nonNull(students)) {
	%>
	<h3>List of all the students of academy</h3>
	<br>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<HashMap<Object, Object>> studentsList = new ObjectMapper().readValue(students, List.class);

			for (HashMap<Object, Object> eachMap : studentsList) {
				int studentId = (Integer) eachMap.get("studentId");
				String studentName = (String) eachMap.get("studentName");
			%>
			<tr>
				<td><%=studentId%></td>
				<td><%=studentName%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>
	<a href="dashboard.jsp"><span class="glyphicon glyphicon-log-out"></span>Go
		to previous page</a>
</body>
</html>