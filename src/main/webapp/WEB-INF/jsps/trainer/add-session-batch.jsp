<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${companyName} - Add Session Detail Page</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon-96x96.png" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <link href="${pageContext.request.contextPath}/css/timedropper.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
   
   <script type="text/javascript">
 
/*  function loadTopicsByLanguageId(languageId){
	 var ccontextPath="${pageContext.request.contextPath}"
	  	  var planguage=languageId;
 		   $.getJSON(ccontextPath+"/action/findTopicsByLanguage",{language:planguage},function(jsonResponse) {
 			 	$("#topicList").empty();
 			 	var topicsData=jsonResponse;
 			   for(var i=0;i<topicsData.length;i++) {
 				 $('#topicList')
 			      .append($('<option>', { value : topicsData[i].topic })
 			      .text( topicsData[i].topic)); 
 			 	}
 		   });
 } */
 

function loadConsutantByBatchName(pbatchName){
	   var ccontextPath="${pageContext.request.contextPath}"
			var tableRemoteData="";
	   		$("#batchNameId").html(pbatchName);
 		   $.getJSON(ccontextPath+"/action/findConsultantsByBatch",{batchName:pbatchName},function(jsonResponse){
 			 tableRemoteData=tableRemoteData+'<tr height="30px" style="color: white;background-color:#607D8B;vertical-align: middle;" align="center">';
	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>Sno.</b></td>';
	  	  		tableRemoteData=tableRemoteData+'<td width="10px"><b>EmpId</b></td>';
	  			tableRemoteData=tableRemoteData+'<td width="300px"><b>Name</b></td>';
	  			tableRemoteData=tableRemoteData+'<td><b>Email</b></td>';
	  			tableRemoteData=tableRemoteData+'<td width="60px"><b>Photo</b></td>';
	  			tableRemoteData=tableRemoteData+'<td width="120px">';
	  			tableRemoteData=tableRemoteData+'<b>Action</b></td>';
	  			tableRemoteData=tableRemoteData+'</tr>';
	  			
 	  		for(var i=0;i<jsonResponse.length;i++){
			  			tableRemoteData=tableRemoteData+'<tr height="25px" style="color: black">';
			  			tableRemoteData=tableRemoteData+'<td>'+(i+1)+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].empid+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].name+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].email+'</td>';
			  			var imageURL=ccontextPath+'/action/findConsultantImage?userid='+jsonResponse[i].userid;
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><img style="border-radius: 25px;" src="'+imageURL+'" alt=""  width="50" height="50"/></td>';
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;">&nbsp;<input type="checkbox" name="pempids" style="background-color:yellow;" value="'+jsonResponse[i].empid+'"  checked="checked"  onclick="pchecked(this)" /></td>';
						tableRemoteData=tableRemoteData+' </tr>';
 		  		}	 
 	  			$("#totalRecords").html(jsonResponse.length);
				$("#tableContent").html(tableRemoteData);
 		   });
}

</script>
      
    <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
</style>
</head>
<body>
<div>
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
        <!-- COURSE CONCERN -->
 
 <section style="padding-top: 0px;padding-bottom:0px;background-color: #eee;" id="quizz-intro-section" class="quizz-intro-section learn-section">
      	<hr/>
        <div class="container" style="background-color: white;">
               	  <span>	
               	   <img src="${pageContext.request.contextPath}/images/lock-unlock-bar.png" style="height: 40px;"/>	
               		 	<h3 style="font-size: 18px;">Add Session Detail Page :</h3>
						 </span>
            <form:form  method="post" commandName="trainingSessionsDetailVO" action="${pageContext.request.contextPath}/action/add-session-detail" id="submitform">
                <hr style="color: black"/> 
              	     <span style="color: blue;font-size: 16px;" id="AppMessage">
								 ${ApplicationMessage}
						</span>
        	<table class="table table-bordered">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					           <label for="sel1">Select Batch:</label>
								 &nbsp;&nbsp;
								 <select class="form-control" name="batch" id="batchName" style="width: 300px;display: inline;">
								 		<c:forEach items="${batchList}" var="item">
								 		<option  ${item==currentBatch?'selected':''}>${item}</option>
								 		</c:forEach>
								 </select>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								 <label for="session date">Session Date: &nbsp;&nbsp;</label>
      										<input type="text" id="sessiondate" name="sessiondate" class="form-control" style="width: 200px;display: inline;" value="${currentDate}"/>
      									 &nbsp;&nbsp;&nbsp;&nbsp;	(MM/dd/yyyy)
      										 <span id="sessionmessage" style="display:none;font-size:16px;color:red; font-weight: 600;">
      										 Please Select Your Session Date!</span>
					     </td>
					        <td colspan="1" align="left" valign="bottom" >
					     </td>
					   </tr>
					  </tbody>
					  
					 </table>
					 
					 <table class="table table-bordered">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" width="350px;">
					        <label for="start time">Start Time: &nbsp;&nbsp;</label>
      										<input type="text" id="starttime"  name="starttime" class="form-control" style="width: 200px;display: inline;"/>
					     </td>
					        <td colspan="1" align="left">
					         <label for="end time">End Time: &nbsp;&nbsp;</label>
      										<input type="text" name="endtime" id="endtime" class="form-control"  style="width: 200px;display: inline;"/>
      										<div>
      										<span id="setimemessage" style="display:none;font-size:16px; color:red; font-weight: 600; ">
      										 End time must be greater than Start time!</span></div>
					     </td>
					     <td> <label for="session date">Total Duration: &nbsp;&nbsp;</label>
      										<input type="text" id="timeduration" value="0" name="timeduration" class="form-control" style="width:100px;display:inline;font-family:'Lato', sans-serif;font-size: 14px;" readonly="readonly"/> (Minutes)</td>
					   </tr>
					   
					   
					     <tr height="10px" >
					       <td colspan="3" align="left">
					        &nbsp;
					     </td>
					   </tr>
					    <tr height="25px" >
					     <td colspan="1" align="left">
					        <label for="start time">Technology: &nbsp;&nbsp;</label>
      										<form:select path="technology" class="form-control" style="width: 200px;display: inline;">
      										<form:options items="${technologyList}"/>
      										</form:select>
					     </td>
					       <td colspan="2" align="left">
					        <label for="start time">Topics: &nbsp;&nbsp;</label>
      										<select id="topicList" class="form-control" style="width: 400px;display: inline;">
      										</select>
      										 <input type="button" value="Add Topic" class="mc-btn btn-style-1"  id="addTopics" style="margin-left: 50px;margin-top: -5px;font-family: 'Lato', sans-serif;font-size: 14px;"/>
					     </td>
					   </tr>
					   
					     
					    <tr height="25px" >
					     <td colspan="3" align="left">
					         <label for="topicCovered">Topics Covered: &nbsp;&nbsp;</label>
      						 <textarea rows="1" name="topics" id="topics" class="form-control"  style="font-size: 18;font-family: rockwell"></textarea>
      						 <span id="topicsmessage" style="display:none;font-size:16px; color:red; font-weight: 600;">
      										 Please Add your Topics!</span>
      				     </td>
					   </tr>
					  </tbody>
					  
					 </table>

            <div class="table-student-submission">
            
					 <img src="${pageContext.request.contextPath}/images/users.png" width="25px;"/> 
					    <span style="font-weight: bold;">Consultant(s) List : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Batch Name  : <span id="batchNameId"></span></span>
					     <span id="checkedbox" style="display:none;font-size:16px;color:red; font-weight: 600;">Please select at least one Check box!</span>
					    <div style="float: right;">
                           <img src="${pageContext.request.contextPath}/images/favicon.ico" width="25px;"><span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Records :</span> <b><span id="totalRecords">${fn:length(consultantList)}</span></b>
                             </div>
                             
                              <div class="wrapper">
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
					<hr/>		
				<table class="table  table-bordered" width="100%" id="tableContent">
      			     <tr style="background-color: #607D8B;color:white;">
      			          <td class="score" style="width:5%">SNo </td>
                            <td class="submit-date" style="width:5%">EmpId</td>
                            <td class="author" style="width:30%">Name</td>
                            <td class="submit-date" style="width:40%">Email</td>
                             <td class="submit-date" style="width:15%">Photo</td> 
                            	<td class="submit-date" style="width:20%">Action</td>
                            	
<!--                              <td class="submit-date" style="width:15%">Test Name</td> -->
<!--                               <td class="submit-date" style="width:20%">Marks Obtained</td> -->
                         </tr>
                             
<!--           		<table class="table table-bordered"  id="theader"> -->
<!-- 						 <tbody id="tableContent">					    -->
<!-- 					     <tr height="30px" style="color: white;background-color:#607D8B;vertical-align: middle;" align="center"> -->
<!-- 					     <td width="10px"><b>Sno.</b></td> -->
<!-- 					       <td width="10px"><b>EmpId.</b></td> -->
<!-- 					   	   <td width="300px"><b>Name</b></td> -->
<!-- 					   	   <td><b>Email</b></td> -->
<!-- 					   	    <td><b>Photo</b></td> -->
<!-- 					   	    <td> -->
<!-- 					   	    <b>Action</b></td> -->
<!-- 					     </tr> -->
					    <c:forEach items="${consultantList}" var="item" varStatus="pk">  	
						<tr style="color: black">
			  			<td>${pk.count}</td>
			  			<td>&nbsp;${item.empid}</td>
			  			<td>&nbsp;${item.name}</td>
			  			<td>&nbsp;${item.email}</td>
			  			<td style="text-align:center;"><img style="border-radius: 20px;" src="${pageContext.request.contextPath}/action/findConsultantImage?userid=${item.userid}" alt=""  width="40" height="40"/></td>
			  			<td style="text-align: center;">&nbsp;<input type="checkbox" name="pempids" style="background-color:yellow;" value="${item.empid}" checked="checked"/></td>
						</tr>
						</c:forEach>
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
                 <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Comments:-</span> 	
					 <table class="table table-bordered">
					   <tr height="30px" style="vertical-align: middle;" align="center">
					      <td><textarea rows="1" name="comments" id="comments" class="form-control">NA</textarea></td>
					     </tr>
					 </table>
					<input type="button" value="Upload Session Detail"  class="mc-btn btn-style-1" id="addSessionDetailBtn"/>
            </div>
</div></form:form>
            </div>
    </section>

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
  <script src="${pageContext.request.contextPath}/js/timedropper.js"></script>
<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

<script type="text/javascript">

function loadTopicsByLanguageId(languageId) {
	 var ccontextPath="${pageContext.request.contextPath}"
	  	   var planguage=languageId;
	       if("--Select--"==planguage){
	    		 $("#topicList").empty();
	    		  $("#AppMessage").html("Please select technology to add a topic.");
	    		return;
	       }
		   $.getJSON(ccontextPath+"/action/findTopicsByLanguage",{language:planguage},function(jsonResponse) {
			 	$("#topicList").empty();
			 	var topicsData=jsonResponse;
			   for(var i=0;i<topicsData.length;i++) {
				 $('#topicList')
			      .append($('<option>', { value : topicsData[i].name })
			      .text( topicsData[i].name)); 
			 	}
		   });
}

function pchecked(t){
	var count=0;
    if (t.checked) {
    	count=$("#totalRecords").html();
    	count=parseInt(count)+1; 
    }else{
    	count=$("#totalRecords").html();
    	count=parseInt(count)-1; 
    }
    $("#totalRecords").html(count);
    $("#AppMessage").html("");
    $("#selectAllUserID").removeAttr('checked');
}


$(document).ready(function() {
	$("#sessiondate").change(function(){
		 $("#AppMessage").html("");
	});
	
	$("#addSessionDetailBtn").click(function() {
		var sessiondate=$("#sessiondate").val();
		if(sessiondate.length==0) {
			    $("#AppMessage").html("Please select session date..");
			    $("#sessiondate").focus();
			    return;
		}
		
		var timeduration=$("#timeduration").val();
		if(timeduration<=0)  {
			     $("#AppMessage").html("Start time and end time difference should not be less than 1 minute.");
			    return;
		}
		
		var topics=$("#topics").val();
		if(topics.length==0){
			    $("#AppMessage").html("Please add at least one topic for the session to be added...");
			    return;
		}
		
		var totalRecords=$("#totalRecords").html();
		if(totalRecords==0){
			    	  $("#AppMessage").html("Please select at least one  consultant from the selected batch list.");
			  	 return;
		}
		$("#submitform").submit();
	});
// 	alert("_@)@)loading-@)@)");
	$( "#starttime" ).timeDropper({format: 'H:mm'});
	$( "#endtime" ).timeDropper({format: 'H:mm'});
	$( "#endtime" ).change(function(){
	});
	 $("#sessiondate").datepicker();
	 $("#addTopics").click(function(){
			var selectedTopic=$("#topicList").val();	
			 $("#topics").append(selectedTopic+",");
			 $("#AppMessage").html("");
		 });
	 
	 loadTopicsByLanguageId(1);
		$("#technology").change(function() {
			  var planguage=$(this).val();
			  loadTopicsByLanguageId(planguage);
		});	
		
	$ (document).ready(function(){
			var date_input=$('#sessiondate'); //our date input has the name "date"
			///var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'mm/dd/yyyy',
				todayHighlight: true,
				autoclose: true,
			})
		})
});


		
  	 $("#batchName").click(function() {
  			var pbatchName=$("#batchName").val();
  			loadConsutantByBatchName(pbatchName);
	 });
  	 

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