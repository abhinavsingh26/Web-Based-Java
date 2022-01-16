<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
<%! int n1 = 10, n2 = 20, sum = 0; 
public int add(int n1, int n2)
	{
		sum = n1+ n2;
		return sum;
	}
%> 
<% out.print("welcome to jsp"); 
%>
<br>
<%= "sum of n1 and n2 : " + add(n1,n2) %>
</h1>
<B>Program Done</B>
</body>
</html>