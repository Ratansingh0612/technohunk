<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery.owl.carousel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery.appear.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery.easing.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/qjquery-loading.js"></script>
  <script type="text/javascript">
        if (window.addEventListener) {  // all browsers except IE before version 9
            window.addEventListener ("beforeunload", OnBeforeUnLoad, false);
        }
        else {
            if (window.attachEvent) {   // IE before version 9
                window.attachEvent ("onbeforeunload", OnBeforeUnLoad);
            }
        }
            // the OnBeforeUnLoad method will only be called in Google Chrome and Safari
        function OnBeforeUnLoad () {
            	//invalidate the session
            	 $.getJSON(ccontextPath+"/action/invalidate-session",function(jsonResponse) {
            		   console.log(jsonResponse);
            	 }
                return "Since you have clicked on close button so your session is  expired!";
        }
    </script>

<script type="text/javascript">
$("#searchConsultantId").keyup(function(e) {
	 if(e.keyCode == 13) {
		// var yesno=confirm("Do you want to search consultant test reasult!");
		 //if(yesno) 
		 $("#searchConsulatTestForm").submit();
	 }
});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/start-test.js"></script>
 <script type="text/javascript">
 var tquesions="${totalQuestions}";
 function jumpToQuestion(pquestionId,questionNo){
	 //alert("++pquestionId = "+pquestionId);
	//alert("Mot!");
	 //var pselectedAnswerId= $("input[type='radio'][id*='selectedAnswerId']").val();
	 //var selected = $("input[type='radio'][id*='selectedAnswerId'']:checked");
	 //there was a bug in the application.it was always seleting first option
	 $('.bloading').loading({ overlay: true,base: 0.6 });
 	$('.bloading').loading('show');
	 $.getJSON(ccontextPath+"/action/jumpToQuestion.json", { selectedQuestionNo:questionNo,selectedQuestionId:pquestionId}, function(jsonResponse) {
	//	 console.log("@@(@((@@(@))))");
		// console.log(jsonResponse);
		 var cqno=0;
		 if(!jQuery.isEmptyObject(jsonResponse)) {
				jQuery.each(jsonResponse, function(i, val) {
					 console.log("i = "+i);
				 	 console.log(val);
				   //var val="todo";
				   if(val=='disabled') {
					   //below code is hiding the next button
					   $("#nextButtonInvisible").show();
					   //$("#nextButtonVisible").hide();
					   //alert("val = "+val);
					   $("#nextId").attr('disabled',true);
					   $("#userinfo").show();
				   } else {
					   //val=jsonResponse.questionAndAnsTestDataVO;
					   var selectedOption=val['selectedOption'];
					   if(!selectedOption){
						   return;
					   }
					   console.log("selectedOption = "+selectedOption);
					   //PLEASE LOOK INTO THIS LOOP @28thNOV2014
					   //PLEASE LOOK INTO THIS LOOP
					   //PLEASE LOOK INTO THIS LOOP
					   //PLEASE LOOK INTO THIS LOOP
					   
					  // alert("selectedOption = "+selectedOption);
					  // alert("selectedOption length()= "+selectedOption.length);
					   //alert("val 11= "+val['questionText']);
					   $("#currentQuestionNo").html(val['id']);
					   cqno=val['id'];
					  // alert("mk = "+val['topic']);
					   $("#questionTopic").html(val['topic']);
					   $('#questionText').html(val['questionText']);
					   $('#questionTextId').html(val['questionText']);
					   $('#questionNo').html("Question "+val['id']);

					   if(val['answerText1']!=null) {
					   		$('#answerText1Id').html(val['answerText1']);
					   		$("input[type='radio'][id$='selectedAnswerId1']").val(val['answerId1']);
					   		 if(val['answerId1']==selectedOption){
					   			$("input[type='radio'][id$='selectedAnswerId1']").prop('checked','checked');
								$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("A");
					   		 }else {
					   		 	  $("input[type='radio'][id$='selectedAnswerId1']").removeAttr('checked');
					   		 }
					   	     $('#optionTable tr[id="tr1th"]').show();
					   }  else {
						   $('#optionTable tr[id="tr1th"]').hide();
					     }
					   
					   if(val['answerText2']!=null) {
					   $('#answerText2Id').html(val['answerText2']);
					   $("input[type='radio'][id$='selectedAnswerId2']").val(val['answerId2']);
					   	  if(val['answerId2']==selectedOption){
					   		 $("input[type='radio'][id$='selectedAnswerId2']").prop('checked','checked');
					   		$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("B");
				   		    }else {
				   		 	  $("input[type='radio'][id$='selectedAnswerId2']").removeAttr('checked');
				   		     }
					    	$('#optionTable tr[id="tr2th"]').show();
					   }
					   else {
						   $('#optionTable tr[id="tr2th"]').hide();
					     }
					   
					   if(val['answerText3']!=null) {
			   				$('#answerText3Id').html(val['answerText3']);
			   				$("input[type='radio'][id$='selectedAnswerId3']").val(val['answerId3']);
			   			 if(val['answerId3']==selectedOption){
				   			  $("input[type='radio'][id$='selectedAnswerId3']").prop('checked','checked');
				   			$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("C");
				   		 }else {
				   		 	  $("input[type='radio'][id$='selectedAnswerId3']").removeAttr('checked');
				   		 }
			   			$('#optionTable tr[id="tr3th"]').show();
					   }
					   else {
						   $('#optionTable tr[id="tr3th"]').hide();
					     }
					   
					   if(val['answerText4']!=null) {
					       $('#answerText4Id').html(val['answerText4']);
					   		$("input[type='radio'][id$='selectedAnswerId4']").val(val['answerId4']);
					   	 if(val['answerId4']==selectedOption){
				   			  $("input[type='radio'][id$='selectedAnswerId4']").prop('checked','checked');
				   		    	$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("D");
				   		 }else {
				   		 	  $("input[type='radio'][id$='selectedAnswerId4']").removeAttr('checked');
				   		 }
					 	$('#optionTable tr[id="tr4th"]').show();
					   }
					   else {
						   $('#optionTable tr[id="tr4th"]').hide();
					     }
					   
					   if(val['answerText5']!=null) {
					     	$('#answerText5Id').html(val['answerText5']);
					  	 	$("input[type='radio'][id$='selectedAnswerId5']").val(val['answerId5']);
					  	  if(val['answerId5']==selectedOption){
				   			  $("input[type='radio'][id$='selectedAnswerId5']").prop('checked','checked');
				   			$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("E");
				   		 }else {
				   		 	  $("input[type='radio'][id$='selectedAnswerId5']").removeAttr('checked');
				   		 }
					  	$('#optionTable tr[id="tr5th"]').show();
					   }else {
						   $('#optionTable tr[id="tr5th"]').hide();
					     }
					   
					   if(val['answerText6']!=null) {
					   		$('#answerText6Id').html(val['answerText6']);
					   		$("input[type='radio'][id$='selectedAnswerId6']").val(val['answerId6']);
					   		if(val['answerText6']==selectedOption){
					   		  $("input[type='radio'][id$='selectedAnswerId6']").prop('checked','checked');
					   		$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("F");
					   		}else{
					   			$("input[type='radio'][id$='selectedAnswerId6']").removeAttr('checked');
					   		}
					   		$('#optionTable tr[id="tr6th"]').show();
					   	} else {
							   $('#optionTable tr[id="tr6th"]').hide();
					     }
					   
					   if(val['answerText7']!=null) {
					   			$('#answerText7Id').html(val['answerText7']);
					   			$("input[type='radio'][id$='selectedAnswerId7']").val(val['answerId7']);
					   			if(val['answerText7']==selectedOption){
							   		  $("input[type='radio'][id$='selectedAnswerId7']").prop('checked','checked');
							   		$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("G");
							   		}else{
							   			$("input[type='radio'][id$='selectedAnswerId7']").removeAttr('checked');
							   		}
					   			$('#optionTable tr[id="tr7th"]').show();
					   }else {
						   $('#optionTable tr[id="tr7th"]').hide();
					   }
					   
					   //$('#optionTable tr[id="hideme"]').hide();//in table1 hide tr that are with attribute id="hideme"
					   //$('#table1 tr:first').hide();
						//Alternatively you could use the id of the tr as it is intended to be unique:
						//$('#hideme').hide();
					   //unselecting the radio button
					   //alert("clearing the selection")
				   }
    			});
   			 var questionText=jsonResponse['nextButton'];
   		     //alert("questionText = "+questionText);  
   		   //  alert("tquesions = "+tquesions);
   			  //alert("cqno = "+cqno);
   		     if(cqno==tquesions){
   		  	    $("#nextId").attr('disabled',true);
   		  	   $("#userinfo").show();
   		     }else{
   				   $("#nextId").removeAttr('disabled');
   				   $("#userinfo").hide();
   		     }
		 }  
		 $('.bloading').loading('hide');
   	 });
 }
 
 </script>
 <script type="text/javascript">
  //http://localhost:8080/OnlineTest/
  var ccontextPath="${pageContext.request.contextPath}";
 /*  window.onbeforeunload = function () {
	    window.setTimeout(function () { // escape function context
	        window.location = ccontextPath+"/action/oauth?emessage=Your session has been expired, since you have pressed refresh button.";
	    }, 0);
	    window.onbeforeunload = null;   // necessary to prevent infinite loop
	                                    // that kills your browser
	    window.location = ccontextPath+"/action/oauth?emessage=Your session has been expired, since you have pressed refresh button.";
	        // pressing leave will still leave, but the GET may be fired first anyway
} */
  	
</script>
<script type="text/javascript">

/* Although its not a good idea to disable F5 key you can do it in JQuery as below. */

function disableF5(e) { if ((e.which || e.keyCode) == 116 || (e.which || e.keyCode) == 82) e.preventDefault(); };
$(document).ready(function(){
     $(document).on("keydown", 'disableF5');
});
</script>
       <style>
            .scrollcollone {
    padding: 1%;
    font-size: 15px;
    width: 98%;
    /* background: rgba(204, 204, 204, 0.28);; */
    border-left: 5px solid #1a5688;
    margin-top: 2%;
    margin-right: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
}
.apply {
    border: 1px #5f328b solid;
    background: #5f328b;
    color: #fff;
    text-decoration: none !important;
    transition: all 0.3s ease;
    padding:  5px;
    border-radius: 3px;
    margin-bottom: 10px;
    margin-left: 0px;
   
}
.table-bordered > tbody > td{
           width:75%;
           }
.apply:hover
{
background-image:none !important;
background-color:white !important;
color: #5f328b;
}
            </style>
            
            <style>
input[type=radio]{
  display:none;
}

input[type=radio] + label:after{
  content: '';
  display:inline-block;
  border-radius: 8px;
  width: 12px;
  height:12px;
  background:white;
  color:blue;
  border: 1px solid black;
  line-height: 11px;
  text-align: center;
  margin-right: 5px;
}

input[type=radio]:checked + label:after{
  color: red;
   background:#b65efe;
}
</style>
    <title>${companyName} - Test In Progress</title>
</head>
<body>
	<script type="text/javascript">
                    initialSec=${sessionScope.testDuration*60};
			 		//alert("aa = "+initialSec);	
			 		//alert(${sessionScope.testDuration});
					countDown(initialSec,"status");
  			</script>
<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- PRELOADER -->
    <!-- END / PRELOADER -->

    <!-- HEADER -->
     <k:if test="${sessionScope.user_session_data.role=='user'}">	
      <%@include file="/uheader.jsp" %>
      </k:if>
      <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
      <%@include file="/uheader.jsp" %>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
       <%@include file="/theader.jsp" %>
       </k:if>
             <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp" %>
           </k:if>
                <k:if test="${sessionScope.user_session_data.role=='guest'}">	
       <%@include file="testheader.jsp" %>
           </k:if>
    <!-- END / HEADER -->

    <!-- PROFILE FEATURE -->
 <%--    <%@include file="profile-feature.jsp" %> --%>
    <!-- END / PROFILE FEATURE -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;background-color: white;min-height: 580px;" id="quizz-intro-section" >
        <div class="container">
        <%--     <div  style="background-image: url('${pageContext.request.contextPath}/images/bg/tbg.jpg');"> --%>
        	<br/>
            <div  style="background-color: #eef9ffdb;">
          <span style="color: black">
     
                 		<img src="${pageContext.request.contextPath}/images/icon/temp_logo_testing.png" style="height:40px;"/> - 
					     	 		<span id="status" style="float: right;color:black;margin-left: 100px;"></span> 
					     	   Technology : &nbsp;&nbsp;&nbsp;<span  id="ttech" style="color:black;font-weight: normal;">${utechName}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	 Test Name :&nbsp;&nbsp;&nbsp; <span  id="ttech" style="color:black;font-weight: normal;">${utestName}</span> 
			</span> 
            </div>
            
					     	  <div style="float:right;">
					     	 		<div id="status"></div> 
					     	 </div>
            <form  id="startTechTestForm" action="${pageContext.request.contextPath}/action/submitTechAnswer" method="POST">
           <input type="hidden" id="questionText" name="questionText" value="${questionAndAnsTestDataVO.questionId}"/>
            <div class="bloading" >
                <table class="table table-bordered" style="width: 120%;">
                        <tr><td>
                        <table id="optionTable" border="0"    style="margin-top: 0px;border-collapse:separate !important;">
                         <tr align="left">
					     	<td  colspan="2" align="right">&nbsp;&nbsp;
					     		<br/>
					     	    <span style="float: left;">
					     		<img src="${pageContext.request.contextPath}/images/question1.png" width="25px;"/>
					     			Question: <span id="currentQuestionNo">${sessionScope.currentQuestionNo}</span> of &nbsp; ${totalQuestions} - <span id="questionTopic">${questionAndAnsTestDataVO.topic}</span>
					     		</span>
					     		<span style="">
					     		<a href="${pageContext.request.contextPath}/action/leaveTest?testName=${utestName}&techName=${utechName}" >Leave Test</a>
					  			  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;My Answer:&nbsp;&nbsp;<input type="text" id="showSelectedAnswerId" name="showSelectedAnswerIdAnswer" style="width: 50px;height: 24px;display:inline;!importent" value="" class="form-control" readonly="readonly"/>
					  			  </span> 
					  			  </td>
					     </tr>	
                          <tr  style="background-color:white;color:black;">
					     <td colspan="2"  align="left">
					     	<div id="questionTextId" class="scrollcollone">${questionAndAnsTestDataVO.questionText}</div>
					     
					     	 	</td>
					     
					     </tr>
					     
					       
					     
					      <!--  <tr align="left">
					     	<td  colspan="2" align="left">&nbsp;&nbsp;</td>
					     </tr> -->	
					     
					     <tr  id="tr1th">
						 <td style="width: 100%;font-size: 13px;font-family: 'Raleway', sans-serif;">
					        <br/>
					   		<input type="radio" id="selectedAnswerId1" name="selectedAnswerId" value="${questionAndAnsTestDataVO.answerId1}" cvalue="A" style="margin-top: 30px;"> 
					   		  <label for="selectedAnswerId1">
					   		  <font style="width:40px;background-color:#91f3d778;font-size: 16px;" id="selectedAnswerIdOption1">
					   		&nbsp; A&nbsp;&nbsp;</font>&nbsp;&nbsp;</label>
					     &nbsp;
					   	   <span id="answerText1Id">${questionAndAnsTestDataVO.answerText1}</span>
					   	    <hr style="color: black;width: 125%;margin-top: 8px;margin-bottom: 8px;"/>
					   	   </td>
					   	 </tr>
<!-- 					      <tr align="left"> -->
<!-- 					     	<td  colspan="2" align="left">&nbsp;&nbsp;</td> -->
<!-- 					     </tr>	 -->
					     
					    
					     <tr style="color: black"  id="tr2th">
					 <td style="width: 100%;font-size: 13px;font-family: 'Raleway', sans-serif;">
					  <input type="radio" id="selectedAnswerId2" name="selectedAnswerId" value="${questionAndAnsTestDataVO.answerId2}" cvalue="B" style="margin-top: 30px;"> 
					   		  <label for="selectedAnswerId2">
					   		  <font style="width:40px;background-color:#91f3d778;font-size: 16px;" id="selectedAnswerIdOption2">
					   		&nbsp; B&nbsp;&nbsp;</font>&nbsp;&nbsp;</label>
					     &nbsp;
							<span style="" id="answerText2Id">${questionAndAnsTestDataVO.answerText2}</span>
					   	  <!--   <hr style="color: black;width: 125%;h" align="left"/> -->
					   	   <hr style="color: black;width: 125%;margin-top: 8px;margin-bottom: 8px;"/>
					   	   </td>
					   	 </tr>
					    <!--  <tr align="left">
					     	<td  colspan="2" align="left">&nbsp;&nbsp;</td>
					     </tr>	 -->
					     
					     
					      <tr style="color: black" id="tr3th">
					 <td style="width: 100%;font-size: 13px;font-family: 'Raleway', sans-serif;">
					    <input type="radio" id="selectedAnswerId3" name="selectedAnswerId" value="${questionAndAnsTestDataVO.answerId3}" cvalue="C" style="margin-top: 30px;"> 
					   		  <label for="selectedAnswerId3">
					   		  <font style="width:40px;background-color:#91f3d778;font-size: 16px;" id="selectedAnswerIdOption3">
					   		&nbsp; C&nbsp;&nbsp;</font>&nbsp;&nbsp;</label>
					     &nbsp;
						<span id="answerText3Id">${questionAndAnsTestDataVO.answerText3}</span>
					   	   <hr style="color: black;width: 125%;margin-top: 8px;margin-bottom: 8px;"/>
					   	   </td>
					   	 </tr>
					     <!-- <tr align="left">
					     	<td  colspan="2" align="left">&nbsp;&nbsp;</td>
					     </tr>	 -->
					     
					      <tr style="color: black" id="tr4th">
					 	 <td style="width: 100%;font-size: 13px;font-family: 'Raleway', sans-serif;">
					    <input type="radio" id="selectedAnswerId4" name="selectedAnswerId" value="${questionAndAnsTestDataVO.answerId4}" cvalue="D" style="margin-top: 30px;"> 
					   		  <label for="selectedAnswerId4">
					   		  <font style="width:40px;background-color:#91f3d778;font-size: 16px;" id="selectedAnswerIdOption4">
					   		&nbsp; D&nbsp;&nbsp;</font>&nbsp;&nbsp;</label>
					     &nbsp;
							<span id="answerText4Id">${questionAndAnsTestDataVO.answerText4}</span>
					   	     <hr style="color: black;width: 125%;margin-top: 8px;margin-bottom: 8px;"/>
					   	   </td>
					   	 </tr>
					   <!--   <tr align="left">
					     	<td  colspan="2" align="left">&nbsp;&nbsp;</td>
					     </tr>	 -->
					     
					     <tr style="color: black" id="tr5th">
					 <td style="width: 100%;font-size: 13px;font-family: 'Raleway', sans-serif;">
					    <input type="radio" id="selectedAnswerId5" name="selectedAnswerId" value="${questionAndAnsTestDataVO.answerId5}" cvalue="E" style="margin-top: 30px;"> 
					   		  <label for="selectedAnswerId5">
					   		  <font style="width:40px;background-color:#91f3d778;font-size: 16px;" id="selectedAnswerIdOption5">
					   		&nbsp; E&nbsp;&nbsp;</font>&nbsp;&nbsp;</label>
					     &nbsp;
							<span id="answerText5Id">${questionAndAnsTestDataVO.answerText5}</span>
					   	     <hr style="color: black;width: 125%;margin-top: 8px;margin-bottom: 8px;"/>
					   	   </td>
					   	 </tr>
					   	 
					   	    <tr style="color: black" id="tr6th">
						 <td style="width: 100%;font-size: 13px;font-family: 'Raleway', sans-serif;">
					    <input type="radio" id="selectedAnswerId6" name="selectedAnswerId" value="${questionAndAnsTestDataVO.answerId6}" cvalue="F" style="margin-top: 30px;"> 
					   		  <label for="selectedAnswerId6">
					   		  <font style="width:40px;background-color:#91f3d778;font-size: 16px;" id="selectedAnswerIdOption6">
					   		&nbsp; F&nbsp;&nbsp;</font>&nbsp;&nbsp;</label>
					     &nbsp;
							<span id="answerText6Id">${questionAndAnsTestDataVO.answerText6}</span>
					   	     <hr style="color: black;width: 125%;margin-top: 8px;margin-bottom: 8px;"/>
					   	   </td>
					   	 </tr>
					   	 
					   	 <tr style="color: black" id="tr7th">
					 	 <td style="width: 100%;font-size: 13px;font-family: 'Raleway', sans-serif;">
					    <input type="radio" id="selectedAnswerId7" name="selectedAnswerId" value="${questionAndAnsTestDataVO.answerId7}" cvalue="G" style="margin-top: 30px;"> 
					   		  <label for="selectedAnswerId7">
					   		  <font style="width:40px;background-color:#91f3d778;font-size: 16px;" id="selectedAnswerIdOption7">
					   		&nbsp; G&nbsp;&nbsp;</font>&nbsp;&nbsp;</label>
					     &nbsp;
							<span id="answerText7Id">${questionAndAnsTestDataVO.answerText7}</span>
					   	     <hr style="color: black;width: 125%;margin-top: 8px;margin-bottom: 8px;"/>
					   	   </td>
					   	 </tr>
					   	 
					   	  
<!-- 					   	  <tr align="left"> -->
<!-- 					     	<td  colspan="1" align="left">&nbsp;&nbsp;  -->
<!-- 					     	</td> -->
					     	
<!-- 					     	<td  colspan="1" align="left" id="nextButtonVisible">&nbsp;&nbsp; -->
					     	
<!-- 					     	 <input type="button" id="submittest" value="Submit Test"  role="button" target="_blank" class="btn pull-right apply" style="font-family: 'Lato', sans-serif;font-size: 14px;float: left;"/> -->
<!-- 					     	 <div style="float: right;"> -->
<!-- 					     	 <input type="button" value=" Mark for Review" role="button" target="_blank" class="btn pull-right apply" id="markForReview" style="font-family: 'Lato', sans-serif;font-size: 14px;"/> -->
<!-- 					     	<input type="button" value="Next Question" role="button" target="_blank" class="btn pull-right apply" id="nextId" style="font-family: 'Lato', sans-serif;font-size: 14px;"/>	 -->
<!-- 					     	</div> -->
<!-- 					     	</td> -->
<!-- 					     </tr> -->
					     
					      <tr align="left">
					     	
					     	
					     	<td  colspan="1" align="left" id="nextButtonVisible" >
					     	 	<input type="button" value="Next Question" class="mc-btn btn-style-1" id="nextId" style="margin-top:0px !important;margin-bottom:0px !important; "/>&nbsp;
					     	 	<input type="button" value="Mark for Review" class="mc-btn btn-style-1" id="markForReview" style="margin-top:0px !important;margin-bottom:0px !important; "/>
					     	 	<input type="button" id="submittest" value="Submit Test" class="mc-btn btn-style-1" style="margin-top:0px !important;margin-bottom:0px !important; "/>
					     	</td>
					     	<td  colspan="2" align="left" id="submitTestButtonVisible">&nbsp;&nbsp;
					     	</td>
					     </tr>
					      <tr>
					      	<td colspan="2"> <span id="userinfo" style="background-color: #ffe7b5;">This is last question , so please select an option and click on submit button to submit the test.</span></td>
					      </tr>
                        </table>
                        
                        </td>
                            <td width="25%" style="background-color: white;">
                            <div class="pad_left1">
              <span style="font-family: 'Lato', sans-serif;font-size: 14px;"> &nbsp;&nbsp;&nbsp;Question List(${fn:length(sessionScope.questionsMapForTest)}) : <img alt="" src="${pageContext.request.contextPath}/images/question2.png" width="20px;"></span>
            </div>
             <br/>
             
             
             
          <p/>
             	 <k:forEach var="tquestion" items="${sessionScope.questionsMapForTest}" varStatus="sno">
              		<a href="javascript:jumpToQuestion('${tquestion.value}',${sno.count});" style="background-color: pink;color:black;" id="questionNum${sno.count}">&nbsp;&nbsp;${sno.count}&nbsp;&nbsp;</a>
              		   <k:if test="${sno.count%8==0}">
              		       <br/><p/>
              		   </k:if>
				</k:forEach>	
              <br/><p/>
           <!--  <a href="#" class="button"><span><span>Read More</span></span></a> -->
            <div class="pad_left1">
                 <b style="font-family: 'Lato', sans-serif;font-size: 13px;">About Square Color <img alt="" src="${pageContext.request.contextPath}/images/info.png"></b>
           		   <p style="font-family: 'Lato', sans-serif;font-size: 14px; color: black;">
                <span><img src="${pageContext.request.contextPath}/images/exam.png" style="height: 50px;"></span>
             	 <img src="${pageContext.request.contextPath}/images/icon/pink-icon.png" style="height: 16px;"/> &nbsp;&nbsp; ->&nbsp; Question is not attempted<br/>
             	     	 <img src="${pageContext.request.contextPath}/images/icon/green-icon.png" style="height: 16px;"/> &nbsp;&nbsp; ->&nbsp; Question is  attempted<br/>
             	  <img src="${pageContext.request.contextPath}/images/icon/yellow-icon.png" style="height: 16px;"/>&nbsp;&nbsp; &nbsp;-> &nbsp;Question is  attempted but <br/>user can  change the option
               .</p>
               <hr/>
         <%--        <span><img src="${pageContext.request.contextPath}/images/exam-80px.png"></span> --%>
            <%--   <b style="font-family: 'Lato', sans-serif;font-size: 15px;">About Test <img alt="" src="${pageContext.request.contextPath}/images/info.png"></b>
              <p style="font-family: 'Lato', sans-serif;font-size: 15px; color: black;">All the tests are single choice. Every time random questions will be 
               displayed. please do not refresh your browser during test.
                You can go online test more than one halts.
               .</p> --%>
            
            </div>
                            </td>
                            </tr>
                    </tbody>
                </table>
            </div>
            </form>

            
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

 
<script type="text/javascript">
$(document).ready(function(){
	  $("#userinfo").hide();
	 init();
	 
	 //Just commented since question was submitted twice here!!!!!!!!!
	// $("#nextId").click(function(){
	// 		 alert("_@_@)@)@)hacker___");
		// submitAnswer('#ACBD01');
	/// });
	 
	 //Just commented since question was submitted twice here!!!!!!!!!
	/*  $("#markForReview").click(function() {
		 submitAnswer('yellow');
	 }); */
	 
	 $("#submittest").click(function(event) {
		 if($("input[type='radio'][id*='selectedAnswerId']").is(':checked')){
			// document.forms[0].action="submitTechTest";
			 var contextPath="${pageContext.request.contextPath}/action/submitTechTest";
			 //http://localhost:8080/${companyName}/action/submitTechAnswer
			  var yesno=confirm("Are you sure want to submit the test?");
			 if(yesno){
			 	$("#startTechTestForm").attr("action",contextPath)
			 	$("#startTechTestForm").submit();
			 }else{
				 event.preventDefault();
			 }
		 }else{
	 			 alert("Please select a least one correct option , before submitting the final test.");
		    // jAlert('Please fill this field.',"OK");
		 
 		}
	 });
	 
	});


</script>

 <!-- Modal -->
<div id="testTimeoutModel" class="modal fade" role="dialog">
  <div class="modal-dialog" style="width: 800px;">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 40px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <br/>
      <img src="${pageContext.request.contextPath}/images/bell.jpg" width="60px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      &nbsp;     &nbsp;     &nbsp;
        </div>
        
        <div class="form-group">
      	<label id="stream"><h5 style="color:#03141c;"><b>Sorry! your test has been expired and redirecting to your dashboard, please wait.....<span id="secondsTimer" style="color:red;"></span></b></h5></label>
        </div>
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="OK"  class="mc-btn btn-style-1" id="OK"  data-dismiss="modal"/>
      </div>
    </div>

  </div>
</div>

</body>
<script>

</script>

</html>