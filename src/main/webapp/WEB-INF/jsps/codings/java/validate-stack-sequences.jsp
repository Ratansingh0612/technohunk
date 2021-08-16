<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
       <%@include file="/resources.jsp" %>
    <title>${companyName} -${item.title}</title>
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
   
    
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- PRELOADER -->
    <div id="preloader">

    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
       <!-- HEADER -->
         <!-- header -->
   <k:if test="${sessionScope.user_session_data.role=='user'}">	
      <%@include file="/uheader.jsp" %>
      </k:if>
      <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
      <%@include file="/uheader.jsp" %>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
       <%@include file="/theader.jsp" %>
       </k:if>
             <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp" %>
           </k:if>
                <k:if test="${sessionScope.user_session_data.role=='guest'}">	
       <%@include file="/guestheader.jsp" %>
           </k:if>
           
    <!-- / header -->
    <!-- END / HEADER -->

    <!-- PROFILE FEATURE -->
    <section class="profile-feature">
        <div class="awe-parallax bg-profile-feature"></div>
      	  <div class="awe-overlay overlay-color-3"></div>
        <div class="container">
            <div class="info-author">
                <div class="image">
                     <img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                </div>    
                <div class="name-author">
                    <h2 class="big" style="color:white;;font-size: 24px;">${sessionScope.user_session_data.name}</h2>
                </div>     
                <div class="address-author">
                    <i class="fa fa-map-marker"></i>
             <h3>${sessionScope.user_session_data.address}&nbsp;&nbsp;(${sessionScope.user_session_data.batch})</h3>
                </div>
            </div>
                     <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <%@include file="../../admin/content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
    <!-- BLOG -->
    <section class="blog">
        <div class="container" style="background-color: white;">
        	 <%@ include file="pheader.jsp"%>
            <div class="row">
                <!-- BLOG LIST -->
                <div class="col-md-8">
                    <div class="blog-list-content">
                   	  <!-- POST -->
                   	   <%@ include file="ppost.jsp"%>
                          <span style="margin-left: 20px;font-size: 18px;color:#61b91a;width:400px;font-weight: bold;">	
                         		 Problem Statement : -
                          </span> 	
                         <p  class="scrollcoll">
                         <img src="${pageContext.request.contextPath}/images/codings/puzzle.jpg">
                         <br/>
                       Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
                         </p>
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
                   	first line represents pushed operations
                   	& second line represents popped operations
						</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 									return either true or false as per problem statement described above
                   	                   	</p>
                   	                   	
                   
                   <p  class="subscrollcoll">Sample Input :  
                   	<br/>
                   	<b>1&nbsp;&nbsp;2&nbsp;&nbsp;3&nbsp;&nbsp;4&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> pushed </b><br/>
                   		<b>4&nbsp;&nbsp;5&nbsp;&nbsp;3&nbsp;&nbsp;2&nbsp;&nbsp;1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> popped  </b>
                   	<br/><br/>
                   	Sample Output :  <b>true</b><br/><br/>
                   	<b>Explanation:</b><br/>
We might do the following sequence:<br/>
push(1), push(2), push(3), push(4), pop() -> 4,<br/><br/>
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 
                   	</p>
                   	
                   	
                  <p  class="subscrollcoll">Sample Input :  
                   	<br/>
                   	<b>1&nbsp;&nbsp;2&nbsp;&nbsp;3&nbsp;&nbsp;4&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> pushed </b><br/>
                   		<b>4&nbsp;&nbsp;3&nbsp;&nbsp;5&nbsp;&nbsp;1&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> popped  </b>
                   	<br/><br/>
                   	Sample Output :  <b>false</b><br/><br/>
                   	<b>Explanation:</b><br/>
1 cannot be popped before 2.
                   	</p>
                   	
                        
                        
                    </div>
                </div>
                <!-- END / BLOG LIST -->

                <!-- SIDEBAR -->
           <%@include file="/sidebar.jsp" %>
                <!-- END / SIDEBAR -->
  <br/>     <br/>      
      
            </div>
             <%@include file="/coding-area.jsp" %>
        </div>
 
    </section>
    <!-- END / BLOG -->
  

    
    
    <!-- FOOTER -->
 <!-- FOOTER -->
    <footer id="footer" class="footer">
<%--    <%@include file="/ffooter.jsp" %> --%>

       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
    <!-- END / FOOTER -->


    


</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
  <%@include file="/editor-settings.jsp" %>
  <%@include file="/dcode/java/validate-stack-sequences-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>