<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="suppliersave" method="post">
<table>
<tr>
<td>Id</td>
<td><input type="text" name="id" value="${selectedsupplier.id}"></td></tr>

<tr>
<td>Name</td>
<td><input type="text" name="name" value="${selectedsupplier.name}" ></td></tr>

<tr>
<td>Address</td>
<td><input type="text" name="address" value="${selectedsupplier.address}"></td></tr>


<tr>
<td><input type="submit" value="Save">
</td></tr>
</table>

</form>
<div>
<table>
<tr><td>Id</td>
<td>Name</td>
<td>Address</td>                   
<td>Action</td> 
</tr>

<c:forEach items="${suppliers}" var="supplier">

<tr>
<td> ${supplier.id}                 </td>
<td> ${supplier.name }                </td>
<td> ${supplier.address}                 </td>
<td><a href="supplierdelete?id=${supplier.id}">Delete</a> | <a href="supplierupdate?id=${supplier.id}">Edit</a> </td>

</tr>

</c:forEach>



</table>

</div>

</body>
</html>