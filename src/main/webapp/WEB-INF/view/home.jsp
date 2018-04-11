<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>


</head>
<body>
	<br>
	<center>
		<h1>Welcome to shopping cart</h1>
	</center>





	<c:if test="${empty loggedInUser}">
		<a href="login"
			style="padding-right: 2%; padding-left: 2%; font-size: large;">
			<span class="glyphicon glyphicon-log-in"></span>Login
		</a>
	</c:if>
	<c:if test="${ empty loggedInUser}">
		<a href="register" style="font-size: large;"><span
			class="glyphicon glyphicon-user"></span> Signup</a>
	</c:if>
	<c:if test="${not empty loggedInUser}">
		<a href="logout"
			style="float: right; padding-right: 2%; font-size: large;"><span
			class="glyphicon glyphicon-log-out"></span> Logout</a>
	</c:if>
	<c:if test="${not empty loggedInUser}">
		<a href="mycart"
			style="float: right; padding-right: 2%; font-size: large;"> <span
			class="glyphicon glyphicon-shopping-cart"></span> MyCart(${size})
		</a>
	</c:if>

	<br>
	<br>
	<c:if test="${not empty loggedInUser}">
		<a href="orderplaced"
			style="float: right; padding-right: 6%; font-size: large;"> <span
			class="glyphicon glyphicon-ok-circle"></span> Placed Orders(${size1})
		</a>
	</c:if>
	<h4>${welcomename}</h4>



	<hr color="blue" size="5">
	<jsp:include page="productmenu.jsp"></jsp:include>


	${Error} ${mail }
	<br> ${success} ${error1} ${uploadphoto} ${addcartmessage}
	<br>
	<br>

	<c:if test="${isAdmin==true}">
		<jsp:include page="admin/adminhome.jsp"></jsp:include></c:if>

	<c:if test="${clickedselecteditem==true}">
		<jsp:include page="selecteditem.jsp"></jsp:include>
	</c:if>


	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include></c:if>


	<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="register.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedCart==true}">
		<jsp:include page="cart.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedOrderPlaced ==true}">
		<jsp:include page="orderPlaced.jsp"></jsp:include>
	</c:if>
	<c:if test="${enablemodal==true}">
		<script>
			window.alert("Order Placed Successfully");
		</script>
	</c:if>
	<c:if test="${inValidateEmail==true}">
		<script>
			window.alert("Use correct syntax of email");
		</script>
	</c:if>
	<c:if test="${notExistEmail==true}">
		<script>
			window.alert("Email should be exist in gmail");
		</script>
	</c:if>
	
	
</body>
</html>