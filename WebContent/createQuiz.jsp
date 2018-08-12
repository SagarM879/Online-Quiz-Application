<!DOCTYPE html>
<html>

<head>
<title>Online Quiz - Create Quiz</title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	var redioButtonStatus = null;

	function chkIsTimed() {
		redioButtonStatus = document.form1.isTimed.value;
		//alert(redioButtonStatus);
		if (document.form1.isTimed.value == "No") {

			document.form1.quizTime.disabled = true;
			//alert("Disabled "+redioButtonStatus);

		} else {
			document.form1.quizTime.disabled = false;
			//alert("Enabled "+redioButtonStatus);
		}
	}

	function myFunction() {

	}
</script>

</head>
<body>
	<!-----start-main---->
	<div class="createQuizForm">
		<div class="head">
			<font color="Coral" size="5" face="verdana">Create Quiz</font>
		</div>
		<form name="form1" class="form1" action="CreateQuiz" method="post">
			<table style="padding: 15px; width: 712px">
				<tr>
					<td>Quiz Name:</td>
					<td><input type="text" class="text" name="quizName"
						placeholder="quizName" required></td>
				</tr>
				<tr>
					<td>No. Of Question:</td>
					<td><input type="text" id="noOfQue" name="noOfQue"
						placeholder="No Of Que" required></td>
				</tr>
				<tr>
					<td>Is Timed?:</td>
					<td onclick="chkIsTimed(this)">YES <input type="radio"
						id="ryes" value="Yes" name="isTimed" checked> NO <input
						type="radio" id="rno" value="No" name="isTimed"></td>
				</tr>
				<tr>
					<td>Quiz Time:</td>
					<td><input id="quizTime" type="text" name="quizTime"
						placeholder="quiztime"></td>
				</tr>
				<tr>
					<td colspan="2"><input size="20px" type="submit"
						onclick="return myFunction(this);" value="Create"></td>
				</tr>
				<tr>
					<td colspan="2"><label id="lbl" style="color: red"> </label></td>
				</tr>
			</table>
		</form>
	</div>
	<!--//End-login-form-->
	<!-----start-copyright---->
	<div class="copy-right"></div>
	<!-----//end-copyright---->

</body>
</html>