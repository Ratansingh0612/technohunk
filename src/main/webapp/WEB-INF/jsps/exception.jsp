<!DOCTYPE html>
<%@page import="java.io.PrintWriter" isErrorPage="true"%>
<%@page import="java.io.StringWriter"%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- Css -->
        <%@include file="/resources.jsp" %>
    <title>${companyName} - Exception Page</title>
    
</head>
<body id="page-top" class="home">

<!-- PAGE WRAP -->
<div id="page-wrap">


    <!-- HEADER -->
    <header id="header" class="header">
        <%@include file="/lheader.jsp" %>
    </header>
    <!-- END / HEADER -->


    <!-- LOGIN -->
    <section id="login-content" class="login-content">
        <div class="awe-parallax bg-login-content"></div>
        <div class="awe-overlay"></div>
        <div class="container">
            <div class="row">
          		<p style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 24px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;color:yellow;"> 
	Exception : Sorry! there is some error in order to do the processing of the current request , please refresh your page or contact to system administrator 
</p>
<p style="color:blue;width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 20px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
 Errors   :   <%=exception%>
</p>	

<%
	StringWriter stringWriter=new StringWriter();
	PrintWriter pw=new PrintWriter(stringWriter);
	exception.printStackTrace(pw);
	String errorText=stringWriter.toString();
%>

<p style="color:#ffeb3b;width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
 PrintStackTrace   :   <%=errorText%>
</p>	


<p style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
In case of any question and query , please feel free to reach us.
</p>
Thanks & Regards,<br/>
<b>${companyName}</b>
<hr style="width:250px;" align="left"/>
Mobile : +913333333333<br/>
Email  : <b>${companyEmail}</b><br/>

<!-- <img src="cid:image"/> -->
<img src="${pageContext.request.contextPath}/images/welcome.png" style="margin-top: -50px;"/>
<hr/>

            </div>
        </div>
    </section>
    <!-- END / LOGIN -->
    
      
    <!-- FOOTER -->
    <footer id="footer" class="footer">
         <%@include file="/ffooter.jsp" %>
 		<%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
</div>
<!-- END / PAGE WRAP -->
<!-- Load jQuery -->
</body>
</html>