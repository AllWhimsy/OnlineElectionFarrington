<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote for Candidate</title>
</head>
<body>
<%
String tempId = (String)request.getAttribute("itemId");
String tempCand1Name = (String)request.getAttribute("Cand1Name");
String tempCand2Name = (String)request.getAttribute("Cand2Name");
String tempCand3Name = (String)request.getAttribute("Cand3Name");
%>
<form action= "resultsServlet" method = "post">
<input type = "radio" name = "Cand1Name" value = "<%=tempCand1Name %>">
<input type = "radio" name = "Cand2Name" value = "<%=tempCand2Name %>">
<input type = "radio" name = "Cand3Name" value = "<%=tempCand3Name %>">
</form>
<form>
<input type = "submit" name = "selectCandidate" value = "Vote">
<input type = "submit" name = "viewResults" value = "View Results">
</form>
</body>
</html>