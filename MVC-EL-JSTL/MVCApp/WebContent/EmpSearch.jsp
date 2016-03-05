<%@page import="com.srivastava.dto.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="hcl" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><hcl:date/></h2>
<hcl:calendar txtBoxId ="dob"/>
<form action="empcontroller">
<label>Enter the Emp Salary to Search</label>
<input type="text" name="salary">
<input type="submit" value="Search">
</form>
<table border="1">
<tr><td>S.no</td><td>Empno</td><td>Name</td><td>Salary</td></tr>
<c:forEach items="${emplist}" var="emp" varStatus="x">
<c:if test="${x.count mod 2 eq 0}">
<tr style="background-color: aqua">
</c:if>
<c:if test="${x.count mod 2 ne 0}">
<tr style="background-color: yellow">
</c:if>
<td>${x.count}</td>
<td>${emp.empno}</td>
<td>${emp.name}</td>
<td>${emp.salary}</td>
</tr>
</c:forEach>
</table>
<%-- ${emplist} --%>
<%-- ${requestScope["emplist"]} --%>

</body>
</html>