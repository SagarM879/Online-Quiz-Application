<%@page import="com.onlinequiz.controller.ProcessData"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz</title>

<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.10.2.js"></script>
<script type="text/javascript">
	function previous() {
		var param = $('#questionID').val();
		var selectedAns = $("input[name='options']:checked").val();

		if (param > 2) {
		} else {
			//alert("In Else Part");
			$('#prev').prop("disabled", true);
		}

		$('#finish').hide();
		$('#next').show();
		//alert("Ajax called" + selectedAns);
		$
				.get(
						'StartQuiz',
						{
							queID : param,
							load : 'prev',
							selectedAns : selectedAns

						},
						function(response) {
							//alert("Response");
							var data = {
								"questionID" : 0,
								"quizID " : 0,
								"question" : "",
								"correctAns" : "",
								"optionA" : "",
								"optionB" : "",
								"optionC" : "",
								"optionD" : "",
								"SelectedAns" : ""
							};

							$
									.each(
											response,
											function(index, data) {
												$('#question').html('');
												$('#question')
														.append(
																"<input type='hidden' id='questionID' value='" + index + "'><label>"
																		+ index
																		+ " . </label><span id='queName'>"
																		+ data.question
																		+ "</span><br>");
												$('#options').html('');
												$('#options')
														.append(
																"<input type='hidden' id='correctAns' value='" + data.correctAns + "'><input type='radio' id='optionA' value='A' name='options'> A . "
																		+ data.optionA
																		+ "<br><input type='radio' value='B' id='optionB' name='options'> B . "
																		+ data.optionB
																		+ "<br><input type='radio' value='C' id='optionC' name='options'> C . "
																		+ data.optionC
																		+ "<br><input type='radio' value='D' id='optionD' name='options'> D . "
																		+ data.optionD
																		+ "");
												$(
														"input[name='options'][id='option"
																+ data.selectedAns
																+ "']").prop(
														'checked', true);
											});
						});

	}
	function next() {
		//alert("Ajax called"+param1);
		var param = $('#questionID').val();
		var noOfQue = $('#noOfQue').val() - 1;
		if (param == 2) {
			$('#next').hide();
			$('#finish').show();
		}
		$('#prev').prop("disabled", false);
		var selectedAns = $("input[name='options']:checked").val();
		//alert("Ajax called Next : " + selectedAns);
		$
				.get(
						'StartQuiz',
						{
							queID : param,
							load : 'next',
							selectedAns : selectedAns

						},
						function(response) {
							//alert("Response");
							var data = {
								"questionID" : 0,
								"quizID " : 0,
								"question" : "",
								"correctAns" : "",
								"optionA" : "",
								"optionB" : "",
								"optionC" : "",
								"optionD" : "",
								"SelectedAns" : ""
							};

							$
									.each(
											response,
											function(index, data) {
												$('#question').html('');
												$('#question')
														.append(
																"<input type='hidden' id='questionID' value='" + index + "'><label>"
																		+ index
																		+ " . </label><span id='queName'>"
																		+ data.question
																		+ "</span><br>");
												$('#options').html('');
												$('#options')
														.append(
																"<input type='hidden' id='correctAns' value='" + data.correctAns + "'><input type='radio' id='optionA' value='A' name='options'> A . "
																		+ data.optionA
																		+ "<br><input type='radio' value='B' id='optionB' name='options'> B . "
																		+ data.optionB
																		+ "<br><input type='radio' value='C' id='optionC' name='options'> C . "
																		+ data.optionC
																		+ "<br><input type='radio' value='D' id='optionD' name='options'> D . "
																		+ data.optionD
																		+ "");
												$(
														"input[name='options'][id='option"
																+ data.selectedAns
																+ "']").prop(
														'checked', true);
											});
						});

	}
	function finish() {
		//alert("Finish called");
		var param = $('#questionID').val();
		var noOfQ = $('#noOfQue').val();
		clearInterval(1);
		var selectedAns = $("input[name='options']:checked").val();
		//alert("Ajax called Finish : " + selectedAns);
		$.get('StartQuiz', {
			queID : param,
			load : 'next',
			selectedAns : selectedAns

		}, function(response) {
			//alert("Response");
			submitQuiz();
			return true;
		});
	}
	function submitQuiz() {
		//alert("SubmitQuiz called");
		var param = $('#quizName').val();

		$.get('SubmitQuiz', {
			quizName : param,
			param : "submitQuiz",
			noOfQue : $('#noOfQue').val()

		}, function(response) {

			$("#quiz").html('');
			//alert("Response");
			$("#quiz").append("");
			$("#quiz").append(response);
			return true;
		});
		eMailResult();
	}

	function eMailResult() {
		alert("eMailResult called");

		$.get('SubmitQuiz', {
			param : "eMailResult"

		}, function(response) {

			$("#quiz").html('');
			//alert("Response");
			$("#quiz").append("");
			$("#quiz").append(response);
			return true;
		});
	}
</script>
</head>
<body>
	<font face="KG Ten Thousand Reasons" color="white" size="5">
		<div id="quiz" class="quizPage">
			<div id="quizTimer" style="min-height: 85px">
				<br> <label id="quizTimerL"></label>
			</div>
			<div id="queInfo">
				<input type="hidden" id="quizName" name="quizName"
					value="<%=request.getParameter("quizName")%>"> <input
					type="hidden" id="quizID" name="quizID"
					value="<%=request.getParameter("quizID")%>"> <span
					id="queID"></span> <font size="5">
					<div id='question' style="max-width: 900px;"></div>
				</font> <font size="4">
					<div id="options"></div>
				</font>
			</div>
			<div style="margin-left: 40px;" id="navigation">
				<input type="button" style="margin-left: 2%;" id="prev" name="prev"
					value="Previous" onclick="previous()"> <input type="button"
					id="next" name="next" value="Next" style="margin-left: 17%;"
					onclick="next()"> <input type="submit"
					style="margin-left: 17%;" id="finish" name="finish" value="Finish"
					onclick="return finish()">

			</div>
			<input type="hidden" id="isTimed" name="isTimed"
				value='<%=session.getAttribute("isTimed")%>'> <input
				type="hidden" id="quizTime" name="quizTime"
				value='<%=session.getAttribute("quizTime")%>'>
				
				<input type="hidden" id="noOfQue" name="noOfQue"
				value="<%=request.getParameter("noOfQue")%>">
			<script type="text/javascript">
				var quizID = $('#quizID').val();
				var quizName = $('#quizName').val();
				$('#finish').hide();
				//alert("Ajax called");
				$('#prev').prop("disabled", true);
				$
						.get(
								'StartQuiz',
								{
									quizName : quizName,
									quiz : quizID,
									load : 'start'
								},
								function(response) {
									//alert("Response");
									var data = {
										"questionID" : 0,
										"quizID " : 0,
										"question" : "",
										"correctAns" : "",
										"optionA" : "",
										"optionB" : "",
										"optionC" : "",
										"optionD" : ""
									};

									$
											.each(
													response,
													function(index, data) {
														$('#question').html('');
														$('#question')
																.append(
																		"<input type='hidden' id='questionID' value='" + index + "'><label>"
																				+ index
																				+ " . </label><span id='queName'>"
																				+ data.question
																				+ "</span><br>");
														$('#options').html('');
														$('#options')
																.append(
																		"<input type='hidden' id='correctAns' value='" + data.correctAns + "'><input type='radio' id='optionA' value='A' name='options'> A . "
																				+ data.optionA
																				+ "<br><input type='radio' value='B' id='optionB' name='options'> B . "
																				+ data.optionB
																				+ "<br><input type='radio' value='C' id='optionC' name='options'> C . "
																				+ data.optionC
																				+ "<br><input type='radio' value='D' id='optionD' name='options'> D . "
																				+ data.optionD
																				+ "");
													});
									var isTimed = $('#isTimed').val();
									//alert("Quiz is Timed? : " + isTimed);
									if (isTimed == "true") {
										var quizTime = $('#quizTime').val();
										alert("Quiz is Timed? : " + quizTime);
										jQuery(function($) {
											var mins = 60 * quizTime, display = $('#quizTimerL');
											startTimer(mins, display);

										});
									}

								});

				function startTimer(duration, display) {

					var timer = duration, minutes, seconds;
					setInterval(function() {
						minutes = parseInt(timer / 60, 10);
						seconds = parseInt(timer % 60, 10);

						minutes = minutes < 10 ? "0" + minutes : minutes;
						seconds = seconds < 10 ? "0" + seconds : seconds;

						display.text("Time remaining - " + minutes + " : "
								+ seconds);

						if (timer > 0)
							--timer;
						if (timer <= 0) {
							finish();

						}
					}, 1000);

				}
			</script>
			
		</div>
	</font>
</body>

</html>