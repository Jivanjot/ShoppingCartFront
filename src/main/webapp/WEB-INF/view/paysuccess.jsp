<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body { margin-top:20px; }
.panel-title {display: inline;font-weight: bold;}
.checkbox.pull-right { margin: 0; }
.pl-ziro { padding-left: 0px; }

</style>
</head>
<body>
<div class="page-header" style="color:teal;text-align: center;">
  <h1>Shopping Cart</h1>
</div>

 
<div style="float: left;padding-left: 15%"><h2>Invoice #${invoiceId }</h2></div>
<div style="float: right;padding-right: 15%"><h2>Order #${orderNo}</h2></div>
<br><br><br><br>
<div style="text-align: center;">

<table align="center">
<tr><th><h3><b>Billed to:</b></h3>   </th></tr>
<tr>  <td><h5>${name }        </h5></td></tr>
<tr>  <td><h5>${address}        </h5></td></tr>

<tr><th><h4><b>Payment Method</b></h4></th></tr>
<tr>  <td><h5>Card payment  </h5> </td></tr>

<tr><th><h4><b>Date</b></h4></th></tr>
<tr>  <td><h5>${date}  </h5> </td></tr>
</table>
</div>

<br><br><br>
<div class="container" style="text-align: center;">
<form action="home1">
 <button type="submit" class="btn btn-primary btn-lg"> <span class="glyphicon glyphicon-home"></span> Continue Shopping</button></form>

</div>

</body>
</html>