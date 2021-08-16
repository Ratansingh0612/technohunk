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
                         <img src="${pageContext.request.contextPath}/images/codings/birthday-cake-candle.png">
                         <br/> <br/>
                         You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. When she blows out the candles, she'll only be able to blow out the tallest ones. Your task is to find out how many candles she can successfully blow out.
                            <br/> <br/>
                            For example, if your niece is turning 4 years old, and the cake will have 4 candles of height <b>4, 4, 1, 3,</b> she will be able to blow out 2 candles successfully, since the tallest candles are of height 4 and there are 2 such candles.
                          </p>  
                  <p  class="probscrollcoll"><b>Input Format</b> :  	<br/>
The first line contains n space-separated integers, where each integer ar[i] describes the height of candle i.
                  	              <b>Constraints</b>	<br/>	<br/>
1 <= n <= 10^5	<br/>
1 <= ar[i] <= 10^7
                  	              
                  	                   	</p>
			
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
Print the number of candles that can be blown out 
 	 
              
                  	                   	</p>
                   
               <p  class="subscrollcoll"> Sample Input1 :  
                   	<br/><b>3 &nbsp;&nbsp;2 &nbsp;&nbsp;1 &nbsp;&nbsp;3</b>
                   	<br/><br/>
                   	Sample Output1 :  <b> 2</b><br/><br/>
                   	<b>Explanation</b> <br/>
                   	   We have one candle of height 1, one candle of height 2, and two candles of height 3. Your niece only blows out the tallest candles, meaning the candles where height = 3. Because there are 2 such candles, we print 2 on a new line.
                   	</p>
                   	
                      <p  class="subscrollcoll"> Sample Input2 :  
                   	<br/><b>18&nbsp;&nbsp; 90&nbsp;&nbsp; 90&nbsp;&nbsp; 13&nbsp;&nbsp; 90&nbsp;&nbsp; 75&nbsp;&nbsp; 90&nbsp;&nbsp; 8&nbsp;&nbsp; 90 &nbsp;&nbsp;43</b>
                   	<br/><br/>
                   	Sample Output2 :  <b> 5</b><br/><br/>
                   	</p>
                   	
                       <p  class="subscrollcoll"> Sample Input3 :  
                   	<br/><b>82&nbsp;&nbsp;  49&nbsp;&nbsp;  82 &nbsp;&nbsp; 82&nbsp;&nbsp;  41&nbsp;&nbsp;  82&nbsp;&nbsp;  15&nbsp;&nbsp;  63 &nbsp;&nbsp; 38 &nbsp;&nbsp; 25
</b>
                   	<br/><br/>
                   	Sample Output3 :  <b> 4</b><br/><br/>
                   	</p>
                   	
                  <p  class="subscrollcoll"> Sample Input3 :  
                   	<br/><b>44 &nbsp;&nbsp;53&nbsp;&nbsp; 31&nbsp;&nbsp; 27&nbsp;&nbsp; 77 &nbsp;&nbsp;60&nbsp;&nbsp; 66 &nbsp;&nbsp;77&nbsp;&nbsp; 26 &nbsp;&nbsp;36

</b>
                   	<br/><br/>
                   	Sample Output3 :  <b> 2</b><br/><br/>
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
  <%@include file="/dcode/java/birthday-cake-candles-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>