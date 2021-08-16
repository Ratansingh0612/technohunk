<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-teaching.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
     <%@include file="/resources.jsp" %>
    <title>${companyName} - Course Details</title>
<style>
table, th, td {
    border: 1px solid black;
}
.scrollcoll {
    padding: 2%;
    font-size: 15px;
    width: 40%;
    background: white;
    border-left: 5px solid #1b7175;
    margin: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
</style>
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

     <!-- PRELOADER -->
    <div id="preloader">
        <div class="pre-icon">
            <div class="pre-item pre-item-1"></div>
            <div class="pre-item pre-item-2"></div>
            <div class="pre-item pre-item-3"></div>
            <div class="pre-item pre-item-4"></div>
        </div>
    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
     <%@include file="../user/uheader.jsp" %>
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
                    <h2 class="big">${sessionScope.user_session_data.name}</h2>
                </div>     
                <div class="address-author">
                    <i class="fa fa-map-marker"></i>
                    <h3>${sessionScope.user_session_data.address}</h3>
                </div>
            </div>
      <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->
<br/>
		    
		<div class="container">
		<%int count = 1;%>
		<k:forEach items="${topicList}" var="item">
			<%while(count>0){%>
		 
		 <img src="${pageContext.request.contextPath}/images/feature/${item.image}" alt=""style="width: 6%;">	
			<%
			count--;}%>
			<div class="meta-categories"><a href="#" style="margin-top: -50px;">${item.tname}</a></div>
			</k:forEach>
			<%-- <h3 style="text-align: left;font-size: 18px;font-family:sans-serif;color: black;"><b>Core-Java</b> <img src="${pageContext.request.contextPath}/images/feature/core.jpg"></h3> --%>

       <ul style="list-style: none; float: left; width: 100%">
  <k:forEach items="${topicList}" var="item">
	<li class="scrollcoll">
	 ${item.topic}
	</li>
	</k:forEach>
	
</ul>

<!-- 			<table style="width: 100%;    line-height: 3em;"> -->
<!-- 				<tbody> -->
<!-- 				<tr style="background-color: yellow;"class="core_java_tbl"> -->
<!-- 					<td><b>S.NO.</b></td> -->
<!-- 					<td><b>Topic</b></td> -->
<!-- 					<td><b>Duration</b></td> -->
<!-- 				</tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td>1</td> -->
<!-- 						<td>OOPS</td> -->
<!-- 						<td></td> -->
<!-- 						</tr> -->
<!-- 							<tr class="core_java_tbl"> -->
<!-- 						<td>2</td> -->
<!-- 						<td>Java Virtual Machine</td> -->
<!-- 						<td></td></tr> -->
<!-- 								<tr class="core_java_tbl"> -->
<!-- 						<td>3</td> -->
<!-- 						<td>Package</td> -->
<!-- 						<td></td></tr> -->
<!-- 									<tr class="core_java_tbl"> -->
<!-- 						<td>4</td> -->
<!-- 						<td>Exception Handling</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td>5</td> -->
<!-- 						<td>String Handling</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td>6</td> -->
<!-- 						<td>File Input and output </td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td>7</td> -->
<!-- 						<td>Serialization</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td>8</td> -->
<!-- 						<td>Immutable class and Object</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >9</td> -->
<!-- 						<td>cloning</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >10</td> -->
<!-- 						<td>Annotation</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td>11</td> -->
<!-- 						<td>Reflection</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td>12</td> -->
<!-- 						<td>Multithreading</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >13</td> -->
<!-- 						<td>Real hands on with java.util.concurrent package	</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >14</td> -->
<!-- 						<td>Collections(List,Set,Map)</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >15</td> -->
<!-- 						<td>Collections Internal</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >16</td> -->
<!-- 						<td>Generics</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >17</td> -->
<!-- 						<td>JDBC</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >18</td> -->
<!-- 						<td>Class Loaders</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >19</td> -->
<!-- 						<td>Java References</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >20</td> -->
<!-- 						<td>Java Heap and Thread Dump</td> -->
<!-- 						<td></td></tr> -->
						
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >21</td> -->
<!-- 						<td>JVisualVM</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >22</td> -->
<!-- 						<td>Garbage Collector</td> -->
<!-- 						<td></td></tr> -->
<!-- 						<tr class="core_java_tbl"> -->
<!-- 						<td >23</td> -->
<!-- 						<td>Working with keytool</td> -->
<!-- 						<td></td></tr> -->
<!-- 						</tbody> -->
<!-- 			</table> -->
		</div>
		<br/><br/><br/><br/><br/><br/><br/><br/><br/>

 <!-- FOOTER -->
    <footer id="footer" class="footer">
   <%@include file="/ffooter.jsp" %>

       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->






</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
</body>

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-teaching.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
</html>