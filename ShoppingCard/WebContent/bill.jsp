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

function bill(){
	
	document.forms[0].action="bill.com";
	document.forms[0].submit();
}
 function getbill(){
	
	document.forms[0].action="getbill.com";
	document.forms[0].submit();
} 
 function UpdateOrder(){
		alert("Update...");
		document.forms[0].action="Updateorder.com";
		document.forms[0].submit();
	}
	function DeleteOrder(){
		alert("Delete...");
		document.forms[0].action="Deleteorder.com";
		document.forms[0].submit();
	}

</script>
</head>
<body>
<a href="login.com">Login</a> || <a href="test.com">Seller</a>||<a href="getallseller.com">Buyer</a>||
		<a href="bill.com">Order</a>
<form:form commandName="bill">
<fieldset>
id::<form:input path="id"/><br>
Quantity::<form:input path="quan"/><br>
BuyerName::<form:input path="bname"/><br>
BuyerAddress::<form:input path="baddress"/><br>
<input type="button" value="Ordersave" onclick="bill()">
<input type="button" value="Update" onclick="UpdateOrder()">
<input type="button" value="Delete" onclick="DeleteOrder()">
<input type="button" value="getall" onclick="getbill()">
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