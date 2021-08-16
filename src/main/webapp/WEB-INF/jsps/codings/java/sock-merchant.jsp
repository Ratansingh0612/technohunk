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
                         <img src="${pageContext.request.contextPath}/images/codings/big-sum.png">
                         <br/> <br/>
             John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
                            <br/> <br/>
                              For example, there are n = 7 socks with colors ar = [1,2,1,2,1,3,2]. There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.
                               <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
					The first line contains n space-separated integers describing the colors ar[i] of the socks in the pile.
					<br/><br/>
					<b>Constraints</b><br/><br/>
		a)</b>		1 <= <b>ar[i]</b> <= 100
					     
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
Return the total number of matching pairs of socks that John can sell.
 	 
              
                  	                   	</p>
                   
               <p  class="subscrollcoll"> Sample Input1 :  
                   	<br/><b>10 &nbsp;&nbsp;20 &nbsp;&nbsp;20 &nbsp;&nbsp;10 &nbsp;&nbsp;10 &nbsp;&nbsp;30&nbsp;&nbsp; 50 &nbsp;&nbsp;10&nbsp;&nbsp; 20</b>
                   	<br/><br/>
                   	Sample Output1 :  <b> 3</b><br/><br/>
                   	<b>Explanantion</b> <br/>
                   	    <img src="${pageContext.request.contextPath}/images/codings/sock-merchant.png">
                   	<br/>
                   	John can match three pairs of socks.	
                   	
                   	</p>
                   	
                      <p  class="subscrollcoll"> Sample Input2 :  
                   	<br/><b>6&nbsp;&nbsp; 5 &nbsp;&nbsp;2 &nbsp;&nbsp;3&nbsp;&nbsp; 5&nbsp;&nbsp; 2&nbsp;&nbsp; 2&nbsp;&nbsp; 1 &nbsp;&nbsp;1&nbsp;&nbsp; 5 &nbsp;&nbsp;1&nbsp;&nbsp; 3&nbsp;&nbsp; 3&nbsp;&nbsp; 3&nbsp;&nbsp; 5</b>
                   	<br/><br/>
                   	Sample Output2 :  <b> 6</b><br/><br/>
                   	</p>
                   	
                   	   <p  class="subscrollcoll"> Sample Input3 :  
                   	<br/><b>4&nbsp;&nbsp; 5 &nbsp;&nbsp;5&nbsp;&nbsp; 5&nbsp;&nbsp; 6 &nbsp;&nbsp;6&nbsp;&nbsp; 4&nbsp;&nbsp; 1 &nbsp;&nbsp;4 &nbsp;&nbsp;4 &nbsp;&nbsp;3 &nbsp;&nbsp;6 &nbsp;&nbsp;6&nbsp;&nbsp; 3&nbsp;&nbsp; 6 &nbsp;&nbsp;1&nbsp;&nbsp; 4&nbsp;&nbsp; 5 &nbsp;&nbsp;5&nbsp;&nbsp; 5</b>
                   	<br/><br/>
                   	Sample Output3 :  <b> 9</b><br/><br/>
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
  <%@include file="/dcode/java/sock-merchant-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>