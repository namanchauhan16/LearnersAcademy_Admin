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
	String classa = request.getParameter("classa");
	if (Objects.nonNull(classa)) {
	%>
	<h3>Record of Class A</h3>
	<br>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Subjects</th>
				<th>Teachers</th>
				<th>Students</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<HashMap<Object, Object>> classaList = new ObjectMapper().readValue(classa, List.class);

			for (HashMap<Object, Object> eachMap : classaList) {
				String subjectname = (String)eachMap.get("subjectName");
				String teachername = (String)eachMap.get("teacherName");
				String studentname = (String)eachMap.get("studentName");
			%>
			<tr>
				<td><%=subjectname%></td>
				<td><%=teachername%></td>
				<td><%=studentname%></td>
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