<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
    <title>${companyName} - Consultant Screening Interview</title>

 <script type="text/javascript">
$(document).ready(function() {
	$("#finishInterview").click(function(e){
			var tc = $(this).closest("form").find("input[id='finishInterview']").val();
			$("#operation").val("finalsubmit");
	});
	
	$('#consultantQuestionAnswerForm').submit(function(e) {
		//var tc = $(this).closest("form").find("input[id='nextQuestion']").val();
		//alert("tc = "+tc);
		var frm = $('#consultantQuestionAnswerForm');
		e.preventDefault();
	    var data = {}
	    var Form = this;
	    //Gather Data also remove undefined keys(buttons)
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
	   var operation=$("#operation").val();
	   var ccontextPath="${pageContext.request.contextPath}"
	   var saction=ccontextPath+"/action/submitConsultantInterview";
	    if("next"==operation){
	    	saction=frm.attr('action');
	    }
   $.ajax({
        contentType : 'application/json; charset=utf-8',
        type: frm.attr('method'),
        url: saction,
        dataType : 'json',
        data : JSON.stringify(data),
        success : function(callback){
            $("#ApplicationMessage").html(callback.message);
            $("#questionText").val("");
            $("#answer").val("");
            $("#comment").val("");
            $('#rating option[value=1]').attr("selected", "selected");
            $('#complexity option[value="LOWER"]').attr("selected", "selected");
            var ccount=$("#questionNumber").html();
            $("#questionNumber").html(parseInt(ccount)+1);
        },
        error : function(){
            $(this).html("Error!");
        }
    });
	});
	
	/* $("#nextQuestion").click(function(){
			alert("_@_@Cool is cool....")	;	
	}); */
	
	$("#technology").change(function() {
		 	  var ccontextPath="${pageContext.request.contextPath}"
		  		var planguage=$(this).val();
	  		   $.getJSON(ccontextPath+"/action/findTopicsByLanguage",{language:planguage},function(jsonResponse) {
	  			 	$("#topic").empty();
	  			 	var topicsData=jsonResponse.topicVOList;
	  			   for(var i=0;i<topicsData.length;i++) {
	  				 $('#topic')
	  			      .append($('<option>', { value : topicsData[i].topic })
	  			      .text( topicsData[i].topic)); 
	  			 	}
	  		   });
	});
});
</script>

<!--[if lt IE 9]>
<script type="text/javascript" src="js/html5.js"></script>
<style type="text/css">.bg, .box2{behavior:url("js/PIE.htc");}</style>
<![endif]-->
</head>
<body id="page-top">

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
    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
	 
    <!-- COURSE CONCERN -->
    <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">

            <div class="title-ct">
                
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/configure.png" width="25px;"/> - <b> Consultant Interview Page</b></h3> 
            </div>
            
            
            <table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 14px;">Select Batch:</label>
								 &nbsp;&nbsp;
								  <select class="form-control" name="batchName" id="batchName" style="width: 300px;display: inline;">
								 	<option>Select Batch</option>
								 		<c:forEach items="${batchList}" var="item">
								 			<option>${item}</option>
								 		</c:forEach>
								 </select>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					     </td>
					        <td colspan="1" align="left" valign="bottom" >
					     </td>
					   </tr>
					  </tbody>
					  
					 </table>
 <hr style="color: blue"/>
					   <img src="${pageContext.request.contextPath}/images/users.png" style="height: 34px;"/> 
					    <span style="font-family: 'Lato', sans-serif;font-size: 14px;">User(s) List:-</span>
					    <div style="float: right;">
                          <img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px" style="font-family: 'Lato', sans-serif;font-size: 14px;">   Total Records : <b><span id="totalRecords">${fn:length(allTechs)}</span></b>
                             </div> 
            <div class="table-student-submission">
            	<table class="table table-bordered" width="100%" id="theader">
						 <tbody id="tableContent">					   
					     <tr height="30px" style="color: white;background-color:#1192ea;;vertical-align: middle;" align="left">
					     <td width="10px"><b>Sno.</b></td>
					       <td width="150px;"><b>Consultant Id.</b></td>
					   	   <td width="300px"><b>Name</b></td>
					   	   <td><b>Email</b></td>
					   	    <td><b>Photo</b></td>
					   	    <td>
					   	    <b>Action</b></td>
					     </tr>
					      	
					      <tr height="25px" style="color: black">
					     <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td align="center">
							</td>
							 <td align="center">
							</td>
							 <td align="center">
							</td>
					     </tr>
					    <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					     </tr>
						</tbody>     
					</table>  
            </div>

            
        </div>
    </section>
			  <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
</body>
</html>