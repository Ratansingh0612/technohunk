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
    <title>${companyName} - Upload Questions</title>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery-1.11.0.min.js"></script>
	
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery-te-1.4.0.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-te-1.4.0.min.js"
	charset="utf-8"></script>
	
		
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pajquery-te-1.4.0.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/pajquery-te-1.4.0.min.js"
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
				 var correctVal =$('input:radio[name=correct]:checked').val();
				//alert("correctVal = "+correctVal);
				 if(correctVal=="Correct1") {
					 $("input[type='hidden'][name='correct1']").val('Correct1');
				 }else if(correctVal=="Correct2") {
					 $("input[type='hidden'][name='correct2']").val('Correct2');
				 }else if(correctVal=="Correct3") {
					 $("input[type='hidden'][name='correct3']").val('Correct3');
				 }else if(correctVal=="Correct4") {
					 $("input[type='hidden'][name='correct4']").val('Correct4');
				 }else if(correctVal=="Correct5") {
					 $("input[type='hidden'][name='correct5']").val('Correct5');
				 }else if(correctVal=="Correct6") {
					 $("input[type='hidden'][name='correct6']").val('Correct6');
				 }else if(correctVal=="Correct7") {
					 $("input[type='hidden'][name='correct7']").val('Correct7');
				 }
				 
				$("#questionAndAnswersForm").submit();		 
			/* 	 $.ajax({
	                    url:'${pageContext.request.contextPath}/action/show-question-and-answer',
	                    type:'POST',
	                    data:$("#questionAndAnswersForm").serialize(),
	                    success:function(result){
	                        $("#AppMessage").html('Question has been uploaded successfully, please type a new question in "question description"');
	                        $('.jqte-test').html("");
	                        $("#questionText").val("")
	                        $("#answerText1").val("");
	                        $("#answerText2").val("");
	                        $("#answerText3").val("");
	                        $("#answerText4").val("");
	                        $("#answerText5").val("");
	                        $("#answerText6").val("");
	                        $("#answerText7").val("");
	                        $("#correctAnsDescription").val("");
	                        $('input:radio[name*=correct]').removeAttr("checked");
	                        //Reseting the hidden value....
	                        $("input[type='hidden'][name='correct1']").val("");
	                        $("input[type='hidden'][name='correct2']").val("");
	                        $("input[type='hidden'][name='correct3']").val("");
	                        $("input[type='hidden'][name='correct4']").val("");
	                        $("input[type='hidden'][name='correct5']").val("");
	                        $("input[type='hidden'][name='correct6']").val("");
	                        $("input[type='hidden'][name='correct7']").val("");
	                        window.scrollTo(500, 0);
	                    }
	            }); */
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
  <section style="padding-top: 0px;padding-bottom:10px;background-color: #eee;" id="quizz-intro-section">
  		<br/>	
        <div class="container" style="background-color: white;">
         <form:form id="questionAndAnswersForm" action="${pageContext.request.contextPath}/action/upload-question-and-answer"   method="POST" commandName="questionAndAnswers">
         			<br/> 
                  <img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" width="45px;"/>
                 <h3 style="color: black;font-size: 16px;display: inline;">  Questions  -> Upload Question & Answer</h3> 
                 
        		 <span style="float: right;">
                 <input type="button" value="Add Question" class="mc-btn btn-style-1" id="upload"/>
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
						 <form:select path="technology"  multiple="false"  class="form-control" style="width:200px;display:inline;">
						         <option>Select Technology</option>
						 		<form:options  items="${technologyList}"/>
						 </form:select>
						         &nbsp;&nbsp;&nbsp;  
						 <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Q. Bank Name</span> :&nbsp;
						 <form:select path="qbankName"  class="form-control" style="width:200px;display:inline;">
						        	<form:options  items="${qbankNameList}"/>
						 </form:select>
						         &nbsp;&nbsp;&nbsp;         
						  <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Topic</span> :&nbsp;
						  <form:select path="topicName"   class="form-control" style="width:150px;display:inline;">
						    	<form:options  items="${topics}"/>
						  </form:select>
						      &nbsp;&nbsp;&nbsp;         
						  <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Complexity</span> :&nbsp;<form:select path="questionComplexity" items="${questionComplexityList}" multiple="false" class="form-control" style="width:150px;display:inline;"/>
						   
						     
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
								<td><textarea name="questionText" id="questionText" class="jqte-test"
										style="width: 100%;  min-height: 300px;font-family: rockwell" rows="120">
							</textarea> 
							
							<script>
								$('.jqte-test').val('');
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
							<tr height="25px">
								<td><input type="radio" name="correct" id="correctId1"
									value="Correct1" /><label for="correctId1">A</label>
									<input type="hidden" name="correct1" /></td>
								<td><textarea name="answerText1" rows="2" id="answerText1"
										style="width: 100%;" class="jqte-test-1">${questions.questionText}</textarea>
								<script>
								$('.jqte-test-1').val('');
								$('.jqte-test-1').pajqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test-1').pajqte({
										"status" : jqteStatus
										})
								});
							</script>
										
										</td>
							</tr>

							<tr height="25px">
								<td><input type="radio" name="correct" id="correctId2"
									value="Correct2" /><label for="correctId2">B</label><input type="hidden" name="correct2" /></td>
								<td><textarea name="answerText2" id="answerText2"  rows="2"
										style="width: 100%;" class="jqte-test-2">${questions.questionText}</textarea>
										<script>
								$('.jqte-test-2').val('');
								$('.jqte-test-2').pajqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test-2').pajqte({
										"status" : jqteStatus
										})
								});
							</script>
										
										</td>
							</tr>

							<tr height="25px">
								<td><input type="radio" name="correct" id="correctId3"
									value="Correct3" /><label for="correctId3">C</label><input type="hidden" name="correct3" /></td>
								<td><textarea id="answerText3" name="answerText3" rows="2"
										style="width: 100%;" class="jqte-test-3">${questions.questionText}</textarea>
										<script>
								$('.jqte-test-3').val('');
								$('.jqte-test-3').pajqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test-3').pajqte({
										"status" : jqteStatus
										})
								});
							</script>
										</td>
							</tr>

							<tr height="25px">
								<td><input type="radio" name="correct" id="correctId4"
									value="Correct4" /><label for="correctId4">D</label><input type="hidden" name="correct4" /></td>
								<td><textarea id="answerText4" name="answerText4" rows="2"
										style="width: 100%;" class="jqte-test-4">${questions.questionText}</textarea>
										
							<script>
								$('.jqte-test-4').val('');
								$('.jqte-test-4').pajqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test-4').pajqte({
										"status" : jqteStatus
										})
								});
							</script>
							</td>
							</tr>


							<tr height="25px">
								<td><input type="radio" name="correct" id="correctId5"
									value="Correct5" />
									<label for="correctId5">E</label>
									<input type="hidden" name="correct5" /></td>
								<td><textarea id="answerText5"  name="answerText5" rows="2"
										style="width: 100%;" class="jqte-test-5">${questions.questionText}</textarea>
								<script>
								$('.jqte-test-5').val('');
								$('.jqte-test-5').pajqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test-5').pajqte({
										"status" : jqteStatus
										})
								});
							</script>		
										
								</td>
							</tr>

							<tr height="25px">
								<td><input type="radio" name="correct" id="correctId6"
									value="Correct6" /><label for="correctId6">F</label><input type="hidden" name="correct6" /></td>
								<td><textarea id="answerText6" name="answerText6" rows="2"
										style="width: 100%;" class="jqte-test-6">${questions.questionText}</textarea>
									<script>
								$('.jqte-test-6').val('');
								$('.jqte-test-6').pajqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test-6').pajqte({
										"status" : jqteStatus
										})
								});
							</script>		
										
								</td>
							</tr>

							<tr height="25px">
								<td><input type="radio" name="correct" id="correctId7"
									value="Correct7" /><label for="correctId7">G</label><input type="hidden" name="correct7" /></td>
								<td><textarea id="answerText7" name="answerText7" rows="2"
										style="width: 100%;" class="jqte-test-7">${questions.questionText}</textarea>
								<script>
								$('.jqte-test-7').val('');
								$('.jqte-test-7').pajqte();
								// settings of status
								var jqteStatus = true;
								$(".status").click(function() {
										jqteStatus = jqteStatus ? false : true;
										$('.jqte-test-7').pajqte({
										"status" : jqteStatus
										})
								});
							</script>		
										
										
							</td>
							</tr>
							
							<tr height="25px">
								<td width="10px"><span style="font-family: 'Lato', sans-serif;font-size: 14px;">Exp</span></td>
								<td><textarea id="correctAnsDescription" name="correctAnsDescription" rows="2"
										style="width:100%;"></textarea></td>
							</tr>

							<tr height="25px">
								<td>&nbsp;</td>
								<td align="right">
								<input type="reset" value="Clear" style="font-family: 'Lato', sans-serif;font-size: 14px;"
								class="mc-btn btn-style-1"
									id="reset" />
								
								<input type="button" value="Add Question" style="font-family: 'Lato', sans-serif;font-size: 14px;"
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
		 //loadSelectionData();
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