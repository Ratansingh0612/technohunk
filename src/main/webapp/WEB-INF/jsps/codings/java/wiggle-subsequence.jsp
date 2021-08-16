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
                         <img src="${pageContext.request.contextPath}/images/codings/sorting-number.png">
                         <br/> <br/>
                  A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
                    <br/> <br/>
                   For example,  <span style="background-color: #dde9ef;">[1,7,4,9,2,5]</span> is a wiggle sequence because the differences <span style="background-color: #dde9ef;">(6,-3,5,-7,3)</span> are alternately positive and negative. In contrast,  <span style="background-color: #dde9ef;">[1,4,7,2,5]</span> and  <span style="background-color: #dde9ef;">[1,7,4,5,5]</span> are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.        
                    <br/> <br/>
Given a sequence of integers, return the length of the longest subsequence that is a <b>wiggle sequence</b>. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
                             </p>
                             
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
					Array of integers  as an input separated with space in single line.      
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 	 Return the length of the longest subsequence that is a wiggle sequence
              
                  	                   	</p>
                   
               <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>1&nbsp;&nbsp;7&nbsp;&nbsp;4&nbsp;&nbsp;9&nbsp;&nbsp;2&nbsp;&nbsp;5</b>
                   	<br/><br/>
                   	Sample Output :  <b> 6</b><br/><br/>
                   	<b>Explanation:</b> <br/>
The entire sequence is a wiggle sequence.
                   	
                   	</p>
                   	
                   	 <p  class="probscrollcoll"> Sample Input :  
                   	<br/><b>1&nbsp;&nbsp;17&nbsp;&nbsp;5&nbsp;&nbsp;10&nbsp;&nbsp;13&nbsp;&nbsp;15&nbsp;&nbsp;10&nbsp;&nbsp;5&nbsp;&nbsp;16&nbsp;&nbsp;8</b>
                   	<br/><br/>
                   	Sample Output :  <b>7</b><br/><br/>
                   	<b>Explanation:</b> <br/>
				There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
                   	</p>
                   	
                   	 <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>1&nbsp;&nbsp;2&nbsp;&nbsp;3&nbsp;&nbsp;4&nbsp;&nbsp;5&nbsp;&nbsp;6&nbsp;&nbsp;7&nbsp;&nbsp;8&nbsp;&nbsp;9</b>
                   	<br/><br/>
                   	Sample Output :  <b>2</b><br/>
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
  <%@include file="/dcode/java/wiggle-subsequence-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>