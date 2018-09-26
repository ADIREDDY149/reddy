<%@page import="com.slokam.pojo.familypojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<center>
<body bgcolor="gold">
<table bgcolor="powderblue" border="2">
<tr>
	 <th>Id</th> 
	<th>Name</th>
	<th>Age</th>
	<th>Fathername</th>
	<th>Mothername</th>
	<th>Address</th>
	<th>Phone</th>
	
</tr>
<%


ArrayList<familypojo> fam=(ArrayList<familypojo>)request.getAttribute("get");
if(fam!=null){
	for(familypojo m:fam){
		out.print("<tr>");
		out.print("<td>"+m.getId()+"</td>"); 
		//out.print("<td><a href='getStudnet?id="+std.getId()+"'>"+std.getName()+"</a></td>");
		out.print("<td><a href='Getfamily?id="+m.getId()+"'>"+m.getName()+"</a></td>");
		out.print("<td>"+m.getAge()+"</td>");
		out.print("<td>"+m.getFname()+"</td>");
		out.print("<td>"+m.getMname()+"</td>");
		out.print("<td>"+m.getAddress()+"</td>");
		out.print("<td>"+m.getPhone()+"</td>");
		out.print("</tr>");
		
	}
	
	
}

%>

</center>
</table>
</form>
</body>
</html>