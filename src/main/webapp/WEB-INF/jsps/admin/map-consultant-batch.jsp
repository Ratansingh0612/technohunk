<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Lock-Unlock Users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
<script type="text/javascript">
var ccontextPath="${pageContext.request.contextPath}";
var currentRole="${sessionScope.user_session_data.role}";
</script>
</head>
<body>

<!-- PAGE WRAP -->
     <div class="body121">
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
  </div>
</div>

    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


 
    <!-- COURSE CONCERN -->
  <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
  		<br/>
      <div class="container" style="background-color: white;">
        <br/>
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> - <b> Consultants Page</b></h3>
            </div>
            <br/>
             <form action="${pageContext.request.contextPath}/action/map-consultant-batch" method="post" id="associateGroupForm">
         	      		<label for="groupName" style="font-size: 16px;">Select Trainer  :  </label>
         	      		&nbsp;
             			<select name="selectedTrainerName" id="selectedTrainerName" class="form-control"  style="width: 400px;display:inline;">
             					  <option ${item==param.selectedTrainerName?'selected':''}>All</option>	
             					  <c:forEach items="${trainerNameList}" var="item">
							  		   <option ${item==param.selectedTrainerName?'selected':''}>${item}</option>
							     </c:forEach>
							</select> 
							<label for="groupName" style="font-size: 16px;margin-left: 30px;">Batch  :  </label>
	             			<select name="batchName" id="batchName" class="form-control"  style="width: 200px;display:inline;">
	             				<option>Select Batch</option> 
             					  <c:forEach items="${batchNameList}" var="item">
							  			   <option>${item}</option>
							     </c:forEach>
							</select> 
						  <span style="float: right;">
                   <input type="button" value="Associate Group"	class="mc-btn btn-style-1" id="associateGroup" style="background-color: #f96e15;;margin: 0px;font-size: 14px;width: 100%;"/>
                   </span>
                                </form>
							&nbsp;&nbsp;
							 <hr/>
							 <span id="ApplicationMessage" style="font-size: 14px;color:blue;font-weight: bold;">${ApplicationMessage}${param.ApplicationMessage}</span>
							 <img src="${pageContext.request.contextPath}/images/user1.png"width="35px;"/>
							<span style="font-size: 16px;">Batch(s) List:-</span>
							<div style="float: right;">
								<img src="${pageContext.request.contextPath}/images/favicon.ico" style="font-size: 16px;">&nbsp;Total Records : <b><span id="totalUsers">${fn:length(users)}</span></b>
							</div>
                
                   <h4 style="color: red">
								 ${ApplicationMessage}
						</h4>
                             
                <table class="table table-bordered" id="theader" style="font-size: 14px;">
                    <thead>
                        <tr style="background-color: #607D8B;">
                            <td class="submissions" style="width:5px;">SNo</td>
                            <td class="author" style="width:30%">Name </td>
                            <td class="score">Batch </td>
                            <td class="submit-date" style="width:15%">Batch Code</td>
                            <td class="submit-date" style="width:12%">Doc</td>
                            <td class="submit-date" style="width:15%">Action</td>
                        </tr>
                         </thead>
                        	
                   

                    <tbody>
                    	<c:forEach var="item" items="${batchAssignmentVOs}"
									varStatus="status">
									<tr height="25px" style="color: black; vertical-align: middle;">
										<td align="center"><b>${status.count}</b>
										</td>
										<td>&nbsp;${item.baid} - ${item.trainerName}</td>
										<td>&nbsp;${item.batch}</td>
												<td>&nbsp;${item.batchid}</td>
										<td align="left">&nbsp;
										<fmt:formatDate pattern = "dd-MM-yyyy"    value = "${item.doc}" />
										</td>
										<td align="center" >
										<a href="javascript:editConsultant('${item.batchid}')">
											<img src="${pageContext.request.contextPath}/images/icon/edit.png" id="editConsultant"  style="height: 32px;"/>
											</a>
										</td>
									</tr>
								</c:forEach>
                      <tr height="25px" style="color: black">
					     <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td align="center">
							</td>
							<td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					     </tr>
					    <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					     </tr>
					     
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	    <td>
					   	    <b>&nbsp;</b></td>
					   	    <td>&nbsp;</td>
					   	   <td>&nbsp;</td>
					     </tr>
					     
						</tbody>     
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
    
    function editConsultant(email){
    	  $("#editConsultantPopupModel").modal("show");
    }
    
    $(function(){
    	  $("#selectedTrainerName").change(function() {
    		  $("#ApplicationMessage").html("");
    		  $("#ApplicationMessage").hide();
    		  var sval=$(this).val();
    		  $("#pselectedTrainerName").val(sval);
    		  if("All"!=sval){
	    			$("#mapConsultantForm").submit();
    		  }
    	  });
 	   $("input[type='button'][id='associateGroup']").click(function() {
 				  // 	alert("@_@)#)#)#)");
 				   var trainerName=$("#selectedTrainerName").val();
 				    if("All"==trainerName){
 				    	   $("#ApplicationMessage").html("Please select a trainer.....");
 				    	   return;
 				    }
 				   $("#associateGroupForm").submit();
 	   });
    });

</script>

<form id="mapConsultantForm" action="${pageContext.request.contextPath}/action/map-consultant-batch" method="get">
	<input type="hidden" name="selectedTrainerName" id="pselectedTrainerName"/>
</form>
 
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