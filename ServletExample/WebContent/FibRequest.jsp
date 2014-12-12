<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fibonacci Request</title>
</head>
<meta http-equiv="refresh" content="10">
<body>
<form action="FileCounter">
<label>Fibonacci Request</label><br>

	<label> Job Number - ${ jobNum }</label></br>
	<label> Page will refresh in 10 seconds</label>
	<label> Timer - <%request.getAttribute("timer"); %></label>
	
	<%
	request.getSession().setAttribute("max", request.getParameter("max"));
	response.addHeader("refresh", "10;http://localhost:8080/fileCounter/FileCounter?request-Type=poll&jobNum=" + request.getSession().getAttribute("jobNum"));
	%>

		</form>
</body>
</html>