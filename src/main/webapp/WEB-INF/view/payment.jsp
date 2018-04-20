<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<div class="container" style="padding-left: 10%;">
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                   
                </div>
                <div class="panel-body">
                    <form role="form">
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required="required" />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" required="required" />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" required="required" /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CV CODE</label>
                                <input type="password" class="form-control" id="cvCode" placeholder="CV" required="required" />
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
           
            <br/>
            <a href="paysuccess" class="btn btn-success btn-lg btn-block" role="button">Pay</a>
               <h3 align="center">Total &nbsp;&nbsp;<span class="label label-default">${total}</span></h3>
          </div>


<div style="padding-left: 70%;" >
<h3>${name}</h3>

<h3><b> Shipping Address</b></h3>
<h4>${address}</h4>
<br>
<div class="container">
<button type="button" class=" btn btn-success" data-toggle="modal" data-target="#myModal">Edit Address</button>
 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Address</h4>
        </div>
        <div class="modal-body">
        <form action="editaddress">
         <input type="text" name="address1" style="width: 100%;" required="required">
         <input type="hidden" name="id" value="${selectedProductId}">
                 <div class="modal-footer">
         
         <button type="submit" class="btn btn-success">Save</button></div>
         
         </form>
        </div>
        
      </div>
    </div>
  </div>
</div>
</div>


</body>
</html>