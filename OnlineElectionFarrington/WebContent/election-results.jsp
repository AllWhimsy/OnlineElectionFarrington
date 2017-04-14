<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String tempCand1Name = (String) request.getAttribute("Cand1Name");
		String tempCand2Name = (String) request.getAttribute("Cand2Name");
		String tempCand3Name = (String) request.getAttribute("Cand3Name");
		
		String tempCand1Votes = (String) request.getAttribute("Cand1Votes");
		String tempCand2Votes = (String) request.getAttribute("Cand2Votes");
		String tempCand3Votes = (String) request.getAttribute("Cand3Votes");
	%>
	<table border=1 cellpadding=5>
		<tr>
			<th><%=tempCand1Name%></th>
			<th><%=tempCand2Name%></th>
			<th><%=tempCand3Name%></th>
		</tr>
		<tr>
			<td><%=tempCand1Votes%></td>
			<td><%=tempCand2Votes%></td>
			<td><%=tempCand3Votes%></td>
		</tr>
	</table>
</body>
</html>