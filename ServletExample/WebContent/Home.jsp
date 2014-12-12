<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title> File Counter for Fibonacci Sequence   </title>
	</head>	
	<body>		
		<form action="FileCounter"method = "get">			
			 Please enter the amount of numbers you wish to see: <br>
			<%session.setAttribute("request-Type", "Add"); %>
			Enter any number between 1-100: <br>
			<input type="text" name="max"size="20px">
			<input type="submit" value="submit">		
		</form>		
	</body>	
</html>