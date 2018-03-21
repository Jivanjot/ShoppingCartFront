<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
body{
font-family:Arial;
background:#fff;
}
.signup
{
background:#3498db;
padding:60px;
width:240px;
margin:auto;
margin-top:70px;
padding-bottom:270px;
padding-top:50px;

height:300px;
}
form
{
width:240px;

text-align:center;
}
h2{
color:grey;
}

input{
width:240px;
text-align:center;
background:#ecff1;
border:2px solid transparent;
border-radius:3px;
font-size:16px;
font-weight:200;
padding:10px;
transition:border .5s;
}
input[type=submit]{
border:2px solid transparent;
background:#3498db;
color:white;
font-size:16px;
line-height:25px;
padding:10px 0;
border-radius:3px;
}
input[type=submit]:hover{
background:#2980b9;
}
input[type=radio]
{
text-align:left;
}

</style>
<title>SignUp Form</title>
</head>
<script>
function myfun(){
	var a=document.getElementById("pass").value;
	var b=document.getElementById("pass1").value;
	if(a!=b)
		{
		document.getElementById("demo").innerHTML="Passwords are not same";
		return false;
		}
	
	
}
</script>


<body>

<form class="signup" onsubmit="return myfun()" action="register" method="post">
<h2>SignUp</h2>
Name: <input type="text" name="name" placeholder="Name" required><br><br>
Email Id:<input type="text" name="email" placeholder="Email" style="text-transform:lowercase;" required><br><br>
Mobile No: <input type="number" name="mobile" placeholder="Mobile" required><br><br>
Password:<input type="password" id="pass" name="pass" placeholder="Password" required>
<span id="demo" style="color:red"></span><br><br>

Confirm Password:<input type="password" id="pass1" name="pass1" placeholder="Confirm Password" required><br><br>
  



<input  type="submit" value="SignUp"><br>
<input type="Reset" value="Reset">




</form>



</body>
</html>