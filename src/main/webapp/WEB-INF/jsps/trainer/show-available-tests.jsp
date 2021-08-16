<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Available Test</title>
       
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
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section">
        <div class="container">
            <div class="title-ct">
                
                 &nbsp;&nbsp;<h3 style="color: black"><img src="${pageContext.request.contextPath}/images/exam-summary.png" style="height:80px;"/> - <span style="font-family: 'Lato', sans-serif;font-size: 17px;font-weight: bold;">Available Test Page</span>
               <br/>
                <label for="testName" style="font-family: 'Lato', sans-serif;font-size: 14px;">Technology :&nbsp;&nbsp;&nbsp;</label>
								<select
								name="techName"  id="techName" class="form-control" style="display: inline;width: 300px;">
								<option value="All" selected="selected">All</option>
								<k:forEach var="techname" items="${techList}">
									<option value="${techname}">${techname}</option>
								</k:forEach>
							</select> 
                 </h3>
              
            </div>
            
             <form:form id="showUsersFormId"
							action="${pageContext.request.contextPath}/action/loadUsersByGroup"
							method="post" commandName="userListInput">
							<hr style="color: blue" />		
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
					 
            <div class="table-student-submission">
            <span style="font-family: 'Lato', sans-serif;font-size: 16px;">Test(s) List:-</span>
					    <div style="float: right;">
								<img src="../images/favicon.ico" height="30px">&nbsp;<span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Test(s) :</span> <b><span id="totalUsers">${fn:length(userList)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #1192ea;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Tech Name</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Icon</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Test Name </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Total Questions</th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Duration</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">DOTC</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Action</th>
                        </tr>
                    </thead>

                    <tbody id="partialContent">
                    
                    <!-- Iterating through available technology list -->
                    <!-- what is this war status? -->
                    		<k:forEach var="item" items="${availableTestList}" varStatus="ooooo">
					       <tr style="color: black" id="${item.techName}_${item.testName}">
					     <td bgcolor="white">&nbsp;${ooooo.count}</td>
					   	   <td bgcolor="white">&nbsp;${item.techName}</td>
					   	    	    <td>&nbsp;<img alt="" src="${pageContext.request.contextPath}/images/feature/${item.timage}" style="height: 24px;"></td> 
					   	   <td bgcolor="white">&nbsp;${item.testName}</td>
					   	  <td bgcolor="white">&nbsp;${item.totalQuestions}</td>
					   	  <td bgcolor="white">&nbsp;${item.testDuration}</td>
					   	   <td bgcolor="white">&nbsp;${item.dateOfEntry}</td>
					   	   <td align="center" bgcolor="white">&nbsp;	 <a href="javascript:deleteTest('${item.techName}','${item.testName}');" >
            		  <img alt="" src="${pageContext.request.contextPath}/images/delete-q.png" height="24px;">
               </a></td>
					  
					  
					  		
					     </tr>
					     </k:forEach>
					     					     


                    </tbody>
                    
                    <tr style="color: black">
					     <td bgcolor="white">&nbsp;</td>
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
					   	    <td bgcolor="white">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
                    
                    
                    
                    
                </table>
                </div>
                </form:form>
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



</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>

<script type="text/javascript">

function loadData() {
	var techName = $("#techName").val();
	var ccontextPath="${pageContext.request.contextPath}";
	
	$.getJSON(ccontextPath+"/action/findAvailableTestDetailsByTechName", {techName:techName},function(jsonResponse){
		
		console.log(jsonResponse);
		var contentData = "";
		
		for(var row=0; row<jsonResponse.length;row++)
			{
			contentData=contentData+' <tr style="color: black" id="'+jsonResponse[row].techName+'_'+jsonResponse[row].testName+'">';
	 		contentData=contentData+'  <td bgcolor="white">&nbsp;'+(row+1)+'</td>';
	 		contentData=contentData+' <td bgcolor="white">&nbsp;'+jsonResponse[row].techName+'</td>';
	 		contentData=contentData+'<td align="center"><img style="height:24px;" src="${pageContext.request.contextPath}/images/feature/'+jsonResponse[row].timage+'"/></td>';
	 		contentData=contentData+'   <td bgcolor="white">&nbsp;'+jsonResponse[row].testName+'</td>';
	 		contentData=contentData+' 	  <td bgcolor="white">&nbsp;'+jsonResponse[row].totalQuestions+'</td>';
	 		contentData=contentData+' <td bgcolor="white">&nbsp;'+jsonResponse[row].testDuration+'</td>';
	 		contentData=contentData+'  <td bgcolor="white">&nbsp;'+jsonResponse[row].dateOfEntry+'</td>';
	 		contentData=contentData+'   <td bgcolor="white">&nbsp;';
	 		contentData=contentData+" <a href=\"javascript:deleteTest('"+jsonResponse[row].techName+"','"+jsonResponse[row].testName+"');\">";
	 		contentData=contentData+'  <img src="${pageContext.request.contextPath}/images/delete-q.png"/>';
	 		contentData=contentData+' </a>';
	 		contentData=contentData+' </td>';
	 		contentData=contentData+'  </tr>';
			}
		
		$("#partialContent").html(contentData);
		
	});
	
}
 
 
 $("#techName").change(function(){
	 loadData();
 });
	 

 function deleteTest(ptechName,ptestName){
	 console.log("ptechName: "+ptechName);
	 console.log("ptestName: "+ptestName);
	 var ccontextPath="${pageContext.request.contextPath}";
	 $.getJSON(ccontextPath+"/action/deleteTestByTechNameandTestName",{techName:ptechName, testName:ptestName}, function(jsonResponse){
		 console.log("jsonResponse="+jsonResponse);
		 if(jsonResponse.status=="success")
			 {
			 $("#"+ptechName+"_"+ptestName).hide();
			 $("#ApplicationMessage").html(ptestName+ " has been deleted successfully for the technology "+ptechName);
			 }
		  
	 });
 }
 
 
 
 
 
/*
$("#selectedGroupName").change(function() {
	loadData();
});*/


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