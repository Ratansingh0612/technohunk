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
    <title>${companyName} -Is Possible Problem? </title>
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
                        <%--  <p  class="scrollcoll">
                          <img src="${pageContext.request.contextPath}/images/codings/fact-num.png">
                        </p> --%>
                   <p  class="probscrollcoll">
                   Consider a pair of integers, (a,b). We can perform the following operations on
                   (a,b) in any order, zero or more times:<br/>
                   1) (a,b) -> (a+b,b)<br/>
                   2) (a,b) -> (a,a+b)
                    <br/><br/>
                    For example, you can start with (1,4), perform the operation (1+4,4) to get (5,4),perform
                    the operation (5,5+4) to get (5,9), and perform the operation (5,5+9) to get (5,14).
                   </p>
                   
                    <p  class="probscrollcoll"> <b>Function Description </b>  <br/>  
						Complete the isPossible function in the editor below. It has four parameters:
						1. An integer, a. <br/>  
						2. An integer, b. <br/>  
						3. An integer, c. <br/>  
						4. An integer, d. <br/>  
						the function must return a string denoting whether or not you can convert
						(a,b) to (c,d) by performing zero or more of the operations specified above.
						If it is possible, return the string <b>Yes</b> otherwise return <b>No</b> .  

                   	 </p>
                   
                   <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   		1
                   		<br/>
                   		4
                   		<br/>
                   		5
                   		<br/>
                   		9
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  Yes</p>
                         
                           <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   		1
                   		<br/>
                   		2
                   		<br/>
                   		3<br/>
                   		6
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  No</p>
                        <p  class="probscrollcoll"> <b>Explanation :</b>
                   		<br/>  
                   		 For the first test case we can convert (1,4) to (5,9) by performing the following
                   		 sequence of operations : (1,4) -> (5,4) -> (5,9), thus we return <b>Yes</b> as our answer 
                   		 <br/><br/>
                   		 For the second test case if we tried the operation (1,2) ->(3,2), we can successfully 
                   		 match c=3 but so subsequent possible operation would ever get us to d=6. The only other option for 
                   		 our test case is <br/>(1->2) - > (1,3); we would certainly perform subsequent operations to get us d=6
                   		 but no operation would ever get us to c=3 because any value added to a after this first operation would 
                   		 result in a>c. Thus, we can return <b>No</b> as out answer. 
                   		 
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
  <%@include file="/dcode/java/is-possible-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>