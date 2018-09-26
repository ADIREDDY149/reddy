<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h2><a href="?lang=en">English</a> ||<a href="?lang=fr">French</a>||<a href="?lang=de">Germany</a>||<a href="?lang=te">Telugu</a>  </h2>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function savestudent(){
	alert("savestudent...");
	document.forms[0].action="savestudent.com";
	document.forms[0].submit();
}
function Getallstudent(){
	alert("Getallstudent...");
	document.forms[0].action="getallstudent.com";
	document.forms[0].submit();
}
function Updatestudent(){
	alert("Updatestudent...");
	document.forms[0].action="Updatestudent.com";
	document.forms[0].submit();
}
function Deletestudent(){
	alert("Deletestudent...");
	document.forms[0].action="Deletestudent.com";
	document.forms[0].submit();
}

function getStates(){
	alert("getStaes...");
	document.forms[0].action="getStates.com";
	document.forms[0].submit();
}

/* function CheckStudentByName(){
	alert("CheckStudentByName...");
	document.forms[0].action="CheckStudentByName.com";
	document.forms[0].submit();
} */

function CheckStudentByName(){
	var xmlrequest =new XMLHttpRequest(); 
	var nameobj=document.getElementById("nameid");
	xmlrequest.open("GET","CheckStudentByNameAsync.com?name="+nameobj.value,true);
	
	xmlrequest.send();
	
	xmlrequest.onreadystatechange=function (){
		
		if(xmlrequest.readyState==4){
			
			var valueobj=document.getElementById("message");
			
			valueobj.innerText=xmlrequest.responseText;
		}
		
	}
	
}



</script>


</head>
<body>
<div align="right">
<h1><a href="logout.com">Logout</a></h1>
</div>
${error}
<form:form commandName="student" method="post" enctype="multipart/form-data">
<fieldset>
<legend>Student Details</legend>
<spring:message code="student.id"/><form:input path="id"/><br>

<%-- Name::<form:input path="name" onblur="CheckStudentByName()"/>
${message}  <br> --%>
<spring:message code="student.name"/><form:input id="nameid" path="name" onblur="CheckStudentByName()"/>
<div id="message"></div>
<spring:message code="student.age"/><form:input path="age"/><br>
<spring:message code="student.qual"/><form:input path="qual"/><br>
<spring:message code="student.phone"/><form:input path="phone"/><br>

<spring:message code="student.country"/><form:select path="selectedCountry" onchange="getStates()"><br>
<form:options items="${countries}" itemValue="id" itemLabel="name" />
</form:select><br>

<spring:message code="student.state"/><form:select path="selectedState" ><br>
<form:options items="${states}" itemValue="id" itemLabel="name" /><br>
</form:select><br>
File Upload<form:input  type='file' path="fileData"/>
<input type="button" value="save" onclick="savestudent()">
<input type="button" value="Getall" onclick="Getallstudent()">
<input type="button" value="Update" onclick="Updatestudent()">
<input type="button" value="Delete" onclick="Deletestudent()">


</fieldset>
</form:form>
<table border="2" color="green">
	<tr>
		<th>Id</th>
		<th><a href="getallstudent.com?sort=name">Name</a></th>
		<th><a href="getallstudent.com?sort=age">Age</a></th>
		<th><a href="getallstudent.com?sort=qual">Qual</a></th>
		<th><a href="getallstudent.com?sort=phone">Phone</a></th>

	</tr>
<c:forEach items="${students}" var="student">

	<tr>
		<td>${student.id}</td>
		<td><a href="getstudentById.com?id=${student.id}" >${student.name}</a></td>
		<td>${student.age}</td>
		<td>${student.qual}</td>
		<td>${student.phone}</td>
	
	</tr>
</c:forEach>
</table>

<a href="downloads.com">DOWNLOADS</a>
</body>
</html>