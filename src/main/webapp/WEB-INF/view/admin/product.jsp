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


	<form action="productsave" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" value="${selectedproduct.id}"></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${selectedproduct.name}"></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><input type="text" name="description" value="${selectedproduct.description}"></td>
			</tr>

<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="${selectedproduct.price}"></td>
			</tr>


			<tr>
				<td>Category </td>
				<td><select>
						<c:forEach items="${categories }" var="category">
							<option value="${category.id}" id="categoryId">${category.name}
							</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>Supplier </td>
				<td><select>
						<c:forEach items="${suppliers }" var="supplier">
							<option value="${supplier.id}" id="supplierId">${supplier.name}
							</option>
						</c:forEach>
				</select></td>
			</tr>


			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>

	</form>

	<div>

		<h2>Products List</h2>
		<table border="1px solid" border: medium;">
			<tr>
				<td>Product Id</td>
				<td>Product Name</td>
				<td>Product Description</td>
				<td>Product Price</td>
				<td>Category Id</td>
				<td>Supplier Id</td>
				<td>Action</td>
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