<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fibonacci Results</title>
</head>
<body>
		Result<br>
		<label>Fibonacci Sequence - ${ result }</label>
		<%=request.getParameter("result") %>
		<form action="Home.jsp">
		<input type="submit" value="Return To Start">
</form>
</body>
</html>