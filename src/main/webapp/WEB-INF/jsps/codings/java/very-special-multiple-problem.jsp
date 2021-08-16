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
    <title>${companyName} -Very Special Multiple Problem </title>
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
                   <p  class="probscrollcoll">
                  	Jhon and Michal play the following game:
                  	<br/>
                  	For every integer <b>X</b> Jhon gives, Michal has to find smallest positive integer <b>Y,</b>
                  	such that <b>X*Y</b> (X multiplied by Y) consists of series of one or more 4's followed by zero or more 0's. For instance, 404 would be invalid answer, but  4400,440, and 444 are all valid.
                  	              	<br/>           	<br/>
                  	   Your program will read the value of <b>X</b> and deduce the number <b>Z=2a+b,</b> where 
                  	   <b>a</b> is the number of 4's and b is the number of 0's in the answer <b>X*Y</b>            	
                  	
                   </p>
                   
                    <p  class="probscrollcoll"> <b>Input Format </b>  <br/>  
						 An integer number to be used as <b>X</b> in one turn of the game described above.
                   		<br/>		
                   </p>
                   
                   	 <p  class="probscrollcoll"> <b>Output Format </b>  <br/>  
                   	 for every <b>X</b>, print the output <b>2a+b</b> so that the string of <b>a</b> 4's followed by <b>b</b> 0's
                   	 is the answer to the problem described above. 
                   	 </p>
                   
                   <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   		4
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  2</p>
                         
                         
                           <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   	80
                   		
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  4</p>
                        <p  class="probscrollcoll"> <b>Explanation :</b>
                   		<br/>  
                   		For the first test case, the smallest such multiple of <b>4</b> is <b>4</b> itself, Hence y is 1, a is 1 and b=0.
                   		<br/>
                   		the required value Z=2a + b is 2. 
                   		<br/>  <br/>  
                   		For the second test case,Y=5 and 400 is the minimum multiple. Hence value of <b>a</b> is <b>1</b>
                   		,<b>b</b> is <b>2</b><br/> and <b>Z=2a + b</b> <b>4</b>.
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
  <%@include file="/dcode/java/special-multiple-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>