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
<div style="text-align: center;">
<img height="300" src="${uploadPhotoPath}" alt="product image" ><br><br>
<table align="center" width="500">

<tr><td style="font-size: large;">Product Name:          </td>
<td style="font-size: large;"><input type="hidden" value="${selectedproduct.name}" name="name" >${selectedproduct.name}</td>

</tr>

<tr><td  style="font-size: large;">Product Description:          </td>
<td  style="font-size: large;"><input type="hidden" value="${selectedproduct.description}" name="description" >${selectedproduct.description}</td>

</tr>

<tr><td  style="font-size: large;">Product Price:          </td>
<td  style="font-size: large;"><input type="hidden" value="${selectedproduct.price}" name="price" >${selectedproduct.price}</td>

</tr>

<tr><td  style="font-size: large;">Quantity          </td>
 <td  style="font-size: large;"><input type="number" name="quantity" value="1" required="required" >
</td></tr>
<tr><td  style="font-size: large;"><input type="hidden" name="id" value="${selectedproduct.id}"></td></tr>



</table><br>
<input type="submit" value="add to cart"  class="btn btn-success" style="text-align: center;">
</div>

</form>



</body>
</html>