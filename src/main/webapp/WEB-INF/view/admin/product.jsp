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

<div style="text-align: center;">
	<form id="myForm"  action="productsave" method="post" onsubmit="myFunction()" enctype="multipart/form-data" >
		<table align="center" width="500">
			<tr>
				<td style="font-size: large;">Id</td>
				<td style="font-size: large;"><input type="text" name="id" value="${selectedproduct.id}" required="required"></td>
			</tr>

			<tr>
				<td style="font-size: large;" >Name</td>
				<td style="font-size: large;"><input type="text" name="name" value="${selectedproduct.name}" required="required"></td>
			</tr>

			<tr>
				<td style="font-size: large;">Description</td>
				<td style="font-size: large;"><input type="text" name="description" value="${selectedproduct.description}" required="required"></td>
			</tr>

<tr>
				<td style="font-size: large;" >Price</td>
				<td style="font-size: large;"><input type="text" name="price" value="${selectedproduct.price}" required="required"></td>
			</tr>


			<tr>
				<td style="font-size: large;">Category </td>
				<td style="font-size: large;"><select name="categoryId">
						<c:forEach items="${categories }" var="category">
							<option value="${category.id}">${category.name}
							</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td style="font-size: large;">Supplier </td>
				<td style="font-size: large;"><select name="supplierId">
						<c:forEach items="${suppliers }" var="supplier">
							<option  value="${supplier.id}" >${supplier.name}
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
			<td style="font-size: large;">Upload Image</td>
			<td style="font-size: large;" ><input type="file" name="file" >   </td>
			</tr>

		</table><br><br>
<input type="submit" value="Save" class="btn btn-success">
	</form>
</div>
	<div>

		<h2 align="center">Products List</h2>
		<div class="col-xs-2">
		<input  id="myInput" class="form-control" type="text" placeholder="Search.." ></div>
		<table border="1px solid" border: medium; align="center" class="table table-dark table-striped">
			<thead><tr>
				<th style="font-size: large;">Product Id</th>
				<th style="font-size: large;">Product Name</th>
				<th style="font-size: large;">Product Description</th>
				<th style="font-size: large;">Product Price</th>
				<th style="font-size: large;">Category Id</th>
				<th style="font-size: large;">Supplier Id</th>
				<th style="font-size: large;">Action</th>
			</tr></thead>


			<c:forEach items="${products}" var="product">
<tbody id="myTable">				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
                     <td>${product.price}</td>
                     
					<td>${product.categoryId}</td>
					<td>${product.supplierId}</td>
					<td><a href="productdelete?id=${product.id}">Delete</a>| <a
						href="productupdate?id=${product.id}">Edit</a></td>
				</tr>
		</tbody>	</c:forEach>



		</table>



	</div>
<script >
$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
	</script>




</body>
</html>