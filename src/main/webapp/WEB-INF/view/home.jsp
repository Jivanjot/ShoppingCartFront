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
	<center>
		<h2>Welcome to shopping cart</h2>
	</center>
	
	
	<br>
	<a href="login"> Login</a>
	<a href="register"> Signup</a>
	<hr color="blue" size="5">
	<jsp:include page="productmenu.jsp"></jsp:include>
	
${name}
${Error}<br><br>
	
<c:if test="${isAdmin==true}">
<jsp:include page="admin/adminhome.jsp"></jsp:include></c:if>

	
${success}
${error1}	
	
	<c:if test="${isUserClickedLogin==true}">
	<jsp:include page="login.jsp"></jsp:include></c:if>
		
	
<c:if test="${isUserClickedRegister==true}">
		<jsp:include page="register.jsp"></jsp:include>
</c:if>	

</body>
</html>