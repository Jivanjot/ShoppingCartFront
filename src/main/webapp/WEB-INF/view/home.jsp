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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Shopping Cart</title>
<style>
#footer {
	background: #ffab62;
	width: 100%;
	height: 60px;
	position: absolute;
	bottom: 0;
	left: 0;
	clear: both;
	position: relative;
	z-index: 10;
}

@media all and (min-width: 768px) {
	.nav {
		text-align: left;
		-webkit-flex: 1 auto;
		flex: 1 auto;
		-webkit-order: 1;
		order: 1;
	}
	.article {
		-webkit-flex: 5 0px;
		flex: 5 0px;
		-webkit-order: 2;
		order: 2;
	}
	footer {
		-webkit-order: 3;
		order: 3;
	}
}
</style>
</head>
<body>
	<br>
	<center>
		<h1 style="font-family: inherit;">Welcome to shopping cart</h1>
	</center>



	<c:if test="${empty loggedInUser}">
		<a href="login"
			style="padding-right: 2%; padding-left: 2%; font-size: large;"> <span
			class="glyphicon glyphicon-log-in"></span>Login
		</a>
	</c:if>
	<c:if test="${ empty loggedInUser}">
		<a href="register" style="font-size: large;"><span
			class="glyphicon glyphicon-user"></span> Signup</a>
	</c:if>
	<c:if test="${not empty loggedInUser}">
		<a href="mycart"
			style="float: right; padding-right: 8%; font-size: large;"> <span
			class="glyphicon glyphicon-shopping-cart"></span> MyCart(${size})
		</a>
	</c:if>
	<br>
	<br>
	<c:if test="${not empty loggedInUser}">
		<a href="orderplaced"
			style="float: right; padding-right: 4%; font-size: large;"> <span
			class="glyphicon glyphicon-ok-circle"></span> Placed Orders(${size1})
		</a>
	</c:if>
	<br>
	<br>


	<c:if test="${not empty loggedInUser}">
		<a href="logout"
			style="float: right; padding-right: 10%; font-size: large;"><span
			class="glyphicon glyphicon-log-out"></span> Logout</a>
	</c:if>

	<h2 style="font-family: fantasy;">${welcomename}</h2>




	<jsp:include page="productmenu.jsp"></jsp:include>
	<br>
	<br>
	<br>

	<c:if test="${empty loggedInUser}">
		<jsp:include page="slide.jsp"></jsp:include>
	</c:if>

<c:if test="${defaultImages==true}">

<c:if test="${not empty loggedInUser}">
<c:if test="${empty clickedselecteditem}">

<jsp:include page="defaultimages.jsp"></jsp:include>
</c:if></c:if></c:if>
	
	
	
	
	
	${Error} ${mail }
	<br> ${success} ${error1} ${uploadphoto} ${addcartmessage}




	<c:if test="${isAdmin==true}">
		<jsp:include page="admin/adminhome.jsp"></jsp:include></c:if>

	<c:if test="${clickedselecteditem==true}">
		<br>
		<br>
		<br>
		<jsp:include page="selecteditem.jsp"></jsp:include>
		<br>
		<br>
	</c:if>


	<c:if test="${isUserClickedLogin==true}">
		<br>
		<br>
		<br>
		<br>
		<br>

		<jsp:include page="login.jsp"></jsp:include><br>
	</c:if>
	<br>


	<c:if test="${isUserClickedRegister==true}">
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>

		<jsp:include page="register.jsp"></jsp:include><br>
		<br>
	</c:if>
	<c:if test="${isUserClickedCart==true}">
		<jsp:include page="cart.jsp"></jsp:include><br>
		<br>
	</c:if>
	<c:if test="${isUserClickedOrderPlaced ==true}">
		<jsp:include page="orderPlaced.jsp"></jsp:include>
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

	<br>
	<br>

	<div id="footer">
		<h5 style="float: left;">
			<a href="about" style="color: white; padding-left: 100%;">About</a>
		</h5>
		<br>
		<h5 align="right" style="padding-right: 2%;">Copyright &copy;
			shoppingcart.com</h5>
	</div>

</body>
</html>