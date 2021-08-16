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
                    <img src="${pageContext.request.contextPath}/images/codings/happy-birthday-choco.jpg"> <br/> 
                 <br/>
                 <b>Lily</b> has a chocolate bar that she wants to share it with Ron for his birthday. Each of the squares has an integer on it. She decides to share a contiguous segment of the bar selected such that the length of the segment matches Ron's birth month and the sum of the integers on the squares is equal to his birth day. You must determine how many ways she can divide the chocolate.
                  <br/>  <br/> Consider the chocolate bar as an array of squares, s = [2,2,1,3,2] . She wants to find segments summing to Ron's birthday, d = 4 with a length equalling his birth month, m = 2. In this case, there are two segments meeting her criteria: [2,2] and [1,3].
                 
                 </p>

       <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/> 	<br/>
					The <b>first line</b> contains n space-separated integers s[i], the numbers on the chocolate squares where 0 <= i < n. 
	 	<br/>The <b>second line</b> contains  integers d  Ron's birth day.	<br/> 
The <b>third line</b> contains  integers m, Ron's  birth month. 
 
    
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 	Return an integer denoting the total number of ways that Lily can portion her chocolate bar to share with Ron.
              
                  	                   	</p>
                   
                   
                   <p  class="probscrollcoll"> <b>Sample Input1 :</b>
                   		<br/>  
                   		1 &nbsp;&nbsp;2&nbsp;&nbsp; 1&nbsp;&nbsp; 3&nbsp;&nbsp; 2
                   		<br/>3
                   		<br/>2
                   		
                   		<br/>  <br/>  
                   		<b>Sample Output1 :</b>  2
                   		<br/>  <br/>  
                   		<b>Explanation</b>
<br/>  Lily wants to give Ron m = 2 squares summing to d = 3. The following two segments meet the criteria
                   		<br/>  
                   		<img src="${pageContext.request.contextPath}/images/codings/birthday-chocolate-use1.png">
                   	<br/>  	 
                        </p>
                          <p  class="probscrollcoll"> <b>Sample Input2 :</b>  <br/>  
                   		1&nbsp;&nbsp; 1&nbsp;&nbsp; 1 &nbsp;&nbsp;1 &nbsp;&nbsp;1 &nbsp;&nbsp;1
                   		<br/>3
                   		<br/>2
                   		<br/>  <br/>  
                   		 <b>Sample Output2 :</b>  0
                   		 <br/>  <br/>  
                   		<b>Explanation</b>
<br/>  Lily only wants to give Ron m = 2 consecutive squares of chocolate whose integers sum to d = 3. There are no possible pieces satisfying these constraints:
                   		<br/>  
                   		<img src="${pageContext.request.contextPath}/images/codings/birthday-chocolate-use2.png">
                   	<br/>
                   	Thus, we print 0 as our answer.  	 
                        </p>
                        
                         <p  class="probscrollcoll"> <b>Sample Input3 :</b>  <br/>  
                   		2&nbsp;&nbsp; 5&nbsp;&nbsp; 1&nbsp;&nbsp; 3&nbsp;&nbsp; 4&nbsp;&nbsp; 4&nbsp;&nbsp; 3&nbsp;&nbsp; 5&nbsp;&nbsp; 1&nbsp;&nbsp; 1&nbsp;&nbsp; 2 &nbsp;&nbsp;1 &nbsp;&nbsp;4&nbsp;&nbsp; 1&nbsp;&nbsp; 3 &nbsp;&nbsp;3 &nbsp;&nbsp;4 &nbsp;&nbsp;2 &nbsp;&nbsp;1
                   		<br/>18
                   		<br/>7
                   		
                   		<br/>  <br/>  
                   		 <b>Sample Output3 :</b>  3
                        </p>
                        
                          <p  class="probscrollcoll"> <b>Sample Input4 :</b>  <br/>  
                   		4 &nbsp;&nbsp;5 &nbsp;&nbsp;4&nbsp;&nbsp; 2 &nbsp;&nbsp;4&nbsp;&nbsp; 5 &nbsp;&nbsp;2&nbsp;&nbsp; 3 &nbsp;&nbsp;2 &nbsp;&nbsp;1 &nbsp;&nbsp;1&nbsp;&nbsp; 5&nbsp;&nbsp; 4
                   		<br/>15
                   		<br/>4
                   		
                   		<br/>  <br/>  
                   		 <b>Sample Output4 :</b>  3
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
  <%@include file="/dcode/java/birthday-chocolate-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>