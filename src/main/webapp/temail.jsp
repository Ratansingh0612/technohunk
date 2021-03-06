<!DOCTYPE html>
<html lang="en">
<head>
<title>${companyName}| Exam Detail Summary</title>
<meta charset="utf-8">
<style>
<!--
input[type="checkbox"] {
	-webkit-appearance: checkbox;
}

input[type="radio"] {
	-webkit-appearance: radio;
}

input[type="submit"], input[type="button"] {
	-webkit-appearance: button;
}

select {
	-webkit-appearance: textfield;
}

-->
.container {
	width: 75%;
	font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode',
		'Lucida Sans';
	font-size: 15px;
	font-style: normal;
	font-variant: normal;
	font-weight: 500;
	line-height: 26.4px;
}

table {
	border-collapse: collapse;
	width: 85%;
}

table, th, td {
	border: 1px solid black;
}
</style>
</head>

<body id="page-top">

	<!-- PAGE WRAP -->
	<div id="page-wrap">

		<!-- PRELOADER -->
		<div id="preloader">
			<div class="pre-icon">
				<div class="pre-item pre-item-1"></div>
				<div class="pre-item pre-item-2"></div>
				<div class="pre-item pre-item-3"></div>
				<div class="pre-item pre-item-4"></div>
			</div>
		</div>
		<!-- END / PRELOADER -->


		<!-- END / CONTENT BAR -->
		<!-- COURSE CONCERN -->
	<b style="background-color: #e0d4d4;">Below is your test summary  of  online test:-</b><br/>
<hr/>
<img src="cid:cimage" style="height: 100px;"/>
<p style="width: 85%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
  Name : $userOnlineExamStatus.name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Userid : $userOnlineExamStatus.userId &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tech Name : $userOnlineExamStatus.techName &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Test Name : $userOnlineExamStatus.testName &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Test Duration : NA minutes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>
 <table border="1" style="width:85%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
		<tr style="background-color: #1e2a7b;color:white;">
			<td>&nbsp;Questions Attempted</td>
					<td>&nbsp;Correct Questions</td>
					<td>&nbsp;Wrong Questions</td>
					<td>&nbsp;Not Attempted Questions</td>
					<td>&nbsp;Total Questions</td>
				<td>&nbsp;Scored%</td>
					<td>&nbsp;Status%</td>
		</tr>
		<tr>
		<td>&nbsp;$userOnlineExamStatus.totalNoAnsweredQuestion</td>
					<td align="center">&nbsp;$userOnlineExamStatus.totalCorrectAnswer</td>
					<td>&nbsp;$userOnlineExamStatus.totalWrongAnswer</td>
					<td>&nbsp;$userOnlineExamStatus.totalNoQuestion</td>
					<td>&nbsp;$userOnlineExamStatus.totalMarks</td>
				<td>&nbsp;$userOnlineExamStatus.secureMarks %</td>
					<td>&nbsp;$userOnlineExamStatus.examStatus</td>
		</tr>
		<tr>
		<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td colspan="7" style="background-color: #a1ff9a;color:white;">&nbsp;</td>
		</tr>
</table> 
			
			<div class="container">
				<hr style="width: 85%;" align="left"/>

		<table>
					
					#foreach( $question in $questionList )
							<tr>
								<td colspan=3 height="30" style="color: black; font-size: 16px;">
									<span id="questionTextId" style="color: black;"><b>$foreach.count
											.</b>&nbsp;<img 	src="cid:image2" />$question.questionText</span>
								</td>
							</tr>
							<tr>
								<td bgcolor="white" width=2%>A.</td>
								<td colspan="2" bordercolor="black"
									#if ($question.selectedOption == $question.answerId1 && $question.correctOption == $question.answerId1)
									style="background-color:#0ef37a"   
						          #end
									#if ($question.selectedOption == $question.answerId1 && $question.correctOption != $question.answerId1)
									style="background-color:#fd7878"
							       #end
								  #if ($question.correctOption == $question.answerId1)
											style="background-color:#0ef37a;"
									#end>
									<input type="radio" id="selectedAnswerId1" disabled="disabled"
									name="$question.questionId" value="$question.answerId1"		
									   #if ($question.selectedOption == $question.answerId1) 
									   checked
									   #end	/>
									$question.answerText1 
									   #if($question.correctOption == $question.answerId1)
									     #set ($correct = $question.answerText1)
									    #set ($tcorrectOption = "Option - (A)")
									#end
								</td>
							</tr>

						<tr>
								<td bgcolor="white" width=2%>B.</td>
								<td colspan="2" bordercolor="black"
									#if ($question.selectedOption == $question.answerId2 && $question.correctOption == $question.answerId2)
									style="background-color:#0ef37a"   
						          #end
									#if ($question.selectedOption == $question.answerId2 && $question.correctOption != $question.answerId2)
									style="background-color:#fd7878"
							       #end
								  #if ($question.correctOption == $question.answerId2)
											style="background-color:#0ef37a;"
									#end>
									<input type="radio" id="selectedAnswerId2" disabled="disabled"
									name="$question.questionId" value="$question.answerId2"		
									   #if ($question.selectedOption == $question.answerId2) 
									   checked
									   #end	/>
									$question.answerText2 
									   #if($question.correctOption == $question.answerId2)
									     #set ($correct = $question.answerText2)
									    #set ($tcorrectOption = "Option - (B)")
									#end
								</td>
							</tr>

							   #if( $question.noOfOptions >2 )
									<tr>
								<td bgcolor="white" width=2%>C.</td>
								<td colspan="2" bordercolor="black"
									#if ($question.selectedOption == $question.answerId3 && $question.correctOption == $question.answerId3)
									style="background-color:#0ef37a"   
						          #end
									#if ($question.selectedOption == $question.answerId3 && $question.correctOption != $question.answerId3)
									style="background-color:#fd7878"
							       #end
								  #if ($question.correctOption == $question.answerId3)
											style="background-color:#0ef37a;"
									#end>
									<input type="radio" id="selectedAnswerId3" disabled="disabled"
									name="$question.questionId" value="$question.answerId3"		
									   #if ($question.selectedOption == $question.answerId3) 
									   checked
									   #end	/>
									$question.answerText3 
									   #if($question.correctOption == $question.answerId3)
									     #set ($correct = $question.answerText3)
									    #set ($tcorrectOption = "Option - (C)")
									#end
								</td>
							</tr>
							#end

				   #if( $question.noOfOptions >3 )
								<tr>
								<td bgcolor="white" width=2%>D.</td>
								<td colspan="2" bordercolor="black"
									#if ($question.selectedOption == $question.answerId4 && $question.correctOption == $question.answerId4)
									style="background-color:#0ef37a"   
						          #end
									#if ($question.selectedOption == $question.answerId4 && $question.correctOption != $question.answerId4)
									style="background-color:#fd7878"
							       #end
								  #if ($question.correctOption == $question.answerId4)
											style="background-color:#0ef37a;"
									#end>
									<input type="radio" id="selectedAnswerId4" disabled="disabled"
									name="$question.questionId" value="$question.answerId4"		
									   #if ($question.selectedOption == $question.answerId4) 
									   checked
									   #end	/>
									$question.answerText4 
									   #if($question.correctOption == $question.answerId4)
									     #set ($correct = $question.answerText4)
									    #set ($tcorrectOption = "Option - (D)")
									#end
								</td>
							</tr>
								#end

						   #if( $question.noOfOptions >4 )
									<tr>
								<td bgcolor="white" width=2%>E.</td>
								<td colspan="2" bordercolor="black"
									#if ($question.selectedOption == $question.answerId5 && $question.correctOption == $question.answerId5)
									style="background-color:#0ef37a"   
						          #end
									#if ($question.selectedOption == $question.answerId5 && $question.correctOption != $question.answerId5)
									style="background-color:#fd7878"
							       #end
								  #if ($question.correctOption == $question.answerId5)
											style="background-color:#0ef37a;"
									#end>
									<input type="radio" id="selectedAnswerId5" disabled="disabled"
									name="$question.questionId" value="$question.answerId5"		
									   #if ($question.selectedOption == $question.answerId5) 
									   checked
									   #end	/>
									$question.answerText5
									   #if($question.correctOption == $question.answerId5)
									     #set ($correct = $question.answerText5)
									    #set ($tcorrectOption = "Option - (E)")
									#end
								</td>
							</tr>
						#end

				  #if( $question.noOfOptions >5 )
								<tr>
								<td bgcolor="white" width=2%>F.</td>
								<td colspan="2" bordercolor="black"
									#if ($question.selectedOption == $question.answerId6 && $question.correctOption == $question.answerId6)
									style="background-color:#0ef37a"   
						          #end
									#if ($question.selectedOption == $question.answerId6 && $question.correctOption != $question.answerId6)
									style="background-color:#fd7878"
							       #end>
								  #if ($question.correctOption == $question.answerId6)
											style="background-color:#0ef37a;"
									#end>
									<input type="radio" id="selectedAnswerId6" disabled="disabled"
									name="$question.questionId" value="$question.answerId6"		
									   #if ($question.selectedOption == $question.answerId6) 
									   checked
									   #end	/>
									$question.answerText6
									   #if($question.correctOption == $question.answerId6)
									     #set ($correct = $question.answerText6)
									    #set ($tcorrectOption = "Option - (F)")
									#end
								</td>
							</tr>
							#end
							
				  #if( $question.noOfOptions >6 )
							<tr>
								<td bgcolor="white" width=2%>G.</td>
								<td colspan="2" bordercolor="black"
									#if ($question.selectedOption == $question.answerId7 && $question.correctOption == $question.answerId7)
									style="background-color:#0ef37a"   
						          #end
									#if ($question.selectedOption == $question.answerId7 && $question.correctOption != $question.answerId7)
									style="background-color:#fd7878"
							       #end
								  #if ($question.correctOption == $question.answerId7)
											style="background-color:#0ef37a;"
									#end>
									<input type="radio" id="selectedAnswerId7" disabled="disabled"
									name="$question.questionId" value="$question.answerId7"		
									   #if ($question.selectedOption == $question.answerId7) 
									   checked
									   #end	/>
									$question.answerText7
									   #if($question.correctOption == $question.answerId7)
									     #set ($correct = $question.answerText7)
									    #set ($tcorrectOption = "Option - (G)")
									#end
								</td>
							</tr>
								#end
							<tr>
								<td bgcolor="" colspan="3">
								<img		src="cid:image3"	height="30px;display:inline;"/>
								 <span id="ans"
									style="color: black; background-color: #DBEAF9">$tcorrectOption
										= <span style="background-color: #0ef37a;">$correct</span>
								</span></td>
							</tr>

							<tr style="background-color: white;">
								<td colspan="3">=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
						#end
					</table>
			</div>
	</div>

</body>

</html>