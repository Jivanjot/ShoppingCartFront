<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addcart" method="post">
<table align="center" width="500">
<tr><td><img src="${productimage}" alt="product image" >
                        </tr>
<tr><td>Product Name:          </td>
<td><input type="hidden" value="${selectedproduct.name}" name="name" >${selectedproduct.name}</td>

</tr>

<tr><td>Product Description:          </td>
<td><input type="hidden" value="${selectedproduct.description}" name="description" >${selectedproduct.description}</td>

</tr>

<tr><td>Product Price:          </td>
<td><input type="hidden" value="${selectedproduct.price}" name="price" >${selectedproduct.price}</td>

</tr>

<tr><td>Quantity          </td>
 <td><input type="number" name="quantity" value="1" >
</td></tr>

<tr> <td><input type="submit" value="add to cart">
</tr>

</table>


</form>



</body>
</html>