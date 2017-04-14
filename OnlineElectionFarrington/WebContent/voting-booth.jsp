<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote for Candidate</title>
</head>
<body>
	<form method="post" action="resultsServlet">
		<%
			String tempId = (String) request.getAttribute("itemId");
			String tempElection = (String) request.getAttribute("Election");
			String tempCand1Name = (String) request.getAttribute("Cand1Name");
			String tempCand2Name = (String) request.getAttribute("Cand2Name");
			String tempCand3Name = (String) request.getAttribute("Cand3Name");
		%>
		<h1><%=tempElection%></h1>
		<input type="button" name="CandName" value="<%=tempCand1Name%>">
		<input type="button" name="CandName" value="<%=tempCand2Name%>">
		<input type="button" name="CandName" value="<%=tempCand3Name%>"><br />

		<input type="submit" name="viewResults" value="View Results">
	</form>
</body>
</html>