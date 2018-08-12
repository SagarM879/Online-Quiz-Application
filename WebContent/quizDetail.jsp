<%@page import="com.onlinequiz.controller.CreateQuiz"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>


	<h1><%=request.getParameter("quiz")%>
		Quiz
	</h1>
	<div>

		<form name="form1" id="form1" action="quiz.jsp">

			<table id="quizInfo" style="padding: 15px; width: 712px">

			</table>
			<input type="hidden" id="quizName" name="quizName"
				value="<%=request.getParameter("quiz")%>"> <input
				type="hidden" id="quizID" name="quizID"
				value="<%=request.getParameter("quizID")%>"> <input
				type="hidden" id="noOfQue" name="noOfQue"
				value="<%=request.getParameter("noOfQue")%>">
		</form>
	</div>
	<script type="text/javascript">
		var param = $("#quizName").val();

		$
				.get(
						'ProcessData',
						{
							quiz : param,
							load : 'quizDetail'
						},
						function(response) {
							var select = $('#quizInfo');
							$.each(response, function(index, value) {
								$('#quizInfo').append(
										"<tr><td>" + index + "</td><td>"
												+ value + "</td></tr>");
							});
							var noOfQue = $(
									'#quizInfo tr:nth-child(3) td:nth-child(2)')
									.text();
							$('#noOfQue').val(noOfQue);
							//alert("no "+noOfQue);

							$('#quizInfo')
									.append(
											"<td colspan='2'><input style='margin-left: 25%;' size='30px' type='submit' value='Start Quiz'></td>");
						});
	</script>

</body>

</html>