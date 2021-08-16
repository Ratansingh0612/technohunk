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
                         <img src="${pageContext.request.contextPath}/images/codings/drawing-book.png">
                         <br/> <br/>
Brie's Drawing teacher asks her class to open their books to a page number. Brie can either start turning pages from the front of the book or from the back of the book. She always turns pages one at a time. When she opens the book, page 1 is always on the right side:
                            <br/> <br/>
                             <img src="${pageContext.request.contextPath}/images/codings/drawing-book1.png">
                            <br/> <br/>
                            When she flips page 1, she sees pages 2 and 3. Each page except the last page will always be printed on both sides. The last page may only be printed on the front, given the length of the book. If the book is n pages long, and she wants to turn to page p, what is the minimum number of pages she will turn? She can start at the beginning or the end of the book.
                          <br/> <br/>
                          Given n and p, find and print the minimum number of pages Brie must turn in order to arrive at page p.
                         </p>   
                               <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
					
	The first line contains an integer n, the number of pages in the book. <br/>
The second line contains an integer, p, the page that Brie's teacher wants her to turn to.
	
	
	<br/><br/>
					<b>Constraints</b><br/><br/>
		<b>a)</b>		1 <= n <= 10^5<br/>
		<b>b)</b>		1 <= p <= n
					     
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
Print an integer denoting the minimum number of pages Brie must turn to get to page p.
              
                  	                   	</p>
                   
               <p  class="subscrollcoll"> Sample Input1 :  
                   	<br/><b>6</b>
                   	<br/><b>2</b><br/><br/>
                   	Sample Output1 :  <b> 1</b><br/><br/>
                   	<b>Explanantion</b> <br/>
                   	If Brie starts turning from page 1, she only needs to turn 1 page:<br/>
                   	    <img src="${pageContext.request.contextPath}/images/codings/drawing-book2.png"><br/>
                   	    If Brie starts turning from page 6, she needs to turn 2 pages:<br/>
                   	    <img src="${pageContext.request.contextPath}/images/codings/drawing-book3.png">
                   	<br/>
                   Because we want to print the minumum number of page turns, we print 1 as our answer.
                   	
                   	</p>
                   	
                    <p  class="subscrollcoll"> Sample Input2 :  
                   	<br/><b>5</b>
                   	<br/><b>4</b><br/><br/>
                   	Sample Output2 :  <b> 0</b>
                   	</p>
                   	
                   	   <p  class="subscrollcoll"> Sample Input3 :  
                   	<br/><b>4</b>
                   	<br/><b>4</b><br/><br/>
                   	Sample Output3 :  <b> 0</b>
                   	</p>
                
                  	   <p  class="subscrollcoll"> Sample Input4 :  
                   	<br/><b>5</b>
                   	<br/><b>1</b><br/><br/>
                   	Sample Output4 :  <b> 0</b>
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
  <%@include file="/dcode/java/drawing-book-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>