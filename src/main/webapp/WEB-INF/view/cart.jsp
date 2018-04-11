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
<div style="text-align: center;">
<img align="middle" style="text-align: center;"   height="200" alt="productimage" src= "${uploadPhotoPath}${cart.productId}.PNG">


<table width="300" align="center">
 

<tr><td style="font-size: large;">Product Name:          </td>
<td><input type="hidden" value="${cart.productname}" name="name"><h4>${cart.productname}</h4></td></tr>

<tr><td style="font-size: large;">Product Price:          </td>
<td><input type="hidden" value="${cart.price}" name="price" ><h4>${cart.price}</h4>
</td></tr>

<tr><td style="font-size: large;">Quantity          </td>
<td><input type="hidden" name="quantity" value="${cart.quantity }"><h4>${cart.quantity }</h4>
</td></tr>

</table>
<a href="deleteitem?item=${cart.id}&email=${cart.email}">Delete this from cart</a> 
</div>
<br><br>
</c:forEach>
<form action="placeorder" method="post">
<div style="text-align: right;">
    <button type="submit" style="text-align: right;margin-right:10%;margin-bottom: 5%;" class="btn btn-primary btn-md">Place your order</button>    
  </div>
</form>
</body>
</html>