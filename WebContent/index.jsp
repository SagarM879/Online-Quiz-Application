
<!DOCTYPE html>
<html>

<head>
<title>Online Quiz</title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--webfonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700'
	rel='stylesheet' type='text/css'>
<!--//webfonts-->

</head>
<body>
	<!-----start-main---->
	<div class="loginForm">
		<div class="head">
			<font color="Coral" size="5" face="verdana">User Login</font>
		</div>
		<form class="form1" action="Login" method="post">
			<ul>
				<li><input type="text" class="text" name="username"
					placeholder="username" required>
				<a class=" icon user"></a></li>
				<li><input class="text" type="password" name="password"
					placeholder="Password" required>
				<a class=" icon lock"></a></li>
			</ul>
			<div>
				<label class="checkbox"><input type="checkbox"
					name="checkbox" checked><i></i>Remember Me</label> <input
					type="submit" value="Login">

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
			<div style="margin-top: 5%">
				<a href="forgetPass.jsp"><label>Forget Password</label></a><br> <a
					href="registration.jsp"><label>Register User</label></a>
			</div>
		</form>
	</div>
	<!--//End-login-form-->
</body>
</html>