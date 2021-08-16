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
                        <%--  <p  class="scrollcoll">
                         
                        </p> --%>
                   <p  class="scrollcoll"> 
                    <img src="${pageContext.request.contextPath}/images/codings/count-word.jpg"> <br/> 
                 <br/>
                 You are given an array of  integers, ar = [ar[0],ar[1],....ar[n-1]], and a positive integer, k. Find and print the number of (i,j) pairs where i < j and ar[i] + ar[j] is divisible by k.     
                <br/><br/>
                For example, ar = [ 1,2,3,4,5,6] and k = 5. Our three pairs meeting the criteria are [1,4], [2,3] and [4,6].
                 </p>

       <p  class="probscrollcoll"><b>Input Format</b> :  
                   	
	 	<br/>The <b>first line</b> contains  integers n.	<br/> 
The <b>second line</b> contains  contains  integers n. <br/> 
 The <b>third line</b> contains n space-separated integers describing the values of ar[ar[0],ar[1],....ar[n-1]]. 
    
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 	Return the number of (i,j) pairs where i<j and a[i] + a[j] is evenly divisible by k.>
              
                  	                   	</p>
                   
                   <p  class="probscrollcoll"> <b>Sample Input1 :</b>
                  		 <br/>6
                   		<br/>3
                   		<br/>  
                   		1 &nbsp;&nbsp;3&nbsp;&nbsp; 2 &nbsp;&nbsp;6&nbsp;&nbsp; 1&nbsp;&nbsp; 2
                   		
                   		<br/>  <br/>  
                   		<b>Sample Output1 :</b>  5
                   		<br/>  <br/>  
                   		<b>Explanation</b>
						<br/>
						Here are the 5 valid pairs when k = 3:<br/>
a)	(0 , 2) -> ar[0] + ar[2] = 1 + 2 = 3 <br/>
b)	(0 , 5) -> ar[0] + ar[5] = 1 + 2 = 3<br/>
c)	(1 , 3) -> ar[1] + ar[3] = 3 + 6 = 9<br/>
d)	(2 , 4) -> ar[2] + ar[4] = 2 + 1 = 3<br/>
e)	(4 , 5) -> ar[4] + ar[5] = 1 + 2 = 3
							
						 
                        </p>
                          <p  class="probscrollcoll"> <b>Sample Input2 :</b>  
                          <br/>2
                   		<br/>2
                          <br/>  
                   		8&nbsp;&nbsp; 10&nbsp;
                   		
                   		<br/>  <br/>  
                   		 <b>Sample Output2 :</b>  1
                   		 <br/>  <br/>  
                        </p>
                        
                        <p  class="probscrollcoll"> <b>Sample Input3 :</b>  
                          <br/>5
                   		<br/>2
                          <br/>  
                   		5 &nbsp;&nbsp;9 &nbsp;&nbsp;10&nbsp;&nbsp; 7&nbsp;&nbsp; 4
                   		<br/>  <br/>  
                   		 <b>Sample Output3 :</b>  4
                   		 <br/>  <br/>  
                        </p>
                        <p  class="probscrollcoll"> <b>Sample Input4 :</b>  
                          <br/>20
                   		<br/>7
                          <br/>  
                   		36&nbsp;&nbsp; 46 &nbsp;&nbsp;25 &nbsp;&nbsp;97&nbsp;&nbsp; 57 &nbsp;&nbsp;14&nbsp;&nbsp; 21 &nbsp;&nbsp;50 &nbsp;&nbsp;75&nbsp;&nbsp; 58&nbsp;&nbsp; 54 &nbsp;&nbsp;32 &nbsp;&nbsp;73&nbsp;&nbsp; 11&nbsp;&nbsp; 36&nbsp;&nbsp; 22 &nbsp;&nbsp;95 &nbsp;&nbsp;46 &nbsp;&nbsp;54 &nbsp;&nbsp;61
                   		<br/>  <br/>  
                   		 <b>Sample Output4 :</b>  16
                   		 <br/>  <br/>  
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
  <%@include file="/dcode/java/divisible-sum-pairs-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>