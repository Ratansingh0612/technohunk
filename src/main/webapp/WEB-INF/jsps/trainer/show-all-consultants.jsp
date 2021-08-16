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
    <title>${companyName} - Lock-Unlock Users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/show-all-users.js" ></script>

</head>
<body>

 <form id="show-all-consultants-form-batch" action="${pageContext.request.contextPath}/action/show-all-consultants" method="get">
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
  		<hr/>
      <div class="container" style="background-color: white;">
        <br/>
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 16px;display: inline;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Consultants Page</b></h3>
            </div>
						<form:form id="showUsersFormId"
							action="${pageContext.request.contextPath}/action/loadUsersByGroup"
							method="post" commandName="userListInput">
							<input type="hidden" name="NoOfUsers"
								value="${fn:length(userList)}" /> <br /> 
								
         	      	<label for="groupName" style="font-size: 16px;">Select Group/Batch  :  </label>
         	      		&nbsp;
             			<form:select path="selectedGroupName" class="form-control"  style="width: 300px;display:inline;">
             					  <option>All</option>	
							     <form:options items="${userGroupList}"/>
							</form:select> 
						  <span style="float: right;">
                   <a href="${pageContext.request.contextPath}/action/add-consultant"><input type="button" value="Add Consultant"	class="mc-btn btn-style-1" id="addConsultant"/> </a>
                   </span>
                   <br/>
							&nbsp;&nbsp;
							 <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;"></span>
							 <img src="${pageContext.request.contextPath}/images/icon/cheers.png"width="35px;"/>
							<span style="font-size: 14px;">User(s) List:-</span>
							<div style="float: right;">
								<img src="${pageContext.request.contextPath}/images/favicon.ico" style="font-size: 14px;">&nbsp;Total Users : <b><span id="totalUsers">${fn:length(users)}</span></b>
							</div>
                
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
                             
                <table class="table table-bordered" id="theader" style="font-size: 15px;">
               
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <td class="submissions" style="width:5px;"><b>SNo</b></td>
                              <td class="submissions" style="width:5px;"><b>UID</b></td>
                            <td class="author" style="width:15%"><b>Name</b> </td>
                            <td class="score"><b>Email</b> </td>
                            <td class="submit-date"><b>Password</b></td>
                            <td class="submit-date" style="width:15%"><b>Batch</b></td>
                            <td class="submit-date"><b>Photo</b></td>
                            <td class="submit-date" style="width:8%"><b>Doj</b></td>
                            <td class="submit-date"><b>Action</b></td>
                        </tr>
                        		<c:forEach var="userItem" items="${users}"
									varStatus="status">
									<tr height="25px" style="color: black; vertical-align: middle;">
										<td align="center"><b>${status.count}</b>
										</td>
										<td>&nbsp;${userItem.loginid}</td>
										<td>&nbsp;${userItem.firstName}&nbsp;&nbsp;${userItem.lastName}</td>
										<td>&nbsp;${userItem.email}</td>
												<td>&nbsp;${userItem.password}</td>
										<td align="center">&nbsp;${userItem.batch}</td>
										<td align="center">&nbsp;
										<img
								src="${pageContext.request.contextPath}/${imageURL}?userid=${userItem.loginid}" style="width: 50px;"/></td>
										<td align="center">
										&nbsp;
										<img
											src="${pageContext.request.contextPath}/images/more-detail.png" width="25px;"/>
											TODO
										</td>
										<td align="center" >
										<a href="javascript:editConsultant('${userItem.email}')">
											<img src="${pageContext.request.contextPath}/images/icon/edit.png" id="editConsultant"  style="height: 40px;"/>
										</a>
										/
										<a href="javascript:deleteConsultantByEmail('${userItem.email}')">
											<img src="${pageContext.request.contextPath}/images/icon/delete.png" id="deleteConsultant"  style="height: 40px;"/>
										</a>
										
										
										</td>
									</tr>
								</c:forEach>
                    </thead>

                    <tbody>
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
							<td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	     <td>&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
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
		$("#show-all-consultants-form-batch").submit();
	});

});

var sbatchName="${param.batchName}"
function deleteConsultantByEmail(email){
	 console.log(email);
	 var yesno=confirm("Are you sure want to deleted this consultant with userid "+email);
	 if(yesno){
		 $("#demail").val(email);
		 $("#dbatchName").val(sbatchName);
 		 $("#delete-consultant-form-batch").submit();
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
    
    function editConsultant(email){
    	  $("#editConsultantPopupModel").modal("show");
    }

</script>

 
 <!-- Modal -->
<form  id="editConsultantPopupForm"  >
<div id="editConsultantPopupModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px;">
        <b style="margin-top: -10px;">Edit Consultant Page</b>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      	 Name   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="username" name="name"/>
        </div>
        
        <div class="form-group">
      	<label id="stream">Occupation:</label>
  			<select name="occupation" class="form-control" id="occupation">
  					<option>Software Developer</option>	
  					<option>Student</option>	
  					<option>Others</option>	
  			</select>
        </div>
        
          <div class="form-group">
       Date of joining   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="doj" name="doj"/>
        </div>
      
      
          <div class="form-group">
       Mobile   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="mobile" name="mobile"/>
        </div>
         
         <div class="form-group">
      	<label id="stream">Gender:</label>
  			<select name="gender" class="form-control" id="gender">
  					<option>Male</option>	
  					<option>Female</option>	
  			</select>
        </div>
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Update Consultant" class="mc-btn btn-style-1" id="updateConsultant"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>

</html>