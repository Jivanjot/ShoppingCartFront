<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Simple Login Form</title>

<style type="text/css">
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
    #message {
    display:none;
    background: #f1f1f1;
    color: #000;
    position: relative;
    padding: 20px;
    margin-top: 10px;
}

#message p {
    padding: 10px 35px;
    font-size: 18px;
}
    
</style>
</head>
<script>
		var myInput = document.getElementById("psw");
 var letter = document.getElementById("letter");
 var capital = document.getElementById("capital");
 var number = document.getElementById("number");
 var length = document.getElementById("length");

 // When the user clicks on the password field, show the message box
 myInput.onfocus = function() {
     document.getElementById("message").style.display = "block";
 }

 // When the user clicks outside of the password field, hide the message box
 myInput.onblur = function() {
     document.getElementById("message").style.display = "none";
 }

 // When the user starts to type something inside the password field
 myInput.onkeyup = function() {
   // Validate lowercase letters
   var lowerCaseLetters = /[a-z]/g;
   if(myInput.value.match(lowerCaseLetters)) {  
     letter.classList.remove("invalid");
     letter.classList.add("valid");
   } else {
     letter.classList.remove("valid");
     letter.classList.add("invalid");
   }
   
   // Validate capital letters
   var upperCaseLetters = /[A-Z]/g;
   if(myInput.value.match(upperCaseLetters)) {  
     capital.classList.remove("invalid");
     capital.classList.add("valid");
   } else {
     capital.classList.remove("valid");
     capital.classList.add("invalid");
   }

   // Validate numbers
   var numbers = /[0-9]/g;
   if(myInput.value.match(numbers)) {  
     number.classList.remove("invalid");
     number.classList.add("valid");
   } else {
     number.classList.remove("valid");
     number.classList.add("invalid");
   }
   
   // Validate length
   if(myInput.value.length >= 8) {
     length.classList.remove("invalid");
     length.classList.add("valid");
   } else {
     length.classList.remove("valid");
     length.classList.add("invalid");
   }

</script>

<body>
<div class="login-form" >
    <form onsubmit=" return myfun()" name="form1" action="register"  method="post">
        <h2 class="text-center">Sign Up</h2>       
        <div class="form-group">
            <input type="text" name="name" class="form-control" placeholder="Name" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="email" placeholder="Email" required="required">
        </div>


 
        <div class="form-group">
            <input type="number" class="form-control" name="mobile" placeholder="Mobile">
        </div>


        <div class="form-group">
            <input type="text" class="form-control" name="address" placeholder="Address" required="required">
        </div>



        <div class="form-group">
            <input type="password"  id="pass" class="form-control" name="pass" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required="required">
        </div>

        <div class="form-group">
            <input type="password"  id="pass1" class="form-control" name="pass1" placeholder="Confirm Password"  required="required" >
        </div>

       
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
        </div>
<span id="demo" style="color:red">     
    </form>
    
</div>
<div id="message">
  <h3>Password must contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div>

<script>
  function myfun(){
	
	
	var a=document.getElementById("pass").value;
	var b=document.getElementById("pass1").value;
	if(a!=b)
		{
		document.getElementById("demo").innerHTML="Passwords are not same";
		return false;
		}
	} </script>

</body>
</html>                                		                            