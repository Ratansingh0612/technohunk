<%@page import="java.util.List"%>
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
    <title>${companyName} - Configure Test</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon-96x96.png"/>
 
   <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
 </style>

</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">
	
		<form id="deletequestionbasketform" action="${pageContext.request.contextPath}/action/delete-question-basket" method="post">
				
		</form>		 
	
	<form id="configuteTestForm" action="${pageContext.request.contextPath}/action/admin-available-questions-bank-test" method="get">
				<input type="hidden" name="testName">
				<input type="hidden" name="techName">
				<input type="hidden" name="validity">
				<input type="hidden" name="testDuration">
				<input type="hidden" name="random">
			</form>		 

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
  </div>
</div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- COURSE CONCERN -->
<section class="quizz-intro-section" style="padding-top: 0px;margin-bottom:-5px;;background-color: #eee;" id="content">
		<section style="height: 10px;background-color: #eee;">
   		</section>
        <div class="container" style="background-color: white;">
                 <h3 style="color: black;background-color:  #6dbbff1a;font-size: 24px;"><img src="${pageContext.request.contextPath}/images/icon/Icon_01.png" width="40px;"/> - <span style="font-size: 16px;">Test - > Configure Test</span></h3> 
            <form  id="configureNewTestForm" action="${pageContext.request.contextPath}/action/configuretest" method="post">
             <table class="table table-bordered">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left">
					      <label style="font-size: 14px;">
					        <img src="${pageContext.request.contextPath}/images/test-icon.png" style="height: 40px;"> Technology : 
					         </label>
					         	<select class="form-control" name="techName" id="techName" style="display: inline;width: 250px;">
							  	<option>Choose Technology</option>
							   <%
							 		List<String> techList=(List<String>)request.getAttribute("techList");
							   		String stechName=(String)session.getAttribute("techName");	
							 		for(String techName:techList){
							 		%>
									<option value="<%=techName%>" 
									   <% 
									    if(techName.equals(stechName)){
									    	 %>
									    	selected
									   <%
	 								   } 
									   %> 
									   >
									<%=techName%>
									
									</option>
									<%
							 	     }
									%>
						 </select> 
					             <img src="${pageContext.request.contextPath}/images/icon/writing-icon.png" style="height: 40px;margin-left: 20px"><label for="start time" style="font-size: 14px;">Test Name: &nbsp;&nbsp;</label>
      							<input type="text" id="testName"  name="testName" class="form-control" style="margin-left:30px;display: inline;width: 300px;" value="${sessionScope.testName}"/>
					 		</td>	
					   </tr>
					   
					     <tr height="10px" >
					       <td colspan="1" align="left">
					         <span id="validationMessage" style="color:red;font-size: 15px">${ApplicationMessage}</span>
					        &nbsp;
					     </td>
					   </tr>
					    <tr height="25px" >
					     <td colspan="1" align="left">
					        <label for="start time" style="font-size: 14px;">Test Duration: &nbsp;&nbsp;</label>
					          <select name="testDuration" id="testDuration" class="form-control" style="width: 150px;display: inline;margin-right: 30px;">
					              <option ${sessionScope.testDuration==5?'selected':''}>5</option>
					             <option ${sessionScope.testDuration==10?'selected':''}>10</option>
					             <option ${sessionScope.testDuration==15?'selected':''}>15</option>
					              <option ${sessionScope.testDuration==20?'selected':''}>20</option>
					            <option ${sessionScope.testDuration==25?'selected':''}>25</option>
					          <option ${sessionScope.testDuration==30?'selected':''}>30</option>
					             <option ${sessionScope.testDuration==35?'selected':''}>35</option>
					             <option ${sessionScope.testDuration==40?'selected':''}>40</option>
					           <option ${sessionScope.testDuration==45?'selected':''}>45</option>
					              <option ${sessionScope.testDuration==50?'selected':''}>50</option>
					             <option ${sessionScope.testDuration==55?'selected':''}>55</option>
					            <option ${sessionScope.testDuration==60?'selected':''}>60</option>
					             <option ${sessionScope.testDuration==65?'selected':''}>65</option>
					            <option ${sessionScope.testDuration==70?'selected':''}>70</option>
					             <option ${sessionScope.testDuration==75?'selected':''}>75</option>
					              <option ${sessionScope.testDuration==80?'selected':''}>80</option>
					             <option ${sessionScope.testDuration==85?'selected':''}>85</option>
					             <option ${sessionScope.testDuration==90?'selected':''}>90</option>
					             <option ${sessionScope.testDuration==95?'selected':''}>95</option>
					             <option ${sessionScope.testDuration==100?'selected':''}>100</option>
					             <option ${sessionScope.testDuration==105?'selected':''}>105</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>110</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>115</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>120</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>125</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>130</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>135</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>140</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>145</option>
					             <option ${sessionScope.testDuration==110?'selected':''}>150</option>
					             
					             
					          </select> 
					          (Mins)
					      <label for="end time" style="font-size: 14px;margin-left: 20px;">Validity(Hrs): &nbsp;&nbsp;</label>
      										<input type="text" name="validity" id="validity" class="form-control"  style="margin-right:30px;width: 200px;display: inline;" value="${sessionScope.validity==0?1000:sessionScope.validity}" />
					        <label for="start time" style="font-size: 14px;">Random: &nbsp;&nbsp;</label>
					        	<select name="random" id="random" class="form-control"  style="width: 150px;display: inline;">
					              <option ${sessionScope.random=='No'?'selected':''}>No</option>
					              <option ${sessionScope.random=='Yes'?'selected':''}>Yes</option>
					          </select> 
					     </td>
					     
					   </tr>
					     
					  </tbody>
					 </table>
	
            <div class="table-student-submission">
					    <span style="font-size: 16px;">Test Questions List  - >> </span>
					     &nbsp;&nbsp;&nbsp;  
                              <span style="font-size: 16px;">Click on image to select questions from bank:- </span>
                            <a href="javascript:addQuestionsFromBank();">
                            <img alt="" src="${pageContext.request.contextPath}/images/icon/file-icon.png"  style="height: 40px;"/>
                            </a>
					    <div style="float: right;">
                           <img src="${pageContext.request.contextPath}/images/question1.png" width="30px;"/>   <span style="font-size: 15px;">Total Questions : <span id="totalSelectedQuestions">${fn:length(questionsList)}</span></span>
                             </div>
                <table class="table table-bordered">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <th class="submissions" style="color: white;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-size: 14px;">Complexity</th>
                            <th class="author" style="color: white;font-size: 14px;">Questions </th>
                            <th class="score" style="color: white;font-size: 14px;">Technology </th>
                            <th class="score" style="color: white;font-size: 14px;width: 100px;" >OP<a href="javascript:" id="uncheckAll">&nbsp;&nbsp;<img src="${pageContext.request.contextPath}/images/uncheckedall.png" style="height: 20px;"/></a></th>
                        </tr>
                    </thead>

                    <tbody>
                   <c:forEach var="question" items="${questionsList}" varStatus="status">
					      <tr  style="color: black">
					     <td><b>${status.count}.</b></td>
					   	   <td>${question.questionComplexity}</td>
					   	   <td>&nbsp;${question.questionText}</td>
					   	     <td>&nbsp;${question.technology}</td>
					   	    <td align="center">
					   	    <input type="checkbox" name="scbox" id="scbox" style="background-color:teal"  value="${question.questionId}" checked/>
				   	  		  <img alt="" src="${pageContext.request.contextPath}/images/delete-q.png" style="height: 20px;"/> 
											</td>
					     </tr>
					   </c:forEach>  
					   
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					     </tr>
					     <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	  <td bgcolor="white">&nbsp;</td>
					     </tr>
					   <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	  <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					      <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	  <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					      <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	  <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					     
					     <tr >
					       <td colspan="2">
					        <input type="button" value="Clear Questions" class="mc-btn btn-style-1" id="clearQuestions">
					       </td>
					     <td colspan="3" align="right">
					        &nbsp;
					          <input type="button" value="Configure Test" class="mc-btn btn-style-1" id="configureTestID"/>
					     </td>
					   </tr>	


                    </tbody>
                </table>
                    <h3 style="color: black;background-color:  #6dbbff;font-size: 2px;"> &nbsp;</h3> 
                </div>
                </form>
            </div>
			</section>
            </div>
    <!-- END / COURSE CONCERN -->

   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>


<script type="text/javascript">
$(document).ready(function() {
	
	$("#clearQuestions").click(function(){
			var ccontextPath="${pageContext.request.contextPath}";
		 	var yesno=confirm("Are you sure want to delete all the questions from question basket.");	 
			 if(yesno) {
				  $("#deletequestionbasketform").submit();
			 }else{
				 alert("No");
			 }
	});
	//alert("good morning!");
	$("#uncheckAll").click(
		  	function() {
		  		    $("input[type='checkbox'][id='scbox']").each(function(){
		     			  $(this).removeAttr('checked'); 
		    				$("#totalSelectedQuestions").html(0);
		     			 //$("#totalPresent").html(0);
				    });	
		  	}
	);
	 $("#techName").change(function(){
		 $("#validationMessage").html("");
	 });
	 
	 $("#testName").change(function(){
		 $("#validationMessage").html("");
	 });	
	 
	 $("input[type='text'][id='testName']").blur(function(){
			var ccontextPath="${pageContext.request.contextPath}";
		 var techName=$("#techName").val();;
		 var testName=$("#testName").val();
		 if(techName=='Choose Technology'){
	 		 $("#validationMessage").html("Please select a technology name .");		
	 	  		$("#techName").focus();
	 	  		 return;
		 }
		 if(testName.length==0){
		 		 $("#validationMessage").html("Test Name cannot be empty.");		
		 	  	$("#testName").focus();
		 		 return;
		 }
		  console.log(")@)@)@)@)@)@)@)@)@)techName = "+techName);
		  console.log(")@)@)@)@)@)@)@)@)@)testName = "+testName);
		 $.getJSON(ccontextPath+"/action/check-tech-test", {techName:techName,testName:testName}, function(jsonResponse) {
				 console.log("_@)jsonResponse.status @) = "+jsonResponse.status);
			 	 if(jsonResponse.status=='exist') {
			 			//$("#testName").focus();
				 		 $("#validationMessage").html("Sorry this test \""+testName +"\" is already exist for tech "+techName+" .<br/>");	
				 		  $("#configureTestID").prop('disabled', true);
		 				// window.scrollTo(0, 0);
		 		 } 
		 });
	 }); 
	 $("input[type='text']").keyup(function(){
		 $("#validationMessage").html("");
		 $("#configureTestID").prop('disabled', false);
	 });	
  	 $("input[type='button'][id='configureTestID']").click(function() {
  		//validating the test name
			var techName=$("#techName").val();
			if(techName.length>0 && "Choose Technology"==techName){
					$("#validationMessage").html("Please select a technology.......");
					$("input[type='select'][name='techName']").focus();
					return;
			}
  		    //validating the test name
  			var testName=$("input[type='text'][name='testName']").val();
  			if(testName.length==0){
  					$("#validationMessage").html("Test Name cannot be blank.......");
  					$("input[type='text'][name='testName']").focus();
  					return;
  			}
  		  //validating the test validity
  			var validity=$("input[type='text'][name='validity']").val();
  			if(validity.length==0){
  					$("#validationMessage").html("Validity cannot be blank.......");
  					$("input[type='text'][name='validity']").focus();
  					return;
  			}
  			
  			//var NoOfQuestions=$("input[type='hidden'][name='NoOfQuestions']").val();
  			var NoOfQuestions=$("#NoOfQuestions").val();
  			var checked = $("input[id$='scbox']:checked").length;
  			
  			if(checked==0){
  				$("#validationMessage").html("Questions List cannot be blank for the configured test , please select questions from the bank.");
  				return;
  			}
  			$("#configureNewTestForm").submit();		
	  		//alert("good morning!");
	        /////////////////////////////////////////////////////////
			/////////////////////jQuery///////////////////////////////
  			//alert("configureTestID is configureTestID!");
	 });
});
</script>

<script type="text/javascript">

	function addQuestionsFromBank(){
// 		alert("#_#_#_#)");
$("input[type='hidden'][name='techName']").val($("#techName").val());
		$("input[type='hidden'][name='testName']").val($("#testName").val());
		$("input[type='hidden'][name='validity']").val($("#validity").val());
		$("input[type='hidden'][name='testDuration']").val($("#testDuration").val());
		$("input[type='hidden'][name='random']").val($("#random").val());
		$("#configuteTestForm").submit();		
	}

/* $(document).ready(function() {
	//alert("good morning!");
  	 $("input[type='button'][id$='configureTestID']").click(function() {
				    $("#configureTestID").submit();		 
	 });
});
	 */
	
	
	

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