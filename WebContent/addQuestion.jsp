
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.10.2.js"></script>
<title>Online Quiz- Add Question</title>
<script type="text/javascript">
	function myFunction() {
	}
	function getQuizName() {
		var param = "quizList";
		$.get('ProcessData', {
			load : param
		}, function(response) {
			var select = $('#quizName');
			$.each(response, function(index, value) {
				$("#quizName").append(
						"<option value='"+index+"'>" + value + "</option>");
			});
		});
	}
</script>
</head>
<body onload="getQuizName()">
	<div class="addQueForm">
		<div class="head">
			<font color="Coral" size="5" face="verdana">Add Question</font>
		</div>
		<form name="form1" class="form1" action="AddQuestion" method="post">
			<table style="padding: 15px; width: 712px">
				<tr>
					<td>Quiz Name:</td>
					<td><select id="quizName" name="quizName" required>
							<option selected disabled>Select</option>
					</select></td>
				</tr>
				<tr>
					<td>Question :</td>
					<td><textarea id="question" name="question" rows="5" cols="52"
							required>
					</textarea></td>
				</tr>
				<tr>
					<td>Correct Answer :</td>
					<td><select id="correctAns" name="correctAns" required>
							<option selected disabled>Select</option>
							<option>A</option>
							<option>B</option>
							<option>C</option>
							<option>D</option>
					</select></td>
				</tr>
				<tr>
					<td>Option A :</td>
					<td><textarea rows="2" cols="52" id="optionA" name="optionA"
							required>
					</textarea></td>
				</tr>
				<tr>
					<td>Option B :</td>
					<td><textarea rows="2" cols="52" id="optionB" name="optionB"
							required>
					</textarea></td>
				</tr>
				<tr>
					<td>Option C :</td>
					<td><textarea rows="2" cols="52" id="optionC" name="optionC"
							required>
					</textarea></td>
				</tr>
				<tr>
					<td>Option D :</td>
					<td><textarea rows="2" cols="52" id="optionD" name="optionD"
							required>
					</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input size="20px" type="submit"
						onclick="return myFunction(this)" value="Create"></td>
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