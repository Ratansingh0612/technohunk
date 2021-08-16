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
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/configure.png" width="25px;"/> - <b> ${pageTitle}</b></h3> 
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
					     <tr height="30px" style="color: white;background-color:#607D8B;;vertical-align: middle;" align="left">
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

function loadData(){
	   var ccontextPath="${pageContext.request.contextPath}"
			var tableRemoteData="";
//		  $('body').prelodr('in', 'Loading data please wait...');
		   $.getJSON(ccontextPath+"/action/findConsultantsByBatch",{batchName:$("#batchName").val()},function(jsonResponse){
//			 $('body').prelodr('out');
			 tableRemoteData=tableRemoteData+'<tr height="30px" style="color: white;background-color:#607D8B;vertical-align: middle;">';
		  		tableRemoteData=tableRemoteData+'<td width="10px"><b>Sno.</b></td>';
		  		tableRemoteData=tableRemoteData+'<td align="left"><b>Consultant Id</b></td>';
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
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><img style="border-radius: 25px;" src="'+imageURL+'" alt=""  width="40" height="40"/></td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;<a href="'+ccontextPath+'/action/${nextAction}?consultantId='+jsonResponse[i].userid+'"><img src="'+ccontextPath+'/images/users.png" width="25" height="25"/>&nbsp;${nextTitle}</a></td>';
						tableRemoteData=tableRemoteData+' </tr>';
		  		}	 
	 		    $("#totalRecords").html(jsonResponse.length);
	 	 var rows=6-jsonResponse.length;		
	 	for(var p=0;p<rows;p++) {
				  	  	tableRemoteData=tableRemoteData+'<tr height="25px">';
				  	  tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+' <td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td>&nbsp;</td>';
				  	tableRemoteData=tableRemoteData+'<td align="center">';
				  	tableRemoteData=tableRemoteData+'</td>';
				  	tableRemoteData=tableRemoteData+'</tr>';
	 	}
				$("#tableContent").html(tableRemoteData);
		   });
}	

$(document).ready(function() {
	//loadData();
	//alert("good morning!");
$("#batchName").change(function() {
		loadData();
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
});
</script>
</body>

</html>