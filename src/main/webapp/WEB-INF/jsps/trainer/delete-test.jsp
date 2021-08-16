<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Delete Test</title>
       
    <style>
<!--
input[type="checkbox"] { -webkit-appearance: checkbox; }
input[type="radio"] { -webkit-appearance: radio; }
input[type="submit"], input[type="button"] { -webkit-appearance: button; }
select { -webkit-appearance:textfield; }
-->
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
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;min-height:600px;" id="quizz-intro-section">
        <div class="container">
            <div class="title-ct">
                 &nbsp;&nbsp;
               		  <span>	
               		 	<h3 style="font-size: 18px;"> Technology Test :</h3>
						 <img src="${pageContext.request.contextPath}/images/lock-unlock-bar.png" style="height: 80px;"/>		
						
						<h3 style="font-size: 18px;display: inline;"> Technology:</h3>
<!-- 						<select class="form-control" name="selectedGroupName" id="selectedGroupName" style="width: 400px;display: inline;margin-left: 10px;"> -->
<%-- 							 	   <% --%>
<!-- 						 		List<String> groupNames=(List<String>)request.getAttribute("userGroupList"); -->
<!-- 						 	    String selectedGroupName=(String)request.getParameter("selectedGroupName");  -->
<!-- 							 		for(String gname:groupNames){ -->
<%-- 							 		%> --%>
<%-- 									<option value="<%=gname%>"  --%>
<%-- 									   <%  --%>
<!-- 									    if(gname.equals(selectedGroupName)){ -->
<%-- 									    	 %> --%>
<!-- 									    	selected -->
<%-- 									   <% --%>
<!--  								   }  -->
<%-- 									   %>  --%>
<!-- 									   > -->
<%-- 									<%=gname%> --%>
									
<!-- 									</option> -->
<%-- 									<% --%>
<!-- 						 	     } -->
<%-- 									%> --%>
<!-- 						 </select>  -->
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
						 </span>
						
            </div>
             <form:form id="userTestHistoryForm"
							action="${pageContext.request.contextPath}/action/user-test-history"
							method="POST">
							<input type="hidden" name="userid" id="userid"/> <br /> 
							<section style="margin-left: -16px;">
							<div class="col-xs-12">
								
						 </div>
						</section>
							<hr style="color: blue" />		
						
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
					 
            <div class="table-student-submission">
            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Test(s) List:-</span>
					    <div style="float: right;">
								<img src="../images/favicon.ico" height="30px">&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Tests :</span> <b><span id="totalTests"></span></b>
							</div>
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #1192ea;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Short Name </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">DOC</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Action</th>
                        </tr>
                    </thead>

                    <tbody>
					       <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	   
					     </tr>
					     <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					   <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					   <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					   <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					     
					     <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					     
					     <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					     
					       <tr  style="color: black">
					     <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	   <td bgcolor="white">&nbsp;</td>
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					     


                    </tbody>
                </table>
                </div>
                </form:form>
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

var ccontextPath="${pageContext.request.contextPath}";
var userRole="${sessionScope.user_session_data.role}";
function loadData(){
	var ptechName=$("#techName").val();
	var len=0;
  //$('body').prelodr('in', 'Loading data please wait...');
	$.getJSON(ccontextPath+"/action/findConfigureTestDetailsByTechName", {techName:ptechName}, function(jsonResponse) {
		 //$('body').prelodr('out');
		console.log("@@@)@((902929))"); 
		console.log(jsonResponse); 
		if(jsonResponse) {
			 len = jsonResponse.length;
      	var tableContent='';
      	var val;
      	$("#totalTests").html(len);
      	tableContent=tableContent+' <thead>';
      	tableContent=tableContent+' <tr style="background-color: #1192ea;">';
      	tableContent=tableContent+'<th class="submissions" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">SNo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Tech Name</th>';
      	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Test Name </th>';
//     	tableContent=tableContent+' <th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Password </th>';
      	tableContent=tableContent+'<th class="submit-date" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Photo</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Total Questions</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">DOE</th>';
      	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Action</th>';
//     	tableContent=tableContent+'<th class="author" style="color: white;font-family: \'Lato\', sans-serif;font-size: 14px;">Lock/Unlock</th>';
      	tableContent=tableContent+'</tr>';
      	tableContent=tableContent+' </thead>';
      	if(len>0){
      		
      	for(var i=0;i<len;i++){
      			val=i+1;
      				tableContent=tableContent+'<tr height="35px" style="color: black; vertical-align: middle;">';
      				tableContent=tableContent+'<td align="center">'+val+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].techName+'</td>';
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;'+jsonResponse[i].testName+'</td>';
      				var imagePath=ccontextPath+"/images/feature/"+jsonResponse[i].techName.toLowerCase()+".jpg";
      				tableContent=tableContent+'<td >&nbsp;&nbsp;&nbsp;<img src="'+imagePath+'" style="height:30px;"/></td>';
      				tableContent=tableContent+'<td id="testStatus"'+val+'>&nbsp;&nbsp;&nbsp;'+jsonResponse[i].totalQuestions+'</td>';
      				tableContent=tableContent+'<td>'+jsonResponse[i].dateOfEntry+'</td>';
      				var jsmethod="<a href=\"javascript:deleteTestByTechName('"+jsonResponse[i].techName+"','"+jsonResponse[i].testName+"');\"";
      				tableContent=tableContent+'<td align="center">';
      				if("yes"==jsonResponse[i].active){
      					tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/unlocked.png" style="height:24px;"  id="imageId'+val+'"/></a>';
      				}else {
      					tableContent=tableContent+jsmethod+'"><img	src="${pageContext.request.contextPath}/images/lock.png" style="height:24px;"  id="imageId'+val+'"/></a>';
      				}
      				tableContent=tableContent+'</td>';
      				tableContent=tableContent+'</tr>'
      	}
      }
		}
      	   var rows=6-jsonResponse.length;
      		for(var p=0;p<rows;p++){
      			tableContent=tableContent+'	<tr height="35px" style="color: black">';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
//       			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
//       			tableContent=tableContent+'<td bgcolor="white">&nbsp;</td>';
      			tableContent=tableContent+'</tr>';
      		}
      	
      	tableContent=tableContent+'<tr height="35px" style="color: white; background-color: white; vertical-align: middle;" align="center">';
      	$("#tab1").html(tableContent);
		
	});//end of getJSON
}

 $(document).ready(function(){
	 	$("#techName").change(function(){
	 		 $("#validationMessage").html("");
	 		loadData();
	 	});
	 	                        
		
		 $("input[type='text']").keyup(function(){
			 $("#validationMessage").html("");
		 });	
		 
	 	//Loading the data first time when this page is loaded first time....
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
    
     function deleteTestByTechName(techName,testName) {
     	 var ccontextPath="${pageContext.request.contextPath}";
     	
     	$.getJSON(ccontextPath+"/action/deleteTestByTechName", {techName:techName,testName:testName}, function(jsonResponse) {
     		  console.log(jsonResponse); 
     		 if(jsonResponse.status=="success"){
     				$("#ApplicationMessage").html("Technology "+techName+"  has been deleted successfully for "+testName);	 
     		 }	else{
     			 alert("Sorry! test could not be deleted..................");
     		 }
     	});
    } 

</script>
</body>

</html>