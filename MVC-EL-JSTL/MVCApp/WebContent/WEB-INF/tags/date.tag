<%@ tag language="java" import="java.util.Date,java.text.DateFormat,java.util.Locale" pageEncoding="ISO-8859-1"%>
<% 
Locale locale = new Locale("HI","IN");
DateFormat df = 
DateFormat.getDateInstance(DateFormat.FULL,locale);
Date date = new Date();
String formattedDate = df.format(date);
%>
Today Date is <%=formattedDate%>