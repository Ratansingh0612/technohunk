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
                         <img src="${pageContext.request.contextPath}/images/codings/friend-age.png">
                         <br/>
                         Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person. 
  <br/> <br/>
Person A will NOT friend request person B (B != A) if any of the following conditions are true:  
 <img src="${pageContext.request.contextPath}/images/codings/friend-age-formula.png">
  <br/> <br/>
Otherwise, A will friend request B.<br/> <br/>
Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
<br/> <br/>
How many total friend requests are made?
                         </p>
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
The array of integers represents their ages  and ages[i] is the age of the ith person             
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 	print the total friend requests
                  	                   	</p>
                   	                   	
                   
                   <p  class="subscrollcoll">Sample Input1 :  
                   	<br/>
                   	<b>16 &nbsp;&nbsp;16</b>
                   	<br/><br/>
                   	Sample Output1 : 	<br/>
                   	 <b>2</b><br/><br/>
                   	<b>Explanation</b><br/>
             		  2 people friend request each other.
                   	</p>
                   	
                   	 <p  class="subscrollcoll">Sample Input2 :  
                   	<br/>
                   	<b>16 &nbsp;&nbsp;17&nbsp;&nbsp;18</b>
                   	<br/><br/>
                   	Sample Output2 : 
                   	<br/>
                   	 <b>2</b><br/><br/>
                   	<b>Explanation</b><br/>
             		  Friend requests are made 17 -> 16, 18 -> 17.
                   	</p>
                   	
                   	
                   	 <p  class="subscrollcoll">Sample Input3 :  
                   	<br/>
                   	<b>20 &nbsp;&nbsp;30&nbsp;&nbsp;100&nbsp;&nbsp;110&nbsp;&nbsp;120</b>
                   	<br/><br/>
                   	Sample Output3 :  
                   		<br/>
                   	<b>3</b><br/><br/>
                   	<b>Explanation</b><br/>
             		 Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
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
  <%@include file="/dcode/java/friends-of-appropriate-ages-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>