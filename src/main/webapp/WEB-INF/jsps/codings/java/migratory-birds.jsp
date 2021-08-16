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
                         <img src="${pageContext.request.contextPath}/images/codings/migratory-bird.png">
                         <br/> <br/>
You have been asked to help study the population of birds migrating across the continent. Each type of bird you are interested in will be identified by an integer value. Each time a particular kind of bird is spotted, its id number will be added to your array of sightings. You would like to be able to find out which type of bird is most common given a list of sightings. Your task is to print the type number of that bird and if two or more types of birds are equally common, choose the type with the smallest ID number.
                            <br/> <br/>
                            For example, assume your bird sightings are of types arr = [1,1,2,2,3]. There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.
                          </p>  
                  <p  class="probscrollcoll"><b>Input Format</b> :  	<br/>
The first line describes arr as n space-separated integers representing the type numbers of each bird sighted.
                  	              <b>Constraints</b>	<br/>	<br/>
a)	5 <= n <= 2 X 10^5<br/>
b)	It is guaranteed that each type is 1, 2, 3, 4, or 5.
                  	              
                  	                   	</p>
			
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
Return the type number of the most common bird; if two or more types of birds are equally common, choose the type with the smallest ID number.
 	 
              
                  	                   	</p>
                   
               <p  class="subscrollcoll"> Sample Input1 :  
                   	<br/><b>1 &nbsp;&nbsp;4 &nbsp;&nbsp;4 &nbsp;&nbsp;4 &nbsp;&nbsp;5&nbsp;&nbsp; 3</b>
                   	<br/><br/>
                   	Sample Output1 :  <b> 4</b><br/><br/>
                   	<b>Explanation</b> <br/>
                   	The different types of birds occur in the following frequencies:<br/>
Type 1: 1 bird<br/>
Type 2: 0 birds<br/>
Type 3: 1 bird<br/>
Type 4: 3 birds<br/>
Type 5: 1 bird<br/>
The type number that occurs at the highest frequency is type 4, so we print 4 as our answer.
                   	
                   	</p>
                   	
                      <p  class="subscrollcoll"> Sample Input2 :  
                   	<br/><b>1 &nbsp;&nbsp;2&nbsp;&nbsp; 3&nbsp;&nbsp; 4 &nbsp;&nbsp;5&nbsp;&nbsp; 4&nbsp;&nbsp; 3 &nbsp;&nbsp;2&nbsp;&nbsp; 1&nbsp;&nbsp; 3 &nbsp;&nbsp;4</b>
                   	<br/><br/>
                   	Sample Output2 :  <b> 3</b><br/><br/>
                   	<b>Explanation 1</b><br/>
The different types of birds occur in the following frequencies:<br/>
Type 1: 2 bird<br/>
Type 2: 2 birds<br/>
Type 3: 3 bird<br/>
Type 4: 3 birds<br/>
Type 5: 1 bird<br/>
Two types have a frequency of 3, and the lower of those is type 4.
                   	
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
  <%@include file="/dcode/java/migratory-birds-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>