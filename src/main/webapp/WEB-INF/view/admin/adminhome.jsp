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

<a href="managecategories"  style="font-family: sans-serif;font-size: medium;">Manage Categories</a>&emsp;
<a href="managesuppliers"  style="font-family: sans-serif;font-size: medium;" >Manage Suppliers</a>&emsp;
<a href="manageproducts"  style="font-family: sans-serif;font-size: medium;">Manage Products</a>&emsp;<br><br><br><br>



<c:if test="${isAdminClickedCategory==true}">
<jsp:include page="category.jsp"></jsp:include>
</c:if>



<c:if test="${isAdminClickedSupplier==true}">
<jsp:include page="supplier.jsp"></jsp:include>
</c:if>

<c:if test="${isAdminClickedProduct==true}">
<jsp:include page="product.jsp"></jsp:include>
</c:if>

</body>
</html>