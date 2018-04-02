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
<script>
function myFunction() {
    document.getElementById("myForm").refresh();
}
</script>


	<form id="myForm"  action="productsave" method="post" onsubmit="myFunction()" enctype="multipart/form-data" >
		<table align="center">
			<tr>
				<td style="font-family: sans-serif;font: bold;">Id</td>
				<td><input type="text" name="id" value="${selectedproduct.id}"></td>
			</tr>

			<tr>
				<td style="font-family: sans-serif;font: bold;">Name</td>
				<td><input type="text" name="name" value="${selectedproduct.name}"></td>
			</tr>

			<tr>
				<td style="font-family: sans-serif;font: bold;">Description</td>
				<td><input type="text" name="description" value="${selectedproduct.description}"></td>
			</tr>

<tr>
				<td style="font-family: sans-serif;font: bold;">Price</td>
				<td><input type="text" name="price" value="${selectedproduct.price}"></td>
			</tr>


			<tr>
				<td style="font-family: sans-serif;font: bold;">Category </td>
				<td><select name="categoryId">
						<c:forEach items="${categories }" var="category">
							<option value="${category.id}">${category.name}
							</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td style="font-family: sans-serif;font: bold;">Supplier </td>
				<td><select name="supplierId">
						<c:forEach items="${suppliers }" var="supplier">
							<option  value="${supplier.id}" >${supplier.name}
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
			<td style="font-family: sans-serif;font: bold;">Upload Image</td>
			<td><input type="file" name="file">   </td>
			</tr>


			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>

	</form>

	<div>

		<h2 align="center">Products List</h2>
		<table border="1px solid" border: medium; align="center">
			<tr>
				<th bgcolor="grey">Product Id</th>
				<th bgcolor="grey">Product Name</th>
				<th bgcolor="grey">Product Description</th>
				<th bgcolor="grey">Product Price</th>
				<th bgcolor="grey">Category Id</th>
				<th bgcolor="grey">Supplier Id</th>
				<th bgcolor="grey">Action</th>
			</tr>


			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
                     <td>${product.price}</td>
                     
					<td>${product.categoryId}</td>
					<td>${product.supplierId}</td>
					<td><a href="productdelete?id=${product.id}">Delete</a>| <a
						href="productupdate?id=${product.id}">Edit</a></td>
				</tr>
			</c:forEach>



		</table>



	</div>




</body>
</html>