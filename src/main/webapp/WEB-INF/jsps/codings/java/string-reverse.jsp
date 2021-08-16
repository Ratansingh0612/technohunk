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
    <title>${companyName} -Java String Reverse</title>
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <style type="text/css">
   
    .scrollcoll {
    padding: 2%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-size: 15px;
    line-height: 20px;
    border-left: 5px solid #1b7175;
    margin: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}

.probscrollcoll {
    padding: 2%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-weight: 400;
    font-size: 14px;
    line-height: 20px;
    border-left: 5px solid #c2bcf9;
    margin: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}
 .subscrollcoll {
    padding: 2%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-weight: 400;
    font-size: 14px;
    line-height: 20px;
    border-left: 5px solid #8bc34a;
    margin: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}

 .breadscrumscrollcoll {
    padding: 1%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-size: 16px;
    line-height: 20px;
    font-weight:bold;
    border-left: 5px solid #c2bcf9;
    margin: 1%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}
    </style>
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
     <%@include file="/aheader.jsp" %>
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
        	 <section>
        		<p class="breadscrumscrollcoll"> <a href="${pageContext.request.contextPath}/action/codings/java/lists">Java Coding Problem List</a> > Reverse a String</p> 
        	 </section>
        	 <br/>	 <br/>
        	 <hr/>
            <div class="row">
                <!-- BLOG LIST -->
                <div class="col-md-8">
                    <div class="blog-list-content">
                     <!-- POST -->
                        <div class="post" style="height: 100px;">
                            <!-- POST MEDIA -->
                            <div class="post-media">
                                <div class="image-thumb">
                                    <img src="${pageContext.request.contextPath}/images/codings/clean-code.png" alt="" style="width:120px;margin-top: -20px;">
                                </div>
                            </div>
                            <!-- END / POST MEDIA -->
                            <!-- POST BODY -->
                            <div class="post-body">
                                <div class="post-title">
                                    <h3 class="md"><a href="#">Java Reverse a String</a></h3>
                                     Level : Medium
                                </div>
                                <div class="post-meta">
                                    by <a href="#">JavaHunk</a> on July 24, 2018
                                </div>
                            </div>
                        	
        
                        </div>
                          <span style="margin-left: 20px;font-size: 18px;color:#61b91a;width:400px;font-weight: bold;">	
                         		 Problem Statement : -
                          </span> 	
                         <p  class="scrollcoll">A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.(Wikipedia)</p>
                   <p  class="probscrollcoll"> Given a string , print Yes if it is a palindrome, print No otherwise.</p>
                   
                   <p  class="subscrollcoll"> Sample Input : - madam</p>
                         <p  class="subscrollcoll"> Sample Output : - Yes</p>
                         
                        
                    </div>
                </div>
                <!-- END / BLOG LIST -->

                <!-- SIDEBAR -->
                <div class="col-md-3 col-md-offset-1">
                    <aside class="blog-sidebar">

                        <!-- WIDGET SEARCH -->
                        <div class="widget widget_search">
                            <h4 class="sm">Search in Problems</h4>
                            <form>
                                <div class="form-item">
                                    <input type="text">
                                </div>
                                <div class="form-actions">
                                    <input type="submit">
                                </div>
                            </form>
                        </div>
                        <!-- END / WIDGET SEARCH -->

                        <!-- WIDGET CATEGORIES -->
                        <div class="widget widget_categories">
                            <h4 class="sm">Categories</h4>
                            <ul>
                                <li><a href="#">All</a></li>
                                <li><a href="#">Uncategorized</a></li>
                                <li><a href="#">Popular</a></li>
                                <li><a href="#">New</a>
                                </li>
                                <li><a href="#">Uncategorized</a></li>
                            </ul>
                        </div>
                        <!-- END / WIDGET CATEGORIES -->


                    </aside>
                </div>
                <!-- END / SIDEBAR -->
  <br/>     <br/>      
 <section style="margin:20px;"> 
 
 <iframe src="https://paiza.io/projects/e/6hbtnQoBny7zhT5diwkzzg?theme=Eclipse" width="100%" height="500" scrolling="no" seamless="seamless"></iframe>
 
 <form id="codetextform" method="post" action="${pageContext.request.contextPath}/action/codings/java/compile-execute">
 	<input type="hidden" name="cpid" id="cpid" value="100"/> 	
 	<textarea rows="10" cols="8" id="javacode" name="javacode" class="form-control" style="width: 95%;margin-bottom: 10px;font-size: 16px;"></textarea>
 	<input type="button" value="Upload Code & Execute Test Cases" class="mc-btn btn-style-1" id="uploadCode" style="background-color: #00bcd4;;margin: 0px; font-weight: 500;font-size: 18px;"/>
 	 <span id="codemessage" style="margin-left: 15px;color:red;font-size: 16px;"></span>
  </form>
</section>
            </div>
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
  
  <script type="text/javascript">
  	  $(document).ready(function(){
  		  
  			$("#javacode").mouseenter(function(){
  				$("#codemessage").html("");
  			}); 
  			$("#uploadCode").click(function(){
  				//alert("WOW");
  				var javacode=$("#javacode").val();
  				if(javacode.trim().length==0){
  					$("#codemessage").html("Please paste your code into above textarea & click on Upload Code button.");
  					$("#javacode").focus();
  					return;
  				}
  				var contextPath="${pageContext.request.contextPath}";
  				$.ajax({url:contextPath+"/action/codings/java/compile-execute", type: 'POST',data:$("#codetextform").serialize(),success:function(data) {  //data= this.responseText
  					alert("Response coming from the server...............");
  					console.log(data);
  					$("#codemessage").html(data.description);
				  }
 		 		});
  				
  				console.log(javacode);
  				//var content=document.getElementById('techquizeditor').contentWindow.document.body.innerHTML;
  				//var content=$("#techquizeditor").contents().find("body").html();
  				//alert(content);
  			});
  	  });
  
  
  </script>

</body>
</html>