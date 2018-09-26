<%@page import="com.slokam.pojo.familypojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">


function SaveFamily(){
	
	
	alert("SaveFamily.....");
	document.forms[0].action="savedata";
	document.forms[0].submit();
	
	
}
function UpdateFamily(){
	alert("Updatefamily.....");
	document.forms[0].action="updatefamily";
	document.forms[0].submit();

}
function DeleteFamily(){
	alert("DeleteFamily.....");
	document.forms[0].action="Deletefamily";
	document.forms[0].submit();

}
function GetdataFamily(){
	alert("getdataFamily.....");
	document.forms[0].action="getall";
	document.forms[0].submit();

}





</script>
</head>
<body>


<%
String fm=(String)request.getAttribute("message");
if(fm!=null){
	
	out.print(fm);
}
%>
<%
familypojo fm1=(familypojo)request.getAttribute("getdata");
String id="";
String name="";
String age="";
String fname="";
String mname="";
String address="";
String phone="";

if(fm1!=null){
	//fm1=new familypojo();
	
	id=fm1.getId()+"";
	name=fm1.getName();
	age=fm1.getAge();
	fname=fm1.getFname();
	mname=fm1.getMname();
	address=fm1.getAddress();
	phone=fm1.getPhone();
	
}

%>

<fieldset>
User::<%=session.getAttribute("user") %>
 Request count:: ${reqcount }
 TotalCount:: ${totalcount }
 <a href="Activeusers">Display All Users</a>
<form action="savedata">
<h1>Family Details</h1>
ID::<input type='text' name='id'    value ='<%=id%>'>  <br>
NAME::<input type='text' name='name' value ='<%=name%>'><br>
AGE::<input type='text' name='age' value ='<%=age%>'><br>

FATHER NAME::<input type='text' name='fname' value ='<%=fname%>'><br>
Mother NAME::<input type='text' name='mname' value ='<%=mname%>'><br>

ADDRESS	::<input type='text' name='address' value ='<%=address%>'><br>
PHONE NO::<input type='text' name='phone' value ='<%=phone%>'><br>

<input type='button' onclick="SaveFamily()" value='Save'>
<input type='button'  onclick="UpdateFamily()"value='Update'>
<input type='button' onclick="DeleteFamily()"value='Delete'>
<input type='button' onclick="GetdataFamily()"value='Getall'>

</form>
</fieldset>
 

</body>
</html>