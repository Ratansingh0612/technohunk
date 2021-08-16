<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Add Topics</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.2.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

 
 <script type="text/javascript">
 var ccontextPath="${pageContext.request.contextPath}";
 function deleteTopic(tid){
	  $.getJSON(ccontextPath+"/action/deleteTopicByTid",{tid:tid},function(jsonResponse) {
		  if(jsonResponse.status=="success") {
			  $("#"+tid).closest("tr").hide();
			  var totalRecords= $("#totalRecords").html(); 
			  totalRecords=parseInt(totalRecords)-1;
			  $("#totalRecords").html(totalRecords); 
			  $("#applicationMessage").html("Topic with "+tid+" is deleted successfully.");
		  }
	  });
 }
 
 function convertJsonDateString(jsonDate) {  
	   var shortDate = null;    
	   if (jsonDate) {  
	       var regex = /-?\d+/;  
	       var matches = regex.exec(jsonDate);  
	       var dt = new Date(parseInt(matches[0]));  
	       var month = dt.getMonth() + 1;  
	       var monthString = month > 9 ? month : '0' + month;  
	       var day = dt.getDate();  
	       var dayString = day > 9 ? day : '0' + day;  
	       var year = dt.getFullYear();  
	       shortDate = dayString + '-' + monthString + '-' + year;  
	}  
	return shortDate;  
	}
 
 function loadTopicsByLanguageId(languageId){
	     $("#applicationMessage").html("");
	     $(".alert").hide();
		 var idid="#language option[value='"+languageId+"']";	
		  var selecteText=$(idid).text();
		 if(selecteText.length==0){
			  $(".alert").show();
		 		 $("#applicationMessage").html("Please select a technology to add a topic.");
		 		  var tableContents="";
		 		 tableContents=tableContents+'<tr height="30px" style="color: white;background-color:#607D8B;vertical-align: middle;" align="center">';
				  tableContents=tableContents+'<td width="10px"><b>Sno.</b></td>';
				  tableContents=tableContents+' <td width="300px" align="left"><b>Topic Name</b></td>';
				  tableContents=tableContents+'<td><b>Description</b></td>';
				  tableContents=tableContents+'<td width="150px"  align="center"><b>Doe</b></td><td> <b>OP</b></td>';
				  tableContents=tableContents+ '</tr>';
				  tableContents=tableContents+'<tr height="30px" style="color: black;" align="center">';
				  tableContents=tableContents+'<td width="10px">&nbsp;</td>';
				  tableContents=tableContents+' <td width="300px" align="left">&nbsp;</td>';
				  tableContents=tableContents+'<td>&nbsp;</td>';
				  tableContents=tableContents+'<td width="150px"  align="center">&nbsp;</td><td>&nbsp;</td>';
				  tableContents=tableContents+ '</tr>';
				  tableContents=tableContents+'<tr height="30px" style="color: black;" align="center">';
				  tableContents=tableContents+'<td width="10px">&nbsp;</td>';
				  tableContents=tableContents+' <td width="300px" align="left">&nbsp;</td>';
				  tableContents=tableContents+'<td>&nbsp;</td>';
				  tableContents=tableContents+'<td width="150px"  align="center">&nbsp;</td><td>&nbsp;</td>';
				  tableContents=tableContents+ '</tr>';
				  tableContents=tableContents+'<tr height="30px" style="color: black;" align="center">';
				  tableContents=tableContents+'<td width="10px">&nbsp;</td>';
				  tableContents=tableContents+' <td width="300px" align="left">&nbsp;</td>';
				  tableContents=tableContents+'<td>&nbsp;</td>';
				  tableContents=tableContents+'<td width="150px"  align="center">&nbsp;</td><td>&nbsp;</td>';
				  tableContents=tableContents+ '</tr>';
				  $("#totalRecords").html("0"); 
				  $("#selectedTechName").html(selecteText);
		 		 $("#tableContent").html(tableContents);
			  return;
		 }
		  $("#selectedTechName").html(selecteText);
	  	  var planguage=languageId;
	 	  var tableContents="";
 		   $.getJSON(ccontextPath+"/action/findTopicsByLanguage",{language:planguage},function(jsonResponse) {
 			 	///$("#topicList").empty();
 			 	var topicsData=jsonResponse;
 			 	 if(topicsData.length==0) {
 			 		  $(".alert").show();
 			 		 $("#applicationMessage").html("No topic exists for selected technology "+selecteText);
 			 		 return;
 			 	 }
 			 	 tableContents=tableContents+'<tr height="30px" style="color: white;background-color:#013648;vertical-align: middle;" align="center">';
				  tableContents=tableContents+'<td width="10px"><b>Sno.</b></td>';
				  tableContents=tableContents+' <td width="300px" align="left"><b>Topic Name</b></td>';
				  tableContents=tableContents+'<td><b>Description</b></td>';
				  tableContents=tableContents+'<td width="150px"  align="center"><b>Doe</b></td><td> <b>OP</b></td>';
				  tableContents=tableContents+ '</tr>';
 			   for(var i=0;i<topicsData.length;i++) {
 				  	  var tid=topicsData[i].topic_id;
 				 	 tableContents=tableContents+' <tr height="25px" style="color: black" id="'+tid+'">';
 				 	 tableContents=tableContents+'<td><b>'+(i+1)+'.</b></td>';
 				 	 tableContents=tableContents+' <td>&nbsp;'+topicsData[i].name+'</td>';
 				 	 tableContents=tableContents+'<td>&nbsp;'+topicsData[i].description+'</td>';
 				 	tableContents=tableContents+'<td align="center">&nbsp;'+convertJsonDateString(topicsData[i].lastUpdate)+'</td>';
 				 	 tableContents=tableContents+' <td align="center">';
 				 	 tableContents=tableContents+' <a href=javascript:deleteTopic("'+tid+'")   id="'+tid+'">';
 				 	 tableContents=tableContents+' <img alt="" src="${pageContext.request.contextPath}/images/close.png"/>';
 				 	 tableContents=tableContents+' </a>';
 				 	tableContents=tableContents+' / ';
 					 tableContents=tableContents+' <img alt="" src="${pageContext.request.contextPath}/images/edit.png"/>';
 				 	 tableContents=tableContents+' </td>';
 				 	 tableContents=tableContents+' </tr>';
 			 	}
 			   $("#totalRecords").html(topicsData.length); 
 			   $("#tableContent").html(tableContents);
 		   });
 }
 
$(document).ready(function() {
		$(".alert").hide();
		//alert(techs);
		$("#language").change(function(){
			  var planguage=$(this).val();
			  loadTopicsByLanguageId(planguage);
		});
		
  	 $("input[type='button'][id='addTopic']").click(function() {
			  var selectedTech=$("#language").val();
			  $("#applicationMessage").html("");
			   $(".alert").hide();
			  if("--Select--"==selectedTech){
				    $(".alert").show();
				    $("#applicationMessage").html("Please selected technology before adding topic.");
				    return;
			  }
			  var techName=$('#language option:selected').text();
			  //alert(techName);
				$("#topicName").val("");
		 		$("#description").val("");
			    $("#techId").val(selectedTech);
			  $("#ptechName").html(techName);
			  $("#addTopicModel").modal("show");
	 });
  	 
  	 
  	 $("input[type='text'][id='topicName']").keyup(function(){
  	  		 $("#ErrorMessage").html("");
  	 });
 	 $("input[type='text'][id='description']").keyup(function(){
	  		 $("#ErrorMessage").html("");
	 });
  	 
	 $("input[type='button'][id='addNewTopic']").click(function() {
		 		var topicName=$("#topicName").val();
		 		var description=$("#description").val();
		 		  if(topicName.length==0){
					    $("#ErrorMessage").html("Topic Name cannot be empty.");
					    $("#topicName").focus();
					    return;
				  }
		 		 if(description.length==0){
					    $("#ErrorMessage").html("Description  cannot be empty.");
					    $("#description").focus();
					    return;
				  }
		 		var contextPath="${pageContext.request.contextPath}";
				$.ajax({url:contextPath+"/action/addTopic", type: 'POST',data:$("#addTopicModelForm").serialize(),success:function(jsonData) {  //data= this.responseText
					//data is JavaScript object against JSON response coming fromm the server
						console.log(jsonData);
						if(jsonData.status=='success') {
					    	$("#addTopicModel").modal("hide");
					    	$("#applicationMessage").html(jsonData.message);	
					    	  $(".alert").show();
					    	//adding new row
					    	 var tableContents="";
					    	 var today = new Date();
					    	 var dd = today.getDate();
					    	 var mm = today.getMonth()+1; //January is 0!
					    	 var yyyy = today.getFullYear();
					    	 if(dd<10){
					    	     dd='0'+dd;
					    	 } 
					    	 if(mm<10){
					    	     mm='0'+mm;
					    	 } 
					    	  var date = dd+'-'+mm+'-'+yyyy;
					    	  //document.getElementById("DATE").value = today;
					    	  var totalRecord=$("#totalRecords").html();
					    	  var nextNo=parseInt(totalRecord)+1;
					    	  tableContents=tableContents+' <tr height="25px" style="color: black">';
		 				 	  tableContents=tableContents+'<td><b>'+nextNo+'.</b></td>';
		 				 	  tableContents=tableContents+' <td>&nbsp;'+topicName+'</td>';
		 				 	  tableContents=tableContents+'<td>&nbsp;'+description+'</td>';
		 				 	  tableContents=tableContents+'<td align="center">&nbsp;'+date+'</td>';
		 				 	  tableContents=tableContents+' <td align="center">';
		 				 	  var tid=jsonData.cmessage;
		 				 	  tableContents=tableContents+' <a href=javascript:deleteTopic("'+tid+'")   id="'+tid+'">';
		 				 	  tableContents=tableContents+' <img alt="" src="${pageContext.request.contextPath}/images/close.png"/>';
		 				 	  tableContents=tableContents+' </a>';
		 				 	  tableContents=tableContents+' / ';
		 					  tableContents=tableContents+' <img alt="" src="${pageContext.request.contextPath}/images/edit.png"/>';
		 				 	  tableContents=tableContents+' </td>';
		 				 	  tableContents=tableContents+' </tr>';
		 					   $("#totalRecords").html(nextNo); 
		 		 			   $("#tableContent").append(tableContents);
						}else {
							  $("#applicationMessage").html("There is some problem to process this request ,please contact to the app admin.");	
							   $(".alert").show();
							  $("#addTopicModel").modal("hide");
						}
					} //end of the method
				});	 //end of the ajax	
						 	
	 });
  	
});
</script>	
</head>
<body  id="page2" style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;" onkeydown="return (event.keyCode != 116)">

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
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
   <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
   		<hr/>
        <div class="container" style="background-color: white;">
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Add/Edit Topics</b></h3>
                   <span style="float: right;">
                   <input type="button" value="Add Topic"	class="mc-btn btn-style-1" id="addTopic"/> 
                   </span>
            </div>
				<%-- <span style="color: red;font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> --%>
				 <div class="alert alert-info fade in" style="margin-top: 20px;padding: 8px;" id="alertMessage">
   			    		 <strong>Note!</strong> <span style="font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> 
			    </div>
                 <form:form  id="topicFormId" action="${pageContext.request.contextPath}/action/addTopic" method="post" commandName="topicVO">
        	<table class="table table-bordered">
      			 	 <tbody>
      			 	  <tr height="25px" >
					     <td style="width: 20%;">
					       <span style="font-size: 16px;">Select Technology&nbsp; :</span> 
					     </td>
					     <td>
					       	<form:select path="language"  class="input-large form-control" style="width:300px;display:inline;">
					       		 <option>--Select--</option>
					       		<form:options items="${technologyList}" />
					       	</form:select>
					     </td>
					   </tr>
      			 
					  </tbody>
					 </table>
					 	</form:form>
					   <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
					   <img src="${pageContext.request.contextPath}/images/test-icon.png" style="margin-top: -5px; width: 25px;"> 
					    <span style="font-size: 16px;">Topics List:-</span>
					   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="font-size: 16px;">Technology Name:-</span> <span id="selectedTechName" style="font-weight: bold;"></span>
					    <div style="float: right;">
                           <img src="${pageContext.request.contextPath}/images/favicon.ico"width="25px;">   <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Records :</span> <b><span id="totalRecords">${fn:length(allTechs)}</span></b>
                             </div> 
                             <table class="table  table-bordered" id="tableContent">
      			            <tr style="color: white;background-color:#607D8B">
      			          <td class="score" style="width:20%">SNo </td>
                            <td class="submit-date" style="width:20%">Topic Name</td>
                            <td class="author" style="width:20%">Description</td>
                            <td class="submit-date" style="width:20%">Doe</td>
                             <td class="submit-date" style="width:15%">OP</td> 
<!--                             	<td class="submit-date" style="width:20%">Action</td> -->
                         </tr>
<!-- 						<table class="table table-bordered" width="100%" id="tableContent">
<!-- 						<thead class="theader"> -->
<!-- 					     <tr height="30px" style="color: white;background-color:#607D8B;vertical-align: middle;" align="center"> -->
<!-- 					     <td width="10px"><b>Sno.</b></td> -->
<!-- 					   	   <td width="300px" align="left"><b>Topic Name</b></td> -->
<!-- 					   	   <td><b>Description</b></td> -->
<!-- 					   	     <td><b>Doe</b></td> -->
<!-- 					   	    <td> -->
<!-- 					   	    <b>OP</b></td> -->
<!-- 					     </tr> -->
<!-- 					     </thead> -->
					     <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					     </tr>
					</table>     
				
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

<!-- Modal -->
<form  id="addTopicModelForm"  >
<div id="addTopicModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/course-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       
       			<input type="hidden" name="language" id="techId">
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;" id="ptechName">Angular2</label>
        </div>
        <hr/>
           <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      	Topic Name    :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="topicName" name="topic"/>
        </div>
        
        
          <div class="form-group">
       Description   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="description" name="description"/>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Add Topic" class="mc-btn btn-style-1" id="addNewTopic"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>

</html>