<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new election</title>
</head>
<body>
	<form action="AddElectionServlet" method="post">
		Election:<input type="text" name="election"> 
		First Candidate:<input type="text" name="Cand1Name"> 
		Second Candidate:<input type="text" name="Cand2Name"> 
		Third Candidate:<input type="text" name="Cand3Name"> 
		<input type="submit" value="Add Election">

	</form>
</body>
</html>