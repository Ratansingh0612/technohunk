<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Edit Question & Answers</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js" charset="utf-8"></script>
	
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-te-1.4.0.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js"
	charset="utf-8"></script>

 <script type="text/javascript">
$(document).ready(function() {
	//alert("good morning!");
	$("#technology").change(function(){
		 $("#AppMessage").html("");
	});
	$("#qbankName").change(function(){
		 $("#AppMessage").html("");
	});
	 $("input[type='button'][id$='upload']").click(function() {
		 	var technology=$("#technology").val();
		     if("Select Technology"==technology) {
		    	 $("#AppMessage").html("Please select a technology for the question....");
		    	 window.scrollTo(500, 0);
		    	 return;
		     }
		     
		     var qbankName=$("#qbankName").val();
		     if("No"==qbankName) {
		    	 $("#AppMessage").html("No question bank exist for selected "+technology+" , please create \"question bank\" first.....");
		    	 window.scrollTo(500, 0);
		    	 return;
		     }
		     
		     //var qt=$('.jqte-test').val();
		    // alert("0202   = "+qt);
		     var questionText=$("#questionText").val();
		     if(0==questionText.trim().length) {
		    	 $("#AppMessage").html("Question description cannot be blank..");
		    	 $("#questionText").focus();
		    	 window.scrollTo(500, 0);
		    	 return;
		     }
		     
		     var answerText1=$("#answerText1").val();
		     if(0==answerText1.trim().length) {
		    	 $("#AppMessage").html("Question answer option \"A\" cannot be blank..");
		    	 $("#answerText1").focus();
		    	 window.scrollTo(500, 0);
		    	 return;
		     }
		     
		     var answerText2=$("#answerText2").val();
		     if(0==answerText2.trim().length) {
		    	 $("#AppMessage").html("Question answer option \"B\" cannot be blank..");
		    	 $("#answerText2").focus();
		    	 window.scrollTo(500, 0);
		    	 return;
		     }
		     
		     var questionText=$("#questionText").val();
		     if(0==questionText.trim().length) {
		    	 $("#AppMessage").html("Question description cannot be blank..");
		    	 $("#questionText").focus();
		    	 $('.jqte-test').focus();
		    	 window.scrollTo(500, 0);
		    	 return;
		     }
		     
			 if($("input[type='radio'][id^='correctId']").is(':checked')){
					$("#questionAndAnswersForm").submit();		 
			 }else{
				 $("#AppMessage").html("Please select a least one correct option!....");
		    	 window.scrollTo(500, 0);
		    	 return;
			 }
	 });
});
</script>
<style>
input[type=radio]{
  display:none;
}

input[type=radio] + label:before{
  content: '';
  display:inline-block;
  border-radius: 10px;
  width: 16px;
  height:16px;
  background:white;
  color:blue;
  border: 1px solid black;
  line-height: 15px;
  text-align: center;
  font-size:25px;
  margin-right: 5px;
}

input[type=radio]:checked + label:before{
  color: red;
   background:#37abf2;
}
</style>
</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
       
       <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="/theader.jsp"%>
      </k:if>
       <k:if test="${sessionScope.user_session_data.role=='admin'}">	
     				 <%@include file="/aheader.jsp"%>
      </k:if>
  </div>
</div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section">
        <div class="container">
          <img src="${pageContext.request.contextPath}/images/icon/bar2.png" style="width: 100%;height: 30px; opacity: 0.90;"/>
         <form:form id="questionAndAnswersForm" action="${pageContext.request.contextPath}/action/edit-question-and-answer"   method="POST" commandName="questionAndAnswers"> 
                 <h3 style="color: black"><img src="${pageContext.request.contextPath}/images/question1.png" width="20px;"/> - <span style="font-family: 'Lato', sans-serif;font-size: 15px;font-weight: bold;margin-le;">Edit Question Page</span>
        		 <span style="float: right;">
                 <input type="button" value="Update Question" class="mc-btn btn-style-1" id="upload"/>
           		</span>
                 </h3> 
                 	 <span style="color: green;font-size: 16px;font-family:rockwell" id="AppMessage">
								 ${ApplicationMessage}
						</span>
						<hr style="color: black" />
						<a href="${pageContext.request.contextPath}/action/add-edit-technology"><img alt=""
							src="${pageContext.request.contextPath}/images/add.png" width="25px;" title="Click here to add new technology."/></a>
							&nbsp;&nbsp;&nbsp;	
						 <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Technology</span> :&nbsp;
						 <form:select path="technology"  multiple="false"  class="form-control" style="width:200px;display:inline;" disabled="true" >
						         <option>Select Technology</option>
						 		<form:options  items="${technologyList}"/>
						 </form:select>
						         &nbsp;&nbsp;&nbsp;  
						 <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Q. Bank Name</span> :&nbsp;
						 <select name="qbankName" id="qbankName" class="form-control" style="width:200px;display:inline;" disabled="true">
						 </select>
						         &nbsp;&nbsp;&nbsp;         
						  <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Topic</span> :&nbsp;
						  <select id="topicName" name="topicName"  class="form-control" style="width:150px;display:inline;" disabled="true">
						  </select>
						      &nbsp;&nbsp;&nbsp;         
						  <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Complexity</span> :&nbsp;<form:select path="questionComplexity" items="${questionComplexityList}" multiple="false" class="form-control" style="width:150px;display:inline;" disabled="true"/>
						   
						     
						<!--   <input type="button" value="Add Question" id="upload"
									class="btn btn-primary btn-md"
									id="addQuestionId" style="font-family: 'Lato', sans-serif;font-size: 14px;"/> -->
						 <hr style="color:blue"/>   
					 
					 	 <span id="AppMessage" style="color:red;font-size: 14px;"></span>
					 	<table class="table table-bordered" width="100%" >
							<tr height="30px"
								style="color: white; background-color: #37abf2; vertical-align: middle;"
								align="center">
								<td width="10px"><b></b></td>
								<td align="left">&nbsp;&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 16px;">Question Description</span></td>
							</tr>

							<tr height="25px">
								<td>
								 &nbsp;
								</td>
								<td>
								 <input type="hidden" name="questionId" value="${questionAndAnswers.questionId}">
								<textarea name="questionText" id="questionText" class="jqte-test"
										style="width: 100%;  min-height: 300px;font-family: rockwell" rows="120"></textarea> 
							
							<script>
							     var questionText='${questionAndAnswers.questionText}';
								$('.jqte-test').val(questionText);
								$('.jqte-test').jqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test').jqte({
										"status" : jqteStatus
										})
								});
							</script></td>
							</tr>
							<tr height="25px" style="display:${fn:length(questionAndAnswers.answerText1)==0?'none':''};">
								<td><input type="radio" name="correct" id="correctId1"
									value="${questionAndAnswers.answerId1}"  ${questionAndAnswers.answerId1==questionAndAnswers.correctOption?'checked':''}/><label for="correctId1">A</label>
									<input type="hidden" name="correct1" value="${questionAndAnswers.answerId1}"/></td>
								<td><textarea name="answerText1" rows="2" id="answerText1"
										style="width: 100%;">${questionAndAnswers.answerText1}</textarea></td>
							</tr>

							<tr height="25px" style="display:${fn:length(questionAndAnswers.answerText2)==0?'none':''};">
								<td><input type="radio" name="correct" id="correctId2"
									value="${questionAndAnswers.answerId2}"  ${questionAndAnswers.answerId2==questionAndAnswers.correctOption?'checked':''} /><label for="correctId2">B</label>
									<input type="hidden" name="correct2" value="${questionAndAnswers.answerId2}"/></td>
								<td><textarea name="answerText2" id="answerText2"  rows="2"
										style="width: 100%;">${questionAndAnswers.answerText2}</textarea></td>
							</tr>

							<tr height="25px" style="display:${fn:length(questionAndAnswers.answerText3)==0?'none':''};">
								<td><input type="radio" name="correct" id="correctId3"
									value="${questionAndAnswers.answerId3}" ${questionAndAnswers.answerId3==questionAndAnswers.correctOption?'checked':''}/><label for="correctId3">C</label>
									<input type="hidden" name="correct3" value="${questionAndAnswers.answerId3}"/></td>
								<td><textarea id="answerText3" name="answerText3" rows="2"
										style="width: 100%;">${questionAndAnswers.answerText3}</textarea></td>
							</tr>

							<tr height="25px" style="display:${fn:length(questionAndAnswers.answerText4)==0?'none':''};">
								<td><input type="radio" name="correct" id="correctId4"
									value="${questionAndAnswers.answerId4}"   ${questionAndAnswers.answerId4==questionAndAnswers.correctOption?'checked':''}/><label for="correctId4">D</label>
									<input type="hidden" name="correct4" value="${questionAndAnswers.answerId4}"/></td>
								<td><textarea id="answerText4" name="answerText4" rows="2"
										style="width: 100%;">${questionAndAnswers.answerText4}</textarea></td>
							</tr>


							<tr height="25px" style="display:${fn:length(questionAndAnswers.answerText5)==0?'none':''};">
								<td>
								<input type="radio" name="correct" id="correctId5"
									value="${questionAndAnswers.answerId5}"  ${questionAndAnswers.answerId5==questionAndAnswers.correctOption?'checked':''}/><label for="correctId5">E</label>
									<input type="hidden" name="correct5" value="${questionAndAnswers.answerId5}"/></td>
								<td><textarea id="answerText5"  name="answerText5" rows="2"
										style="width: 100%;">${questionAndAnswers.answerText5}</textarea></td>
							</tr>

							<tr height="25px" style="display:${fn:length(questionAndAnswers.answerText6)==0?'none':''};">
								<td><input type="radio" name="correct" id="correctId6"
									value="${questionAndAnswers.answerId6}"  ${questionAndAnswers.answerId6==questionAndAnswers.correctOption?'checked':''}/><label for="correctId6">F</label>
									<input type="hidden" name="correct6" value="${questionAndAnswers.answerId6}"/></td>
								<td><textarea id="answerText6" name="answerText6" rows="2"
										style="width: 100%;">${questionAndAnswers.answerText6}</textarea></td>
							</tr>

							<tr height="25px" style="display:${fn:length(questionAndAnswers.answerText7)==0?'none':''};">
								<td><input type="radio" name="correct" id="correctId7"
									value="${questionAndAnswers.answerId7}"  ${questionAndAnswers.answerId7==questionAndAnswers.correctOption?'checked':''}/><label for="correctId7">G</label>
									<input type="hidden" name="correct7" value="${questionAndAnswers.answerId7}"/></td>
								<td><textarea id="answerText7" name="answerText7" rows="2"
										style="width: 100%;">${questionAndAnswers.answerText7}</textarea></td>
							</tr>
							
							<tr height="25px">
								<td width="10px"><span style="font-family: 'Lato', sans-serif;font-size: 14px;">Exp</span></td>
								<td><textarea id="correctAnsDescription" name="correctAnsDescription" rows="2"
										style="width:100%;">${questionAndAnswers.correctAnsDescription}</textarea></td>
							</tr>

							<tr height="25px">
								<td>&nbsp;</td>
								<td align="right">
								<input type="reset" value="Clear" style="font-family: 'Lato', sans-serif;font-size: 14px;"
								class="mc-btn btn-style-1"
									id="reset" />
								
								<input type="button" value="Updated Question" style="font-family: 'Lato', sans-serif;font-size: 14px;"
							class="mc-btn btn-style-1"
									id="upload" />
									&nbsp;
									</td>
							</tr>

						</table>
					 
					 
					 


            </form:form>
        </div>
    </section>

    <!-- END / COURSE CONCERN -->


   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>

<script type="text/javascript">

	  function  loadSelectionData() {
		     var checkFromServer="${questionAndAnswers.technology}";
		     if(checkFromServer.length==0){
			 		$("#AppMessage").html("");
		     }
			 var stechName=$("#technology").val();
			  if("Select Technology"==stechName){
				  return;
			  }
				var ccontextPath="${pageContext.request.contextPath}";
				 $.getJSON(ccontextPath+"/action/findTestAndTopicsByTechName", {techName:stechName}, function(jsonResponse) {
					 	$('#qbankName').empty()
					 	if(jsonResponse.qbankNameList.length>0){
					 		 $.each(jsonResponse.qbankNameList, function(i, item) {
					 			$("#qbankName").append($("<option />").val(item).text(item));
					 		});
					 		$("input[type='button'][id$='upload']").removeAttr('disabled');
					 	}else{
					 		$("#AppMessage").html("No question bank exist for selected technology "+stechName+" , please create <b>\"question bank\"</b>  first.");
					 		$("input[type='button'][id$='upload']").prop('disabled', true);
					 	}
					 	$("#qbankName").append($("<option />").val("No").text("Select Question Bank"));
					 	
					 	$('#topicName').empty()
						if(jsonResponse.topics.length>0){
					 		 $.each(jsonResponse.topics, function(i, item) {
					 			$("#topicName").append($("<option />").val(item).text(item));
					 		});
					 	}
					 	$("#topicName").append($("<option />").val("Other").text("Other"));
				 });//end of the callback function..................  
	  
	  }
	
	 $(document).ready(function(){
		 loadSelectionData();
		 $("#technology").change(function(){
			 loadSelectionData();
		 }); //end of the change method
	 });//end of the ready handler	


    $.each($('.table-wrap'), function() {
        $(this)
            .find('.table-item')
            .children('.thead:not(.active)')
            .next('.tbody').hide();
        $(this)
            .find('.table-item')
            .delegate('.thead', 'click', function(evt) {
                evt.preventDefault();
                if ($(this).hasClass('active')==false) {
                    $('.table-item')
                        .find('.thead')
                        .removeClass('active')
                        .siblings('.tbody')
                            .slideUp(200);
                }
                $(this)
                    .toggleClass('active')
                    .siblings('.tbody')
                        .slideToggle(200);
        });
    });

</script>
</body>

</html>