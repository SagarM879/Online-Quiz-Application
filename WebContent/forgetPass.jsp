<!DOCTYPE html>
<html>

<head>
<title>Online Quiz</title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="js/jquery-1.10.2.js"></script>
<script>
	function getSecurityQue() {
		$.get('ProcessData', {
			load : "recoveryQue"
		}, function(response) {
			var select = $('#recoveryQue');
			$.each(response, function(index, value) {
				$("#recoveryQue").append(
						"<option value='"+index+"'>" + value + "</option>");
			});
		});

	}
	
	function validation() {
		
		password = document.form1.password.value;
		rePassword = document.form1.rePassword.value;
		alert("Validation start");
		if (password != rePassword) {
			alert("Validation start");
			document.getElementById('lbl').innerHTML = 'Password Mismatch!!';
			return false;
		}
		return true;
	}
</script>
</head>
<body onload="getSecurityQue()">
	<!-----start-main---->
	<div class="regForm">
		<div class="head">
			<font color="Coral" size="5" face="verdana">Password Recovery Form</font>
		</div>
		<form name="form1" class="form1" action="PasswordRecovery" method="post">
			<table style="padding: 15px; width: 712px">
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName" placeholder="username"
						required></td>
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
					<td>New Password:</td>
					<td><input type="password" name="password"
						placeholder="Password" required></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input type="password" id="rePassword" name="rePassword"
						placeholder="Retype Password" required></td>
				</tr>
				<tr>
					<td colspan="2"><label id="lbl" style="color: red"> </label></td>
				</tr>
			</table>
			<div>
				<input type="submit" onclick="return validation()" value="Submit">
				<div class="clear">
					<%
						String msg = "";
						if (request.getAttribute("msg") != null) {
							msg = request.getAttribute("msg") + "";
					%>
					<h3 style="color: red"><%=msg%></h3>
					<%
						}
					%>
				</div>
			</div>

		</form>
	</div>
</body>
</html>