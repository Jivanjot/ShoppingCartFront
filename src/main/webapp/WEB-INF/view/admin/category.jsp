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

	<form id="myForm" action="categorysave" method="post"
		onsubmit="myFunction()">
		<table align="center">
			<tr>
				<td style="font-family: sans-serif;font: bold;">Id</td>
				<td><input type="text" name="id" value="${selectedcategory.id}"></td>
			</tr>

			<tr>
				<td style="font-family: sans-serif;font: bold;">Name</td>
				<td><input type="text" name="name"
					value="${selectedcategory.name}"></td>
			</tr>

			<tr>
				<td style="font-family: sans-serif;font: bold;">Description</td>
				<td><input type="text" name="description"
					value="${selectedcategory.description}"></td>
			</tr>


			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>

	</form>
	<br>
	<br>
	<br>

	<div>
		<h2 align="center">Category List</h2>
		<br>
		<table border="1px solid" border: medium; align="center">
			<tr>
				<th bgcolor="grey">Category Id</th>
				<th bgcolor="grey">Category Name</th>
				<th bgcolor="grey">Category Description</th>
				<th bgcolor="grey">Action</th>
			</tr>

			<c:forEach items="${categories}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="categorydelete?id=${category.id}">Delete</a>| <a
						href="categoryupdate?id=${category.id}">Edit</a></td>
				</tr>
			</c:forEach>



		</table>


	</div>

</body>
</html>