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
	<form id="myForm" action="categorysave" method="post"
		onsubmit="myFunction()">
		<table align="center" width="500">
			<tr>
				<td style="font-size: large;">Id</td>
				<td style="font-size: large;"><input type="text" name="id" value="${selectedcategory.id}" required="required"></td>
			</tr>

			<tr>
				<td style="font-size: large;">Name</td>
				<td style="font-size: large;"><input type="text" name="name"
					value="${selectedcategory.name}" required="required"></td>
			</tr>

			<tr>
				<td style="font-size: large;">Description</td>
				<td style="font-size: large;"><input type="text" name="description"
					value="${selectedcategory.description}" required="required"></td>
			</tr>


			
		</table><br><br>
         <input type="submit" value="Save" class="btn btn-success" style="text-align: center;">
	</form>
	</div>
	
	

<div> 
		<h2 align="center">Category List</h2>
		<br>
		<div class="col-xs-2">
		<input  id="myInput" class="form-control" type="text" placeholder="Search.." ></div>
		
		<table border="1px solid" border: medium; align="center" class="table table-dark table-striped">
		<thead>
			<tr>
				<th style="font-size: large;">Category Id</th>
				<th style="font-size: large;">Category Name</th>
				<th style="font-size: large;">Category Description</th>
				<th style="font-size: large;">Action</th>
			</tr>
</thead>

			<c:forEach items="${categories}" var="category">
<tbody  id="myTable">				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="categorydelete?id=${category.id}">Delete</a>| <a
						href="categoryupdate?id=${category.id}">Edit</a></td>
				</tr>
		</tbody>
			</c:forEach>

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