<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <META HTTP-EQUIV="Refresh" CONTENT="10">
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Current logged in user(s)</title>
       
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
   <!-- END / CONTENT BAR -->
 	
    <!-- COURSE CONCERN -->
  <section style="padding-top: 0px;padding-bottom:10px;background-color: #eee;" id="quizz-intro-section">
   <section id="topcontent">
   		</section>
        <div class="container" style="background-color: white;min-height: 500px;">
     
        <img src="${pageContext.request.contextPath}/images/icon/user_login.png" style="height: 50px;">
        		
               <span style="font-size: 16px;margin-right: 100px;">Misc -> Current logged in user(s)</span>
               Current Time : <%=new Date()%>
               
           <k:if test="${loggedUsers.size() == 0}">
              <h3 style="font-size: 18px;"><img src="${pageContext.request.contextPath}/images/icon/cheers.png" style="height: 32px;margin-right: 10px;"> - No user is logged into the application right now!.</h3>
           </k:if> 
							<hr style="color: blue" />		
						 
            <div class="table-student-submission">
            <img src="${pageContext.request.contextPath}/images/icon/cheers.png" style="height: 32px;margin-right: 2px;">
            <span style="font-size: 14px;">User(s) List:-</span>
            
            			
					    <div style="float: right;">
								<img src="../images/favicon.ico" height="30px">&nbsp;<span style="font-size: 14px;">Logged in User(s) :</span> <b><span id="totalUsers">${fn:length(loggedUsers)}</span></b>
							</div>
                <table class="table table-bordered" id="tab1">
                    <thead>
                        <tr style="background-color: #607D8B;vertical-align:middle;">
                            <th class="submissions" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">SNo</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Name</th>
                                    <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Email</th>
                            <th class="author" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Role </th>
                            <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Address</th>
                               <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Logged in Time</th>
                                <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;">Photo</th>
                                     <th class="submit-date" style="color: white;font-family: 'Lato', sans-serif;font-size: 14px;width:11%">Action</th>
                        </tr>
                    </thead>
                    <tbody id="partialContent">
                    		<k:forEach var="item" items="${loggedUsers}" varStatus="ooooo">
					       <tr style="color: black;vertical-align:middle;font-size: 13px;">
					     <td bgcolor="white">&nbsp;${ooooo.count}</td>
					   	   <td bgcolor="white">&nbsp;${item.name}</td>
					   	    	   <td bgcolor="white">&nbsp;${item.loginId}</td>
					   	  <td bgcolor="white">&nbsp;${item.role}</td>
					   	  <td bgcolor="white">&nbsp;${item.address}</td>
					   	   <td bgcolor="white">&nbsp;${item.loggedInTime}</td>
					   	     <td bgcolor="white">&nbsp;<img src="${pageContext.request.contextPath}/images/icon/cheers.png" style="height: 32px;"/></td>
					   	    <td bgcolor="white">&nbsp;
					   	       <input type="button" value="Expel" class="mc-btn btn-style-1" id="sendLink" style="background-color: #00bcd4;;margin: 0px;font-size: 14px;width: 100px;"/> 
					   		</td>
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