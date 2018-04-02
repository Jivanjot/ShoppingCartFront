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
<c:forEach items="${carts}" var="cart">
<table width="200">

<tr><td>Product Name:          </td>
<td><input type="hidden" value="${cart.productname}" name="name">${cart.productname}</td></tr>

<tr><td>Product Price:          </td>
<td><input type="hidden" value="${cart.price}" name="price" >${cart.price}
</td></tr>

<tr><td>Quantity          </td>
<td><input type="hidden" name="quantity" value="${cart.quantity }">${cart.quantity }
</td></tr>
<br><br>


</table>
</c:forEach>
</body>
</html>