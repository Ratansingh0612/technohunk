<%@page import="com.techquiz.programys.common.controller.model.QuestionsBankForm"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<%@page import="com.synergisitic.it.web.form.AvailableQuestionsBankForm"%>
<%@page import="java.util.List"%>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- Css -->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-css/admin.css" type="text/css" media="all">
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Available Questions Bank</title>
    <style type="text/css">
    tr.spaceUnder>td {
  				padding-bottom: 3em;
			}
    </style>
</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
        <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
  </div>
</div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
 
    <!-- COURSE CONCERN -->
  <section style="padding-top: -20px;padding-bottom:20px;background-color: #eee;min-height: 550px;">
        <div class="container">
 <div>
                <br/>
                 <span style="color: black;background-color:  #c6e9ff;font-size: 18px;">
							<img
								src="${pageContext.request.contextPath}/images/question1.png" width="40px;"/>
								<% List<QuestionsBankForm> availableQuestionsBank =( List<QuestionsBankForm>)request.getAttribute("availableQuestionsBank"); %>
							 Total Question(s) Bank  - (<%=availableQuestionsBank.size() %>)
                </span> 
            </div>
            	  <k:if test="${availableQuestionsBank.size() == 0}">
              				<h3 style="font-size: 20px;"><img src="${pageContext.request.contextPath}/images/icon/cube.png" style="height: 32px;margin-right: 10px;"> - No question bank is created in the portal by you.</h3>
           		</k:if> 
            	<div>
						<table style="width: 100%;background-color: white;" >
							<%
      			           int numberOfItemsInRow=3;
      			           //computing number of rows
      			           int rows=0;
      			           if(availableQuestionsBank.size()%numberOfItemsInRow==0) {
      			              rows=availableQuestionsBank.size()/numberOfItemsInRow;
      			           }else{
 	     			             rows=(availableQuestionsBank.size()/numberOfItemsInRow)+1;
      			           }
      			          System.out.println("rows - - - - - = "+rows) ;
      			      	  int rowdata=0;
      			         for(int row=0;row<rows;row++) {   
      			        	  int lastRowItems=0;
      			        	 //computing the last row
      			        	   if(row+1==rows) {
      			        		     lastRowItems=availableQuestionsBank.size()%numberOfItemsInRow;
      			        	   }
      			        	 
      			        	 if(lastRowItems==0) { //This is not last row
      			         %>
							<tr height="170px"
								style="color: black; background-color: white; vertical-align: middle;"
								align="center" class="spaceUnder">

								<%
					        for(int index=0;index<numberOfItemsInRow;index++) {
					      %>
								<td style="border-width: 3px; border-color: blue;" width="250px;" align="left">
									<div style="margin-left: 30px;">
								<a
									href="${pageContext.request.contextPath}/action/aquestionsUserBankList?selectedTech=<%=availableQuestionsBank.get(rowdata).getTechName()%>&qBankName=<%=availableQuestionsBank.get(rowdata).getQbankname()%>" style="color:black;font-size: 15px;">
									 <img src="${pageContext.request.contextPath}/images/question-bank.png" style="height: 80px;"/><br/>
									 <span style=";font-size: 14px;">
									 <font color="#37A1DB">
									 <span style="font-size: 18px;color:black;">
									 Tech Name :&nbsp;&nbsp;<%=availableQuestionsBank.get(rowdata).getTechName()%>
									 </span>
									 ( <b><%=availableQuestionsBank.get(rowdata).getNoq() %>
									 </b> )</font>
									 
										<br/>
										 QBank Name :&nbsp;&nbsp;&nbsp;&nbsp;<%=availableQuestionsBank.get(rowdata).getQbankname()%>
										 <br/>Owner :&nbsp;&nbsp; <b><%=availableQuestionsBank.get(rowdata).getOwnerName()%></b>
										 <br/>Date :&nbsp;&nbsp; <%=availableQuestionsBank.get(rowdata).getDoe()%>
										 </span> 
								</a>
								</div>
								</td>
								<%
								rowdata++;
					        }
					     %>
							</tr>
							<%   
					     }
      			        	 else {
					     %>
							<tr height="170px"
								style="color: black; background-color: white; vertical-align: middle;"
								align="center">
								<%
					     for(int lastItem=0;lastItem<lastRowItems;lastItem++){
					    	 %>
							<td style="border-width: 3px; border-color: blue;" width="250px;" align="left">
									<div style="margin-left: 30px;">
								&nbsp; <a
									href="${pageContext.request.contextPath}/action/aquestionsUserBankList?selectedTech=<%=availableQuestionsBank.get(rowdata).getTechName()%>&qBankName=<%=availableQuestionsBank.get(rowdata).getQbankname()%>" style="color:black;font-size: 15px;"> <img
										src="${pageContext.request.contextPath}/images/question-bank.png" style="height: 80px;"/><br/>
											 <span style="font-size: 18px;color:black;">
										Tech Name :&nbsp;&nbsp; <%=availableQuestionsBank.get(rowdata).getTechName() %>
										</span>
										
										( <b><%=availableQuestionsBank.get(rowdata).getNoq() %></b> )<br/> QBank Name :&nbsp;&nbsp;&nbsp;&nbsp;<%=(availableQuestionsBank.get(rowdata)).getQbankname()%>
										<br/>Owner : &nbsp;&nbsp;<b><%=availableQuestionsBank.get(rowdata).getOwnerName()%> </b>
										 <br/>Date :&nbsp;&nbsp;<%=availableQuestionsBank.get(rowdata).getDoe()%>
								</a>
									</div>
								</td>
								<% 
								rowdata++;
					     }
					     %>
							</tr>

							<%   
      			        	 }
					     }
					     %>
						</table>
					</div>

            </div>
        <hr/>
   </section>
        </div>
    <!-- END / COURSE CONCERN -->
   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
<!-- Load jQuery -->
  <%@include file="/js.jsp" %>

<script type="text/javascript">

    $.each($('.table-wrap'), function() {
        $(this)
            .find('.table-item')
            .children('.thead:not(.active)')
            .next('.tbody').hide();
        $(this)
            .find('.table-item')
            .delegate('.thead', 'click', function(evt) {
                evt.preventDefault();
                if ($(this).hasClass('active')==false) {
                    $('.table-item')
                        .find('.thead')
                        .removeClass('active')
                        .siblings('.tbody')
                            .slideUp(200);
                }
                $(this)
                    .toggleClass('active')
                    .siblings('.tbody')
                        .slideToggle(200);
        });
    });

</script>
</body>

</html>