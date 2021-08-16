<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${companyName} | Session Detail</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css" type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/treset.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/layout.css"
	type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/tstyle.css"
	type="text/css" media="all">
	
	<link href="${pageContext.request.contextPath}/css/timedropper.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.5.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cufon-yui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cufon-replace.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Molengo_400.font.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Expletus_Sans_400.font.js"></script>
	 <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datepicker.js"></script>


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!--   <link rel="stylesheet" href="/resources/demos/style.css"> -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/timedropper.js"></script>
<script>$( "#alarm" ).timeDropper();</script>

<script type="text/javascript">
 
 
 function loadTopicsByLanguageId(languageId){
	 var ccontextPath="${pageContext.request.contextPath}"
	  	  var planguage=languageId;
 		   $.getJSON(ccontextPath+"/action/findTopicsByLanguage",{language:planguage},function(jsonResponse) {
 			 	$("#topicList").empty();
 			 	var topicsData=jsonResponse.topicVOList;
 			   for(var i=0;i<topicsData.length;i++) {
 				 $('#topicList')
 			      .append($('<option>', { value : topicsData[i].tid })
 			      .text( topicsData[i].topic)); 
 			 	}
 		   });
 }
 
$(document).ready(function() {
	
/* 	$( "#starttime" ).timeDropper({format: 'H:mm'});
	$( "#endtime" ).timeDropper({format: 'H:mm'});
	$( "#endtime" ).change(function(){
		alert("_@_@_SS");
	}); */
    //$("#sessiondate").datepicker();
		loadTopicsByLanguageId(1);
		$("#technology").change(function() {
			  var planguage=$(this).val();
			  loadTopicsByLanguageId(planguage);
		});	
		
		 $("#addTopics").click(function(){
			var selectedTopic=$("#topicList").val();	
			 $("#topics").append(selectedTopic+",");
		 });		

		 
		// var languageId="${technologyList['Core Java']}";
		 ///alert("languageId = "+languageId);
		 loadTopicsByLanguageId(1);
		$("#technologyId").change(function() {
			  var planguage=$(this).val();
			  loadTopicsByLanguageId(planguage);
		});	
		
		
	// var batchName="${batchList.get(0)}";
	 //loadConsutantByBatchName(batchName);
		
  	 $("#batchName").click(function() {
  		var pbatchName=$("#batchName").val();
  		loadConsutantByBatchName(pbatchName);
	 });
  	 
  	 
  	$("#uploadAssignment").click(function(){
 		
		var sesdate=$("#sessiondate").val();
		var topic=$("#topics").val();
		var checkbox1=$("#check").val();
		var starttime=$("#starttime").val();
		var endtime=$("#endtime").val();
		
		if(sesdate==""){
			$("#sessionmessage").fadeIn();
			//alert("please enter sesseion date ! ");
			setTimeout(function() {
				        $('#sessionmessage').fadeOut();}, 2000);
		}
		
		else if(starttime>=endtime)
			{
			$("#setimemessage").fadeIn();
 			setTimeout(function() {
 		        $('#setimemessage').fadeOut();}, 2000);
			}
		
		else if(topic==""){
 				$("#topicsmessage").fadeIn();
				setTimeout(function() {
					        $('#topicsmessage').fadeOut();}, 2000);
 			}

		else  if($("input:checked").length == 0){
		   $("#checkedbox").fadeIn();
		   setTimeout(function() {
		        $('#checkedbox').fadeOut();}, 2000);
	    }
		else
			{
			$("#submitform").submit();
			}
});

});

function loadConsutantByBatchName(pbatchName){
	   var ccontextPath="${pageContext.request.contextPath}"
			var tableRemoteData="";
	   		$("#batchNameId").html(pbatchName);
 		   $.getJSON(ccontextPath+"/action/findConsultantsByBatch",{batchName:pbatchName},function(jsonResponse){
//  			 tableRemoteData=tableRemoteData+'<tr height="30px" style="color: black;background-color:pink;vertical-align: middle;" align="center">';
// 	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>Sno.</b></td>';
// 	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>EmpId</b></td>';
// 	  			tableRemoteData=tableRemoteData+'<td width="300px"><b>Name</b></td>';
// 	  			tableRemoteData=tableRemoteData+'<td><b>Email</b></td>';
// 	  			tableRemoteData=tableRemoteData+'<td width="60px"><b>Photo</b></td>';
// 	  			tableRemoteData=tableRemoteData+'<td width="120px">';
// 	  			tableRemoteData=tableRemoteData+'<b>Action</b></td>';
// 	  			tableRemoteData=tableRemoteData+'</tr>';
	  			
 	  		for(var i=0;i<jsonResponse.length;i++){
			  			tableRemoteData=tableRemoteData+'<tr height="25px" style="color: black">';
			  			tableRemoteData=tableRemoteData+'<td>'+(i+1)+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].empid+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].name+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].email+'</td>';
			  			var imageURL=ccontextPath+'/action/findConsultantImage?userid='+jsonResponse[i].userid;
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><img style="border-radius: 25px;" src="'+imageURL+'" alt=""  width="50" height="50"/></td>';
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;">&nbsp;<input type="checkbox" name="consultantId" style="background-color:yellow;" checked="checked" value="'+jsonResponse[i].empid+'"/></td>';
						tableRemoteData=tableRemoteData+' </tr>';
 		  		}	 
 	  			$("#totalRecords").html(jsonResponse.length);
				$("#tableContent").html(tableRemoteData);
 		   });
}

</script>	
</head>	
	
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
      <%@include file="theader.jsp"%>
  </div>
</div>

    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
         <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
        <div class="container">
				
				<form:form  method="post" commandName="assignmentVO" action="${pageContext.request.contextPath}/action/addAssignmentToConsultant" id="submitform">
				
            <div class="title-ct">
                
                 <br><img src="${pageContext.request.contextPath}/images/configure.png" width="25" /> - <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Add Session Detail Page</span>
            </div>
            
             	<table class="table table-bordered" style="width: 60%;">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <span for="sel1" style="font-family: 'Lato', sans-serif;font-size: 14px;">Select Batch:</span>
								 &nbsp;&nbsp;
								 <select class="form-control" name="batch" id="batchName" style="width: 300px;display: inline;">
								 		<c:forEach items="${batchList}" var="item">
								 		<option  ${item==currentBatch?'selected':''}>${item}</option>
								 		</c:forEach>
								 </select>
					     </td>
					        <td colspan="1" align="left" valign="bottom" >
					     </td>
					   </tr>
					  </tbody>
					  
					 </table>
					 
					 	 
					 <table class="table table-bordered" style="width:60%;">
      			 	 <tbody>
					   
					    <tr height="25px" >
					     <td colspan="1" align="left">
					        <span for="technology" style="font-family: 'Lato', sans-serif;font-size: 14px;">Technology: &nbsp;&nbsp;</span>
      										<form:select path="technologyId" class="form-control" style="width: 200px;display: inline;">
      										<form:options items="${technologyList}"/>
      										</form:select>
      										
      										
					     </td>
					       <td colspan="2" align="left">
					        <span for="topic" style="font-family: 'Lato', sans-serif;font-size: 14px;">Topics: &nbsp;&nbsp;</span>
      										<select id="topicList" name="topicId"class="form-control" style="width: 400px;display: inline;">
      										</select>
					     </td>
					   </tr>
					   
					     
					    <tr height="25px" >
					     <td colspan="3" align="left">
					     	<span for="assignment" style="font-family: 'Lato', sans-serif;font-size: 14px;">Assignment: &nbsp;&nbsp;</span><br/><br/>
      						 <textarea rows="2" name="assigment" id="topics" class="form-control"  ></textarea>
      						 <span id="topicsmessage" style="display:none;font-size:16px; color:red; font-weight: 600;">
      										 Please Add your Assignment!</span>
      				     </td>
					   </tr>
					  </tbody>
					 </table>
					 <img src="${pageContext.request.contextPath}/images/users.png" style="height: 34px;"/> 
					    <span style="font-family: 'Lato', sans-serif;font-size: 14px;">User(s) List @ Batch Name  : <span id="batchNameId"></span></span>
					     <span id="checkedbox" style="display:none;font-size:16px;color:red; font-weight: 600;">Please select at least one Check box!</span>
					    <div style="float: right;">
                           <img src="../images/favicon.ico" height="30px">   Total Records : <b><span id="totalRecords">${fn:length(consultantList)}</span></b>
                             </div> 
            
            

            <div class="table-student-submission">
            
                             
                              <div class="wrapper">
                <hr style="color: black"/> 
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
                 <div id="courseCoveredStatusContent">  
                 
                 <table class="table  table-bordered" style="width: 100%">
                 <tbody id="tableContent">
                    <thead class="theader">
      			 <tr style="background-color: #b5e8fd;;color:black;">
      			          <td class="score" style="width:20%">Sno</td>
                            <td class="submit-date" style="width:20%">EmpId</td>
                            <td class="author" style="width:20%">Name</td>
                            <td class="submit-date" style="width:20%">Email</td>
<!--                              <td class="submit-date" style="width:15%">Total Marks</td>  -->
                            	<td class="submit-date" style="width:20%">Photo</td>
                             <td class="submit-date" style="width:15%">Action</td>
<!--                               <td class="submit-date" style="width:20%">Marks Obtained</td> -->
                         </tr>
<!--                 <table class="table table-bordered"> -->
<!--                		<tbody id="tableContent"> -->
<!--                     <thead class="theader"> -->
<!--                         <tr style="background-color: #1192ea;"> -->
<!--                          <th class="submissions" style="text-align: center;">Sno</th> -->
<!--                             <th class="submissions" style="width: 250px; text-align: center;">EmpId</th> -->
<!--                             <th class="author" style="text-align: center;">Name</th> -->
<!--                             <th class="author" style="text-align: center;">Email</th> -->
<!--                             <th class="score" style="text-align: center;">Photo</th> -->
<!--                             <th class="submit-date">Action</th> -->
<!--                         </tr> -->
                           
                    </thead>
                      <c:forEach items="${consultantList}" var="item" varStatus="pk">  	
						<tr style="color: black">
			  			<td>${pk.count}</td>
			  			<td>&nbsp;${item.empid}</td>
			  			<td>&nbsp;${item.name}</td>
			  			<td>&nbsp;${item.email}</td>
			  			<td style="text-align:center;"><img style="border-radius: 20px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${item.userid}" alt=""  width="40" height="40"/></td>
			  			<td style="text-align: center;">&nbsp;<input type="checkbox" name="consultantId" style="background-color:yellow;" value="${item.empid}"/></td>
						</tr>
						</c:forEach>

                     
                       <tr height="25px" style="color: black">
					      <td bgcolor="white">&nbsp;</td>
					        <td bgcolor="white">&nbsp;</td>
					          <td bgcolor="white">&nbsp;</td>
					            <td bgcolor="white">&nbsp;</td>
					              <td bgcolor="white">&nbsp;</td>
					                <td bgcolor="white">&nbsp;</td>
					     </tr>
					    <tr height="30px" style="vertical-align: middle;" align="center">
					       <td bgcolor="white">&nbsp;</td>
					         <td bgcolor="white">&nbsp;</td>
					           <td bgcolor="white">&nbsp;</td>
					             <td bgcolor="white">&nbsp;</td>
					               <td bgcolor="white">&nbsp;</td>
					                 <td bgcolor="white">&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					       <td bgcolor="white">&nbsp;</td>
					         <td bgcolor="white">&nbsp;</td>
					           <td bgcolor="white">&nbsp;</td>
					             <td bgcolor="white">&nbsp;</td>
					               <td bgcolor="white">&nbsp;</td>
					                 <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					       <td bgcolor="white">&nbsp;</td>
					         <td bgcolor="white">&nbsp;</td>
					           <td bgcolor="white">&nbsp;</td>
					             <td bgcolor="white">&nbsp;</td>
					               <td bgcolor="white">&nbsp;</td>
					                 <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td bgcolor="white">&nbsp;</td>
					       <td bgcolor="white">&nbsp;</td>
					         <td bgcolor="white">&nbsp;</td>
					           <td bgcolor="white">&nbsp;</td>
					             <td bgcolor="white">&nbsp;</td>
					               <td bgcolor="white">&nbsp;</td>
					     </tr>
					     
					     </tbody>
                </table>
                 <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Comments:-</span> 	
					 <table class="table table-bordered" style="width: 60%;">
					   <tr height="30px" style="vertical-align: middle;" align="center">
					      <td><textarea rows="1" name="comments" id="comments" class="form-control" >NA</textarea></td>
					     </tr>
					 </table>
					<input type="button" value="upload Assignment"  class="btn btn-primary btn-md" id="uploadAssignment"/>
                </div>
            </div>
          
		</div>
		<button type="button" class="btn btn-primary btn-md" id="addSchedule" style="float: right;">Add Schedule Detail</button>
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