<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- Google font -->
<%@include file="/resources.jsp"%>
<title>${companyName} - User Test History</title>
</head>
<script>
	function viewGraph() {
		$('.column').css('height', '0');
		$('table tr').each(function(index) {
			var ha = $(this).children('td').eq(1).text();
			var text = $(this).children('td').eq(0).text();
			$('#col' + index).animate({
				height : ha
			}, 3000).html("<div>" + text + "</div>");
		});
		$("#tempTable").hide();
	}
</script>
<style>
	#contenitore{
	position: relative;
	width: 1200px;
	margin: 20px auto;
	text-align:center;
	overflow:hidden;
	font: 14px 'Trebuchet MS', sans serif;
	}
	.left{
	float:left;
	width:70%;
	}
	.lefttable{
	float:left;
	width:30%;
	}
	#grafico{
	position:relative;
	height:300px;
	border-left:2px solid cornflowerblue;
	border-bottom: 2px solid cornflowerblue;
	width:100%;
	margin-top:20px;
	}
	.riga{
	position: absolute;
    left: 0;
    height: 1px;
    width: 100%;
    background-color: #f5f5f5;
    border-bottom-style: dotted;
    border-bottom-color: burlywood;	}
	.riga div{
	float:left;
	margin: -8px 0 0 -40px;
	}
	.canc{
	clear:both;
	}


	.column{
	position:absolute;
	width: 5%;
	bottom: 0;
	background-color: #003366;
	margin-left:5%;
	opacity: 1;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    box-shadow: 20px 10px 10px slategrey;
	}
	div.button {
		margin: 0 auto;
		text-align: center;
		width: 100px;
		background-color:#003366;
		border: 1px solid #003366;
		border-radius: 5px;
		padding: 8px;
		color: #E1E2CF;
		cursor: pointer;
	}
	.column div{
	margin-top:-20px;
	height:20px;
	}
</style>

<body id="page-top" onload="viewGraph();">

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

		<!-- HEADER -->
		<k:if test="${sessionScope.user_session_data.role=='trainer'}">
			<%@include file="/theader.jsp"%>
		</k:if>
		
			<!-- HEADER -->
		<k:if test="${sessionScope.user_session_data.role=='admin'}">
			<%@include file="/aheader.jsp"%>
		</k:if>
		<k:if test="${sessionScope.user_session_data.role=='consultant'}">
			<%@include file="/uheader.jsp"%>
		</k:if>

		<k:if test="${sessionScope.user_session_data.role=='user'}">
			<%@include file="/uheader.jsp"%>
		</k:if>
		<!-- END / HEADER -->


		<!-- PROFILE FEATURE -->
		<%@include file="profile-feature.jsp"%>
		<!-- END / PROFILE FEATURE -->


		<!-- CONTEN BAR -->
		<%@include file="content-bar.jsp"%>
		<!-- END / CONTENT BAR -->

		<!-- COURSE CONCERN -->
		<!--   <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
   -->
		<section
			style="padding-top: 0px; padding-bottom: 10px; background-color: white; min-height: 580px;"
			id="quizz-intro-section">
			<div class="container">

				<div class="title-ct">

					&nbsp;&nbsp;
					<h5 style="color: black">
						<img
							src="${pageContext.request.contextPath}/images/document-paper-64.png"
							width="25px;" height="25px;" /> - <span>Online Test
							History</span>
					</h5>
					<br />
				</div>
				<div id="contenitore">
					<div class="lefttable">
						<table id="tempTable">
							<caption>Score table</caption>
							<thead>
								<tr style="background-color: #607D8B;">
									<th class="submissions"
										style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Test
										Name</th>
									<th class="author"
										style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Score</th>
									<th class="author"
										style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;"></th>
							</thead>
							<tbody>
							
<k:forEach var="userOnlineExamStatus"
								items="${userOnlineExamStatusList}" varStatus="pk">
								<tr class="new">
									<td>${userOnlineExamStatus.testName}</td>
								<td><fmt:formatNumber
												type="number" minFractionDigits="2" maxFractionDigits="2"
												value="${(userOnlineExamStatus.secureMarks/userOnlineExamStatus.totalMarks)*100}" />%</td>
									<td style="background-color:hsl(${25+pk.count*40}, 100%, 50%); ">&nbsp;</td>
								</tr>
</k:forEach>
							</tbody>
						</table>
						
					</div>
					<div class="left" style="margin-left: 200px;">
						<div id="grafico">
							<div class="riga" style="top: 0%">
								<div>100%</div>
							</div>
							<div class="riga" style="top: 25%">
								<div>75%</div>
							</div>
							<div class="riga" style="top: 50%">
								<div>50%</div>
							</div>
							<div class="riga" style="top: 75%">
								<div>25%</div>
							</div>
							<k:forEach var="userOnlineExamStatus"
								items="${userOnlineExamStatusList}" varStatus="pk">
							<div id="col${pk.count}" style="left:${pk.count*10-10}%; background-color:hsl(${200+pk.count*40}, 90%, 70%);"
								class="column"></div></k:forEach>
							
					</div>
					
				</div>
				</div>



				<div class="table-student-submission">


					<k:if test="${consultantsVO.name!=null}">	
               Consultant Id : ${consultantsVO.empid}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name : ${consultantsVO.name}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Stream : ${consultantsVO.stream}   
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Batch : ${consultantsVO.batch}
              
               <hr />
					</k:if>
					
					<span>${ApplicationMessage}</span>
					<div style="float: right;">
						<img src="${pageContext.request.contextPath}/images/favicon.ico"
							height="30px"
							style="font-family: 'Lato', sans-serif; font-size: 14px;" />
						Total Test History(s) : <b><span id="len">${fn:length(userOnlineExamStatusList)}</span></b>
					</div>
					<table class="table table-bordered">
						<thead>
							<tr style="background-color: #607D8B;">
								<th class="submissions"
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">SNo</th>
								<th class="author"
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Tech
									Name</th>
								<th class="author"
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Test
									Name</th>
								<th class="author"
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Secure
									Marks</th>
								<th class="score"
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Total
									Marks</th>
								<th class="submit-date"
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Questions
								</th>
								<th
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Correct</th>
								<th
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Wrong</th>
								<th
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Mark%</th>
								<th
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Date</th>
								<th
									style="color: white; font-family: 'Lato', sans-serif; font-size: 14px;">Action</th>
									
									
							</tr>
						</thead>

						<tbody>
							<k:forEach var="userOnlineExamStatus"
								items="${userOnlineExamStatusList}" varStatus="pk">
								<tr class="new">
									<td class="submissions">${pk.count}</td>
									<td>${userOnlineExamStatus.techName}</td>
									<td>
									<k:if test="${sessionScope.user_session_data.role=='consultant'}">
										<a href="${pageContext.request.contextPath}/action/user-test-summary?userSessionId=${userOnlineExamStatus.userSessionId}">
									</k:if>
											${userOnlineExamStatus.testName}
									<k:if test="${sessionScope.user_session_data.role=='consultant'}">
									</a>
									</k:if>
									</td>
									<td>${userOnlineExamStatus.secureMarks}</td>
									<td>${userOnlineExamStatus.totalMarks}</td>
									<td>${userOnlineExamStatus.totalNoQuestion}</td>
									<td>${userOnlineExamStatus.totalCorrectAnswer}</td>
									<td>${userOnlineExamStatus.totalWrongAnswer}</td>


									<td><font style="color: blue;"> <fmt:formatNumber
												type="number" minFractionDigits="2" maxFractionDigits="2"
												value="${(userOnlineExamStatus.secureMarks/userOnlineExamStatus.totalMarks)*100}" />
									</font></td>
									<td bgcolor="white">${userOnlineExamStatus.dateOfTest}</td>
									<td bgcolor="white"><k:if
											test="${sessionScope.user_session_data.role=='trainer'  || sessionScope.user_session_data.role=='admin'}">
											<a
												href="${pageContext.request.contextPath}/action/consultant-exam-detail?testName=${userOnlineExamStatus.testName}&techName=${userOnlineExamStatus.techName}&userSessionId=${userOnlineExamStatus.userSessionId}&consultantId=${consultantsVO.userid}"><font
												color="#000000">Detail<img
													src="${pageContext.request.contextPath}/images/ddetails.png"
													style="height: 20px;" /></font></a>
													<a href="javascript:resetConsultantCompleteTest('${userOnlineExamStatus.techName}','${userOnlineExamStatus.testName}','${userOnlineExamStatus.userId}','${userOnlineExamStatus.userSessionId}');"><img src="${pageContext.request.contextPath}/images/icon/reset-test.png" style="height: 38px;"/></a>										
										</k:if> 
										
										<k:if test="${sessionScope.user_session_data.role=='user'}">
											<a
												href="${pageContext.request.contextPath}/action/examDetail?testName=${userOnlineExamStatus.testName}&techName=${userOnlineExamStatus.techName}&userSessionId=${userOnlineExamStatus.userSessionId}"><font
												color="#000000">Detail<img
													src="${pageContext.request.contextPath}/images/ddetails.png"
													style="height: 20px;" /></font></a>

										</k:if> 
										<k:if
											test="${sessionScope.user_session_data.role=='consultant'}">
											<a
												href="${pageContext.request.contextPath}/action/examDetail?testName=${userOnlineExamStatus.testName}&techName=${userOnlineExamStatus.techName}&userSessionId=${userOnlineExamStatus.userSessionId}"><font
												color="#000000">Detail<img
													src="${pageContext.request.contextPath}/images/ddetails.png"
													style="height: 20px;" /></font></a>

										</k:if></td>
								</tr>
							</k:forEach>

							<tr style="height: 35px;">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr style="height: 35px;">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						


						</tbody>
					</table>
					<k:if	test="${sessionScope.user_session_data.role!='consultant'}">
							<img src="${pageContext.request.contextPath}/images/icon/reset-test.png" style="height: 38px;"/>
							<span style="background-color: #a0ffff;">Click on this icon to reset the complete test.</span>
					</k:if>
				</div>


			</div>
		</section>

		<!-- END / COURSE CONCERN -->


		<!-- FOOTER -->
		<footer id="footer" class="footer">
			<%--   <%@include file="/ffooter.jsp" %> --%>
			<%@include file="/sfooter.jsp"%>
		</footer>
		<!-- END / FOOTER -->



	</div>
	<!-- END / PAGE WRAP -->

	<!-- Load jQuery -->
	<!-- Load jQuery -->
	<%@include file="/js.jsp"%>

	<script type="text/javascript">
	
	function resetConsultantCompleteTest(techName,testName,consultantid,userSessionId) {
		     var yesno=confirm("Are you sure want to reset this test (Y/N)?");
		     if(yesno)  {
		    	   $("#testName").val(testName);
		    	   $("#techName").val(techName);
		    	   $("#consultantid").val(consultantid);
		    	   $("#userSessionId").val(userSessionId);
		    	   $("#resetConsultantTestForm").submit();
		     }
	}
	
		$.each($('.table-wrap'), function() {
			$(this).find('.table-item').children('.thead:not(.active)').next(
					'.tbody').hide();
			$(this).find('.table-item').delegate(
					'.thead',
					'click',
					function(evt) {
						evt.preventDefault();
						if ($(this).hasClass('active') == false) {
							$('.table-item').find('.thead').removeClass(
									'active').siblings('.tbody').slideUp(200);
						}
						$(this).toggleClass('active').siblings('.tbody')
								.slideToggle(200);
					});
		});
	</script>
	 <form id="resetConsultantTestForm" method="POST" action="${pageContext.request.contextPath}/action/reset-consultant-test">
	 			<input type="hidden" name="testName" id="testName"/>
	 			<input type="hidden" name="techName" id="techName"/>
	 			<input type="hidden" name="consultantid" id="consultantid"/>
	 			<input type="hidden" name="withHistory" id="withHistory" value="yes"/>
	 			<input type="hidden" name="userSessionId" id="userSessionId"/>
	 </form>
</body>

</html>