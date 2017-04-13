<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="java.util.ArrayList, model.CandidateItem" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Election List</title>
</head>
<body>
<%ArrayList<CandidateItem> allCandidates = (ArrayList<CandidateItem>)request.getAttribute("AllCandidates");
%>

<form method = "post" action="MasterControllerServlet">
<table border= 1 cellpadding=5>
<tr>
<th>Select</th>
<th>Election</th>
<th>Candidate One</th>
<th>Candidate Two</th>
<th>Candidate Three</th>
</tr>
<%
for(int i = 0; i < allCandidates.size(); i++){
%>
<tr>
	<td><input type = "radio" name = "id" value = "<%= i %>"> </td>
	<td><%=allCandidates.get(i).getElection() %></td>
	<td><%=allCandidates.get(i).getCand1Name() %></td>
	<td><%=allCandidates.get(i).getCand2Name() %></td>
	<td><%=allCandidates.get(i).getCand3Name() %></td>
</tr>
<%
}
%>
</table>
<input type = "submit" name = "doThis" value = "Select Election">
<input type = "submit" name = "doThis" value = "Add New Election">
</form>

</body>
</html>