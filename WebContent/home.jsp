
<!DOCTYPE html>
<html>

<head>
<title>Online Quiz-Home Page</title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />

<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<script src="js/jquery-1.10.2.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript">
	var path = null;

	function loadJsp(url) {
		$("#Home").load(url);
	}

	function loadQuizList() {
		var param = "quizList";
		$.get('ProcessData', {
			load : param
		}, function(response) {
			var select = $('#quizList');
			$.each(response, function(index, value) {
				$("#quizList").append(
						"<li><a onclick=loadJsp('quizDetail.jsp?quizID="
								+ index + "&quiz=" + value
								+ "') href='#Home' value='" + index
								+ "'><label>" + value + "</label></a></li>");
			});
		});

	}
</script>

</head>
<body style="background-color: gray" onload="loadQuizList()">
	<div class="header">
		<h1>Welcome to Online Quiz!</h1>
		<h3>
			Current User :
			<%=session.getAttribute("firstName")%>
			<%=session.getAttribute("lastName")%></h3>
			<div class="logout">
		<h1>
			<a href="Logout"><label>Logout</label></a>
		</h1></div>
	</div>
	<div class="home">
		<%
			String userName = (String) session.getAttribute("userName");
		System.out.println("Session Name is :"+userName);
			if (userName.equals("Admin")){		System.out.println("Session Name is :"+userName);%>
		<a style="font-size:20px;margin-left: 5%; color:white; background-color: blue;" href='createQuiz.jsp'><label>Add Quiz</label></a> <a
			style="font-size:20px;margin-left: 2%; color:white; background-color: blue;" href='addQuestion.jsp'><label>Add Question</label></a>
		<%
			}
		%>

		<div class="row">
			<div class="col-md-3"
				style="margin-left: 15px; min-height: 500px; border-top: 2px solid; border-right: 2px solid">
				Quiz List<br>
				<ul id="quizList">
				</ul>
			</div>
			<div id="Home" class="col-md-6">Select any Quiz from list</div>
		</div>
	</div>
	<div class="copy-right"></div>

</body>
</html>