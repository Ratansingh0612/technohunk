<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Show Hide Tests</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/show-all-users.js" ></script>

</head>
<body>

 <form id="show-hide-tests-form-batch" action="${pageContext.request.contextPath}/action/show-hide-tests" method="get">
 	<input type="hidden" name="batchName" id="batchName"/>
 </form>
 
  <form id="delete-consultant-form-batch" action="${pageContext.request.contextPath}/action/show-all-consultants" method="get">
 	<input type="hidden" name="email" id="demail"/>
 	<input type="hidden" name="batchName" id="dbatchName"/>
 </form>

<!-- PAGE WRAP -->
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
      <div class="container" style="background-color: white;">
        <br/>
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 16px;display: inline;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Show Hide Test Page</b></h3>
            </div>
						<form:form id="showUsersFormId"
							action="${pageContext.request.contextPath}/action/loadUsersByGroup"
							method="post" commandName="userListInput">
							<input type="hidden" name="NoOfUsers"
								value="${fn:length(userList)}" /> <br /> 
								
         	      	<label for="groupName" style="font-size: 16px;">Select Group/Batch  :  </label>
         	      		&nbsp;
        	     			<select name="selectedGroupName" id="selectedGroupName"  class="form-control"  style="width: 300px;display:inline;">
    	         					  <option>Select</option>	
								      <k:forEach items="${userGroupList}" var="item">
							     	<option ${param.batchName==item?'selected':''}>${item}</option> 
							      </k:forEach>
							</select> 
						 <%--  <span style="float: right;">
                   			 <a href="javascript:resetAllPassword();">
                  				 <input type="button" value="Reset Group Password"	class="mc-btn btn-style-1" style="background-color:#3a424c;" id="addConsultant"/> 
                  			 </a>
                   			<a href="${pageContext.request.contextPath}/action/add-consultant">
                  			 <input type="button" value="Add Consultant"	class="mc-btn btn-style-1" id="addConsultant"/> 
                  		 </a>
                   </span> --%>
                   <br/>
							&nbsp;&nbsp;
							 <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
							 <img src="${pageContext.request.contextPath}/images/icon/cheers.png"width="35px;"/>
							<span style="font-size: 14px;">Test(s) List:-</span>
							<div style="float: right;">
								<img src="${pageContext.request.contextPath}/images/favicon.ico" style="font-size: 14px;">&nbsp;Total Test(s) : <b><span id="totalUsers">${fn:length(assignedTestUsersList)}</span></b>
							</div>
                
                   <h5 style="color: red">
								 ${ApplicationMessage}${param.message}
						</h5>
                             
                <table class="table table-bordered" style="border: 1px solid #3b58da !important;" id="theader">
               
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <td class="submissions"><b>SNo</b></td>
                              <td style="width: 120px;"><b>Tech Name</b></td>
                            <td><b>Test Name</b> </td>
                            <td class="score"><b>Questions</b> </td>
                            <td class="submit-date"  style="width: 60px;"><b>Visible</b></td>
                            <td class="author"><b>Duration(Mins)</b></td>
                            <td class="submit-date"><b>Expire</b></td>
                            <td><b>Assign Date</b></td>
                            <td class="author" style="width:5%"><b>Action</b></td>
                        </tr>
                        		
                    </thead>

                    <tbody>
                    
                    <c:forEach var="userItem" items="${assignedTestUsersList}"
									varStatus="status">
									<tr  style="color: black; vertical-align: top;font-size: 15px;border: 1px solid #9c0707;background-color: #f5efe6;">
										<td align="center"><b>${status.count}</b>
										</td>
										<td>&nbsp;${userItem.assignedTestCompositeKey.techName}</td>
										<td>&nbsp;${userItem.assignedTestCompositeKey.testName}</td>
										<td>&nbsp;${userItem.numberOfQuestions}</td>
										<c:if test="${userItem.active=='YES'}">
										<td style="background-color: #71ff81;">&nbsp;<b>${userItem.active}</b></td>
										</c:if>
										<c:if test="${userItem.active=='NO'}">
										<td style="background-color: #dc524a;">&nbsp;<b>${userItem.active}</b></td>
										</c:if>											
										<td align="center">&nbsp;<b>${userItem.durationInMin}</b></td>
										<td align="left">${userItem.testExpireOn}</td>
											<td align="left">${userItem.assignDate}</td>
										
										<td>
										<a title="Click on icon to change the status." href="javascript:showHideTest('${userItem.assignedTestCompositeKey.techName}','${userItem.assignedTestCompositeKey.testName}','${userItem.active}')">
											<img src="${pageContext.request.contextPath}/images/icon/show-hide.png" id="showHideTest"  style="height: 30px;display: inline;"/>
										</a>
										
										
										</td>
									</tr>
								</c:forEach>
                      <tr style="color: black">
					     <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td align="center">
							</td>
							 <td align="center">
							</td>
							 <td align="center">
							</td>
							<td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					        <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					     
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					     
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					      <tr style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					     
						</tbody>     
                </table>
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

<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
  
  <script type="text/javascript">
var ccontextPath="${pageContext.request.contextPath}";
var currentRole="${sessionScope.user_session_data.role}";
$(document).ready(function(){
	$("#selectedGroupName").change(function(){
		 var sbatchName=$(this).val();
		 $("#batchName").val(sbatchName);
		$("#show-hide-tests-form-batch").submit();
	});
	
	$('#updatePassword').click(function(){
			var ccontextPath="${pageContext.request.contextPath}";
			var username=$("#rusername").val();
			var email=$("#remail").val();
			var newpassword=$("#newpassword").val();
			
			$.getJSON(ccontextPath+"/action/reset-user-passsword", {username:username,email:email,newpassword:newpassword}, function(jsonResponse) {
	    		  console.log(jsonResponse); 
	    		  $("#ApplicationMessage").html(jsonResponse.message);
	    		  $("#resetPasswordModalPopup").modal("hide");
	    	});
		
	});

});

var sbatchName="${param.batchName}"
function showHideTest(techName,testName,cstatus){
	 var yesno=confirm("Are you sure want to change the status of test?");
	 if(yesno){
		 cstatus=cstatus.toLowerCase();
		 if(cstatus=="yes"){
			 cstatus="NO"
		 }else{
			 cstatus="YES"
		 }
		 $("#stechName").val(techName);
		 $("#stestName").val(testName);
		 $("#spgroupName").val(sbatchName);
		 $("#cstatus").val(cstatus);
 		 $("#show-hide-test-form").submit();
	 }
}


</script>

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


<form id="show-hide-test-form" action="${pageContext.request.contextPath}/action/show-hide-test-change-status" method="post">
	<input type="hidden" name="batchName" id="spgroupName"/>	
	<input type="hidden" name="techName" id="stechName"/>	
	<input type="hidden" name="testName" id="stestName"/>	
	<input type="hidden" name="cstatus" id="cstatus"/>	
	
</form>
 



</body>

</html>