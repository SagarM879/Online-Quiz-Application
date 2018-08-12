<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.10.2.js"></script>

<title>Quiz-Register User</title>

<script>
	var userName = null;
	var firstName = null;
	var lastName = null;
	var email = null;
	var password = null;
	var rePassword = null;
	var recoveryQue = null;
	var recoveryAns = null;

	function myFunction() {

		//alert(loginname + "  " + email + "  " + fname + "  " + lname + "  " + password
		//		+ "  " + repassword + "  " + dob + "  " + SQ + "  "+SA);
		userName = document.form1.userName.value;
		firstName = document.form1.firstName.value;
		lastName = document.form1.lastName.value;
		email = document.form1.email.value;
		password = document.form1.password.value;
		rePassword = document.form1.rePassword.value;
		recoveryQue = document.form1.recoveryQue.value;
		recoveryAns = document.form1.recoveryAns.value;

		 		alert(userName + "  " + firstName + "  " + lastName + "  " + email + "  " + password
 		 				+ "  " + rePassword + "  " + recoveryQue + "  "+recoveryAns);
		if (password != rePassword) {

			document.getElementById('lbl').innerHTML = 'Password Mismatch!!';
			return (false);
		}

		if (recoveryQue != "Select") {} 
		else {
			document.getElementById('lbl').innerHTML = 'Select Security Question!!';
			return (false);
		}

	}
	
	function getSecurityQue() {	
		$.get('ProcessData', {  
	    	 load : "recoveryQue"
	     }, function(response) {
	     var select = $('#recoveryQue');
	       $.each(response, function(index, value) {
	                $("#recoveryQue").append("<option value='"+index+"'>"+value+"</option>");
	    	 });
	     });
		
	}
	
</script>
</head>
<body onload="getSecurityQue()">
	<div class="regForm">

		<form role="form1" name="form1" action="Registration" method="post">

			<div style="background: #0361A8; padding: 15px;">
				<span
					style="font-family: verdana, arial; color: #D4D4D4; font-size: 1.00em; font-weight: bold;">Registration.
					Please fill in the form below.</span>
			</div>




			<table style="padding: 15px; width: 712px">
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName" placeholder="username"
						required></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"
						placeholder="First name" required></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName" placeholder="Last Name"
						required></td>
				</tr>
				<tr>
					<td>Email ID:</td>
					<td><input type="text" name="email" placeholder="E-Mail ID"
						required></td>
				</tr>
				<tr>
					<td>Choose Password:</td>
					<td><input type="password" name="password"
						placeholder="Password" required></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" id="rePassword" name="rePassword"
						placeholder="Retype Password" required></td>
				</tr>
				<tr>
					<td>Security Question :</td>
					<td><select name="recoveryQue" id="recoveryQue" required>
							<option selected disabled>Select</option>
					</select></td>
				</tr>
				<tr>
					<td>Security Answer :</td>
					<td><input type="text" id="recoveryAns" name="recoveryAns"
						placeholder="Security Answer" required></td>
				</tr>
				<tr>
					<td colspan="2"><div class="clear">
							<%
						String msg = "";
						if (request.getAttribute("msg") != null) {
							msg = request.getAttribute("msg")+"";
					%>
							<h3 style="margin-left: 20%; color: red"><%=msg%></h3>
							<%
						}
					%>
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><input size="30px" type="submit"
						onclick="return myFunction(this);" value="Sign Up"></td>
				</tr>
				<tr>
					<td colspan="2"><label id="lbl" style="color: red"> </label></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>