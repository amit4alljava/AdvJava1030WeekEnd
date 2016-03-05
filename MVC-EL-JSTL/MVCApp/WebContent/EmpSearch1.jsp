<%@page import="com.srivastava.dto.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="empcontroller">
<label>Enter the Emp Salary to Search</label>
<input type="text" name="salary">
<input type="submit" value="Search">
</form>
<%
ArrayList<EmployeeDTO> empList = (ArrayList<EmployeeDTO>)request.getAttribute("emplist");
if(empList!=null && empList.size()>0){
	%>
	<table border="1">
	<%
	for(EmployeeDTO empDTO : empList){
		%>
		<tr>
		<td><%=empDTO.getEmpno() %></td>
		<td><%=empDTO.getName() %></td>
		<td><%=empDTO.getSalary() %></td>
		</tr>
		
<%		
	}
	%>
	</table>
<%
}
%>

</body>
</html>