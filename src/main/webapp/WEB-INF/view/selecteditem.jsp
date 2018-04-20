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
<img height="200" src="${uploadPhotoPath}${selectedproduct.id}.PNG" alt="product image"><br><br>
<table align="center" width="400" >

<tr ><td style="font-size: large;text-align: left;">Product Name:</td>
<td style="font-size: large;"><input type="hidden" value="${selectedproduct.name}" name="name" >${selectedproduct.name}</td>

</tr>

<tr><td  style="font-size: large;text-align: left;">Product Description:          </td>
<td  style="font-size: large;"><input type="hidden" value="${selectedproduct.description}" name="description" >${selectedproduct.description}</td>

</tr>

<tr><td  style="font-size: large;text-align: left;">Product Price:          </td>
<td  style="font-size: large;"><input type="hidden" value="${selectedproduct.price}" name="price" >${selectedproduct.price}</td>

</tr>

<tr><td  style="font-size: large;text-align: left;">Quantity          </td>
 <td  style="font-size: large;"><input type="number" name="quantity" value="1" id="quantity" required="required" >
</td></tr>
<tr><td  style="font-size: large;"><input type="hidden" name="id" value="${selectedproduct.id}"></td></tr>



</table><br>
<input type="submit" value="add to cart"  class="btn btn-success" style="text-align: center;">
  <a href="buynow?id=${selectedproduct.id}" class="btn btn-warning" role="button">Buy Now</a>

</div>
</form>



</body>
</html>