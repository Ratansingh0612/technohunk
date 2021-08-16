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
    <title>${companyName} -${item.title} </title>
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
                     <img src="${pageContext.request.contextPath}/images/codings/egg-problem.jpg">
                <br/> 
                You are given K eggs, and you have access to a building with N floors from 1 to N.    <br/>  <br/> 
                Each egg is identical in function, and if an egg breaks, you cannot drop it again.<br/>  <br/> 
                   You know that there exists a floor F with <b>0 <= F <= N</b> such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
                   Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).<br/>  <br/>  
                   Your goal is to know with certainty what the value of F is.<br/>  <br/> 
                   What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?
                   </p>
                   
                    <p  class="probscrollcoll"> <b>Input Format </b>  <br/>  
                   		The first line integer represent given <b>K</b> eggs, 
                   		The second line integer represent <b>N</b>,  you have access to a building with N floors from 1 to N.
                   		<br/>		<br/>
                   </p>
                   
                   
                   <p  class="probscrollcoll"><b>Ex-1</b>
                   	 Sample Input :
                   		<br/>  
                   		1
                   		<br/>
                   		2
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  2</p>
                         
                         <p  class="probscrollcoll"> <b>Explanation :</b>
                   		<br/>
                   		Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.<br/>
Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.<br/>
If it didn't break, then we know with certainty F = 2.<br/>
Hence, we needed 2 moves in the worst case to know what F is with certainty.  <br/>
                   		
                   		</p>
                         
                         
                           <p  class="probscrollcoll"><b>Ex-2</b> Sample Input :
                   		<br/>  
                   		2
                   		<br/>
                   		6
                   		
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  3</p>
                         
                           <p  class="probscrollcoll"><b>Ex-3</b> Sample Input :
                   		<br/>  
                   		3
                   		<br/>
                   		14
                   		
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  4</p>
                        
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
  <%@include file="/dcode/java/super-egg-drop-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>