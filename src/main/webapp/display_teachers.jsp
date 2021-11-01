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
	String teachers = request.getParameter("teachers");
	if (Objects.nonNull(teachers)) {
	%>
	<h3>List of all the teachers of academy</h3>
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
			List<HashMap<Object, Object>> teachersList = new ObjectMapper().readValue(teachers, List.class);
			for (HashMap<Object, Object> eachMap : teachersList) {
				int teacherId = (Integer) eachMap.get("teacherId");
				String teacherName = (String) eachMap.get("teacherName");
			%>
			<tr>
				<td><%=teacherId%></td>
				<td><%=teacherName%></td>
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