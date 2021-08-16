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
    <title>${companyName} - Show All Users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text/css" media="all">
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

          <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>

    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: white;" id="quizz-intro-section" class="quizz-intro-section learn-section">
        <div class="container">

            <div class="title-ct">
                
                 &nbsp;&nbsp;<h3 style="color: black"><img src="${pageContext.request.contextPath}/images/configure.png" width="20	px;"/> - <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Assign Test To User</span></h3> 
            </div>
            
             				
								<div class="col-xs-4">
								<label for="Group" style="font-family: 'Lato', sans-serif;font-size: 14px;"> Group/Batch :</label>
								<select class="form-control" name="selectedGroupName" id="selectedGroupName">
							<%-- 	<c:forEach var="groupName" items="${userGroupList}">
							 --%>	   <%
							 		List<String> groupNames=(List<String>)request.getAttribute("userGroupList");
							 	    String selectedGroupName=(String)request.getParameter("selectedGroupName"); 
							 		for(String gname:groupNames){
							 		%>
									<option value="<%=gname%>" 
									   <% 
									    if(gname.equals(selectedGroupName)){
									    	 %>
									    	selected
									   <%
	 								   } 
									   %> 
									   >
									<%=gname%>
									
									</option>
									<%
							 	     }
									%>
						 </select> 
						 </div>
						
						
<!-- 						 <b style="color: black">Select Test Name :- </b>  -->
								
								<div class="col-xs-4">
								<label for="testName" style="font-family: 'Lato', sans-serif;font-size: 14px;">Select Test Name :</label>
								<select name="testName" id="testName" class="form-control">
								<c:forEach var="testname" items="${testNames}">
									<option value="${testname}">${testname}</option>
								</c:forEach>
							</select> 
							</div>
							
							&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
							<input style="margin-top:25px; font-family: 'Lato', sans-serif;font-size: 14px;"
							type="button" value="Load Users" class="btn btn-primary" id="loadUsersId" />
							
							<hr style="color: blue" />
					 

            <div class="table-student-submission">
             <img src="${pageContext.request.contextPath}/images/user1.png" width="20px;"/>
					    <span style="font-family: 'Lato', sans-serif;font-size: 14px;">User(s) List</span>
					     &nbsp;&nbsp;&nbsp;  
                            <a href="${pageContext.request.contextPath}/action/adminAvailableQuestionsBankTest">
                            </a>
					    <div style="float: right;">
                            <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Users : <span id="totalUser">${fn:length(userList)}</span></span>
                             </div> 
                <table class="table table-bordered">
                    <thead class="theader">
                        <tr style="background-color: #1192ea;">
                            <th class="submissions">SNo</th>
                            <th class="author">Name</th>
                            <th class="author">Email </th>
                            <th class="score">Batch </th>
                            <th class="submit-date">Photo</th>
                       			<td width="50px">
									<input type="checkbox" name="selectAllUserID"   onClick="selectAll(this)" checked="checked"/>
									</td>	
                        </tr>
                    </thead>

                    <tbody>
                <c:forEach var="userItem" items="${userList}"
									varStatus="status">
									<c:if test="${userItem.assigned=='yes'}">
<!-- 									<tr height="35px" style="color: black; vertical-align: middle;background-color:#D9EDF7;"> -->
<%-- 										<td align="center"><b>${status.count}.</b> --%>
										</td>
										<td>&nbsp;${userItem.name}</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;${userItem.email}</td>
										<td align="center">&nbsp;${userItem.batch}</td>
<!-- 										<td align="center">&nbsp;<img -->
<%-- 								src="${pageContext.request.contextPath}/action/imageByUserId?userid=${userItem.loginid}" height="30px" /></td> --%>
										<td align="center">
												<input type="checkbox" name="userCb" value="${userItem.loginid}" id="userCb"/>
										</td>
									</tr>
									</c:if> 
									<c:if test="${userItem.assigned=='no'}">
									<tr height="35px" style="color: black; vertical-align: middle;">
<%-- 										<td align="center"><b>${status.count}.</b> --%>
										</td>
										<td>&nbsp;${userItem.name}</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;${userItem.email}</td>
										<td align="center">&nbsp;${userItem.batch}</td>
<!-- 										<td align="center">&nbsp;<img -->
<%-- 								src="${pageContext.request.contextPath}/images/user1.png" height="30px" /></td> --%>
										<td align="center">
												<input type="checkbox" name="userCb" id="userCb" value="${userItem.loginid}" checked="checked"/>
										</td>
									</tr>
									</c:if>
								</c:forEach> 
					   
					      <tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
								<tr height="35px" style="color: black">
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td bgcolor="white">&nbsp;</td>
									<td>&nbsp;</td>
									
								</tr>


                    </tbody>
                </table>
                <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Selected User(s) : </span><span id="selectedUsers" style="background-color: yellow;display: inline;font-weight: bold;">${fn:length(userList)}</span>	
							<div style="margin-top:-5px;margin-left:1035px;">
								 
								<input type="button" value="Assign Test" class="btn btn-primary" id="assignTestID" style="font-family: 'Lato', sans-serif;font-size: 14px;"/>
							</div>
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