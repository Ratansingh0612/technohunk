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
    <title>${companyName} - Consultant Attendance Page!</title>
    <style>
input[type=checkbox]{
  display:none;
}

input[type=checkbox] + label:before{
  content: '';
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

input[type=checkbox]:checked + label:before{
  color: red;
   background:#37abf2;
}
</style>
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
            <form id="saveAttendanceFrom"
							action="${pageContext.request.contextPath}/action/attendance/save"
							method="post">	
			<input type="hidden" name="operation" value="save"/>				
<!--   <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section"> -->
        <div class="container">
            <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 18px;"><img src="${pageContext.request.contextPath}/images/configure.png" width="25px;"/> - <b> ${pageTitle}</b></h3> 
            </div>
            
            <table class="table table-bordered" width="60%">
      			 	 <tbody>
      			 	 <tr height="25px" >
					     <td colspan="1" align="left" valign="bottom" >
					     
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Org</label>
								 &nbsp;&nbsp;
								  <select class="form-control" name="cname" id="cname" style="width: 250px;display: inline;">
								 	<option>Select Consultancy</option>
								 			<option value="Reb3Tech">Rab3 Tech</option>
											<option value="CubicTech">Cubic Tech</option>
											<option value="Kuebiko">Kuebiko</option>
								 </select>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					     
					           <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Select Batch:</label>
								 &nbsp;&nbsp;
								  <select class="form-control" name="batchName" id="batchName" style="width: 200px;display: inline;">
								 	<option>Select Batch</option>
								 		<c:forEach items="${batchList}" var="item">
								 			<option>${item}</option>
								 		</c:forEach>
								 </select>
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								  <label for="sel1" style="font-family: 'Lato', sans-serif;font-size: 16px;">Topic Description:</label>
								    <input class="form-control" name="topicDescription" id="topicDescription" style="width: 300px;display: inline;">
		
					     </td>
					        <td colspan="1" align="left" valign="bottom" >
					     </td>
					   </tr>
					  </tbody>
					  
					 </table>
 <hr style="color: blue"/>
					   <img src="${pageContext.request.contextPath}/images/users.png" style="height: 34px;"/> 
					    <span style="font-family: 'Lato', sans-serif;font-size: 16px;">User(s) List:-</span>
					    <div style="float: right;">
					    <img src="${pageContext.request.contextPath}/images/kick.png" height="30px" style="font-family: 'Lato', sans-serif;font-size: 17px;">   Total Present : <b><span id="totalPresent">${fn:length(allTechs)}</span></b>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                          <img src="${pageContext.request.contextPath}/images/favicon.ico" height="30px" style="font-family: 'Lato', sans-serif;font-size: 17px;">   Total Consultant : <b><span id="totalRecords">${fn:length(allTechs)}</span></b>
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
					   <span style="float:right;">
					   <a
										href="${pageContext.request.contextPath}/action/show-all-consultants">
										<input type="button" value="Back" class="btn btn-danger"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;" />
									</a> 
						<a
										href="${pageContext.request.contextPath}/action/show-all-consultants">
										<input type="button" value="Uncheck All" class="btn btn-primary"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;" />
									</a> 
					<a
										href="javascript:saveAttendance();">
										<input type="button" value="Mark Attendance" class="btn btn-success"
										style="font-family: 'Lato', sans-serif; font-size: 17px;;" />
									</a>
									</span> 
            </div>
        </div>
        </form>
        <hr/>  <hr/>    <hr/>  <hr/>
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

function saveAttendance(){
	
	
	$("#saveAttendanceFrom").submit();
}

function oaj(idid){
	  idid="#"+idid;
	var tempVal=$(idid).val();
		if($(idid).attr('checked')) {
			//when unchecked
			$(idid).removeAttr('checked');
			var count=$("#totalPresent").html();
			count=count-1;
			$("#totalPresent").html(count);
		} else {
			////when checked
			$(idid).attr('checked','checked');
			var count=$("#totalPresent").html();
			count=parseInt(count)+1;
			$("#totalPresent").html(count);
		}
}


function loadData(){
	   var ccontextPath="${pageContext.request.contextPath}"
			var tableRemoteData="";
//		  $('body').prelodr('in', 'Loading data please wait...');
		   $.getJSON(ccontextPath+"/action/findConsultantsByBatch",{batchName:$("#batchName").val(),cname:$("#cname").val()},function(jsonResponse){
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
			  			tableRemoteData=tableRemoteData+'<tr height="25px" style="color: black;font-size:16px;">';
			  			tableRemoteData=tableRemoteData+'<td>'+(i+1)+'</td>';
			  			
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].empid+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].name+'</td>';
			  			tableRemoteData=tableRemoteData+'<td>&nbsp;'+jsonResponse[i].email+'</td>';
			  			var imageURL=ccontextPath+'/action/findConsultantImage?userid='+jsonResponse[i].userid;
			  			var idid="status"+i;
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><img style="border-radius: 25px;" src="'+imageURL+'" alt=""  width="40" height="40"/></td>';
			  			tableRemoteData=tableRemoteData+'<td style="text-align:center;"><div class="form-item form-checkbox checkbox-style"><input  onclick="oaj(\''+idid+'\');"   value="'+jsonResponse[i].empid+'" type="checkbox" id="status'+i+'"  name="status" checked="checked"><label for="status'+i+'"><i class="icon-checkbox icon md-check-1"></i></label></div></td>';
						tableRemoteData=tableRemoteData+' </tr>';
		  		}	 
	 		    $("#totalRecords").html(jsonResponse.length);
	 		   $("#totalPresent").html(jsonResponse.length);
	 		   
	 	 var rows=5-jsonResponse.length;		
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