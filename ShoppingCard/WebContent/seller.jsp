<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function save(){
	alert("save...");
	document.forms[0].action="saveseller.com";
	document.forms[0].submit();
}
function Getall(){
	alert("Getall...");
	document.forms[0].action="getallseller.com";
	document.forms[0].submit();
}

function Update(){
	alert("Update...");
	document.forms[0].action="updateseller.com";
	document.forms[0].submit();
}
function Delete(){
	alert("Delete...");
	document.forms[0].action="deleteseller.com";
	document.forms[0].submit();
}
function getbill(){
	
	document.forms[0].action="getbill.com";
	document.forms[0].submit();
}


</script>
</head>
<body bgcolor="powderblue" font-color="blue">
<a href="login.com">Login</a> || <a href="test.com">Seller</a>||<a href="getallseller.com">Buyer</a>||
		<a href="bill.jsp">Order</a>
username::${username}
<form:form commandName="seller" >
<fieldset>
<table border="5" bordercolor='blue' >
<legend>Product Details</legend>
<tr><th>Product Id::</th>  <td><form:input path="id"/></td></tr>
<tr><th>Product Name::</th> <td><form:input path="name"/></td>

<tr><th>Product Type:: </th> <td><form:input path="type"/></td></tr>
<tr><th>Product Cost::</th> <td><form:input path="cost"/></td></tr>


<tr><th><input type="button" onclick="save()"value="save"></th>
<th><input type="button" onclick="Getall()"value="getall"></th></tr>

<tr><th><input type="button" onclick="Update()"value="update"></th>
<th><input type="button" onclick="Delete()"value="delete"></th></tr>
<tr><th><input type="button" value="Orders" onclick="getbill()"></th></tr>

</fieldset>
</table>
</form:form>

<table border="2">
<tr>
		<th>PId</th>
		<th>Ptype</th>
		<th>Pcost</th>
		

</tr>
<c:forEach items="${sellers}" var="seller" >
<tr>
	<td>${seller.id}</td>
	<td><a href="getsellerById.com?id=${seller.id}">${seller.name}</a></td>
	<td>${seller.type}</td>
	<td>${seller.cost}</td>
	
</tr>

</c:forEach>

</table>
</body>
</html>

<form:form commandName="bill">
<%-- <fieldset>
id::<form:input path="id"/><br>
Quantity::<form:input path="quan"/><br>
BuyerName::<form:input path="bname"/><br>
BuyerAddress::<form:input path="baddress"/><br> --%>


</fieldset>
</form:form>
<table border="2">
	<tr>
		<th>Id</th>
		<th>QUAN</th>
		<th>NAME</th>
		<th>ADDRESS</th>
	</tr>
<c:forEach items="${bills}" var="bill">
	<tr>
		<td>${bill.id}</td>
		<td><a href="getBuyuyerById.com?id=${bill.id}">${bill.quan}</a></td>
		<td>${bill.bname}</td>
		<td>${bill.baddress}</td>
	</tr>

</c:forEach>
</table>
</body>
</html>