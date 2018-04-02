<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<style>

</style>
</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header"></div>
      
    
    <ul class="nav navbar-nav">
	
    <c:forEach items="${categories}" var="category"> 
     <li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">${category.name}<span class="caret"></span></a>
     
   
    
     <ul class="dropdown-menu">
     
 <c:forEach items="${category.products}" var="products">
				 <li><a href ="productselect?id=${products.id}">${products.name}</a></li>
	
				 </c:forEach> 
	 </ul>
				
     
    
     
     
     
   </li>  
    </c:forEach>
   

</ul>

</div>
</nav>


</body>
</html>
