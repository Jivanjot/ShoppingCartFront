<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="productsave" method="post">
<table>
<tr>
<td>Id</td>
<td><input type="text" name="id" ></td></tr>

<tr>
<td>Name</td>
<td><input type="text" name="name" ></td></tr>

<tr>
<td>Description</td>
<td><input type="text" name="description" ></td></tr>

<tr>
<td>Category Id</td>
<td><input type="text" name="categoryId" ></td></tr>

<tr>
<td>Supplier Id</td>
<td><input type="text" name="supplierId" ></td></tr>


<tr>
<td><input type="submit" value="Save">
</td></tr>
</table>

</form>




</body>
</html>