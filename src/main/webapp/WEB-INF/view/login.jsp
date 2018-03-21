<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login Form</title>
<style>
body{
font-family:Arial;
background:#fff;
}
.login{
background:#3498db;
padding:40px;
width:240px;
margin:auto;
margin-top:70px;
height:300px;

}
form
{
width:240px;
text-align:center;
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
h2{
color:grey;
}



</style>
</head>
<body>
<div class="login">
<form action="validate" method="post">
<h2>Login</h2>
<br>

EMAIL<input type="text" name="email" placeholder="Email Id" style="text-transform:lowercase;" required>
<br>
<br>
PASSWORD<input type="password" name="password" placeholder="Password" required>
<br>
<br>
<input type ="submit" value="Login">
<input type="reset" value="Reset">
<br>
<br>


</form>
</div>


</body>
</html>