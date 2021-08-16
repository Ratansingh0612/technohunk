<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Topic Feedback</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.2.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

 
 <script type="text/javascript">
 var ccontextPath="${pageContext.request.contextPath}";
 function submitFeedback(rowid,sid){
	   var vvv="feedback"+rowid;
	   var fid= $("input[type='radio'][name='"+vvv+"']:checked").val();
	   var comment="NA";
	  $.getJSON(ccontextPath+"/action/consultant-topic-feedback-post",{fid:fid,sid:sid,comment:comment},function(jsonResponse) {
		  if(jsonResponse.status=="success") {
			  $("#"+rowid).closest("tr").hide();
			  var totalRecords= $("#totalRecords").html(); 
			  totalRecords=parseInt(totalRecords)-1;
			  $("#totalRecords").html(totalRecords); 
			  $("#alertMessage").show();
			  $("#applicationMessage").html(jsonResponse.message);
		  }
	  });
 }
 
$(document).ready(function() {
	$("#alertMessage").hide();
});
</script>	
<style>
input[type=radio]{
  display:none;
}

input[type=radio] + label:before{
  content: '';
  display:inline-block;
  border-radius: 10px;
  width: 16px;
  height:16px;
  background:#fdfdfa;
  color:blue;
  border: 1px solid black;
  line-height: 15px;
  text-align: center;
  font-size:25px;
  margin-right: 5px;
}

input[type=radio]:checked + label:before{
  color: red;
   background:#37abf2;
}
</style>
</head>
<body>

<!-- PAGE WRAP -->
<div id="page-wrap">

       <div class="body121">
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
          <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
       <%@include file="uheader.jsp"%>
       </k:if>
         <k:if test="${sessionScope.user_session_data.role=='user'}">	
       <%@include file="uheader.jsp"%>
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
   <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;" id="content">
   		<section style="height: 10px;background-color: #eee;width: 100px;">
   		</section>
        <div class="container" style="background-color:white;min-height:500px;">
         		  <h3 style="color: black;font-size: 16px;display: inline;margin-right: 150px;"><img src="${pageContext.request.contextPath}/images/document-paper-64.png" width="40px;"/> -  Topics Feedback -> &nbsp;&nbsp;&nbsp;&nbsp;<span style="color:black;">( Batch Name : ${sessionScope.user_session_data.batch})</span></h3>
                 
				<%-- <span style="color: red;font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> --%>
				 <div class="alert alert-info fade in" style="margin-top: 20px;padding: 8px;" id="alertMessage">
   			    		 <strong>Note!</strong> <span style="font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> 
			    </div>
					   <hr style="color: blue;height: 5px;background-color: #37abf2;"/>
					   <img src="${pageContext.request.contextPath}/images/test-icon.png" style="margin-top: -5px; width: 25px;"> 
					    <span style="font-size: 16px;">Pending Feedback:-</span>
					    <div style="float: right;">
                           <img src="${pageContext.request.contextPath}/images/favicon.ico"width="25px;">   <span style="font-family: 'Lato', sans-serif;font-size: 14px;">Total Records :</span> <b><span id="totalRecords">${fn:length(pendingFeedbackFormsList)}</span></b>
                             </div> 
                             <table class="table  table-bordered" id="tableContent" style="font-size: 14px;">
      			            <tr style="color: white;background-color:#607D8B">
      			          <td class="score" style="width:5%">SNo </td>
                            <td class="submit-date" style="width:10%">Date</td>
                            <td class="author" style="width:15%">Technology</td>
                            <td class="submit-date" style="width:20%">Topics Covered</td>
                             <td class="submit-date" style="width:45%">Feedback</td> 
                        	<td class="submit-date" style="width:5%">Action</td> 
                         </tr>

						  <c:forEach items="${pendingFeedbackFormsList}" var="item" varStatus="ol">
					     <tr height="30px" style="vertical-align: middle;" align="left"  id="${item.ptfid}">
					     <td>&nbsp;${ol.count}</td>
					      <td>&nbsp;${item.dos}</td>
					   	    <td>&nbsp;${item.technology}</td>
					   	  <td>&nbsp;${item.topics}</td>
					   	    <td>&nbsp; 
					   	     <input type="hidden" name="sid${item.sid}" id="rownum${item.sid}"  value="${item.sid}">
					   	    <input type="radio" name="feedback${item.ptfid}" id="feedback${item.ptfid}1"
									value="100" /><label for="feedback${item.ptfid}1">Understood</label>
					   	    &nbsp; &nbsp;&nbsp;    
					   	    <input type="radio" name="feedback${item.ptfid}" id="feedback${item.ptfid}2"
									value="200" /><label for="feedback${item.ptfid}2">Not Understood</label>
					   	    &nbsp; &nbsp;&nbsp;
					   	        <input type="radio" name="feedback${item.ptfid}" id="feedback${item.ptfid}3"
									value="300" /><label for="feedback${item.ptfid}3">Can't  Say</label>
					   	    </td>
					   	       <td>&nbsp;<a href="javascript:submitFeedback(${item.ptfid},${item.sid});"><img src="${pageContext.request.contextPath}/images/s.png" style="height: 30px;"/></a></td>
					     </tr>
					     </c:forEach>
					   
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					        <tr height="30px" style="vertical-align: middle;" align="center">
					     <td width="10px">&nbsp;</td>
					      <td width="10px">&nbsp;</td>
					   	   <td width="300px">&nbsp;</td>
					   	   <td>&nbsp;</td>
					   	    <td>&nbsp;</td>
					   	      <td>&nbsp;</td>
					     </tr>
					</table>     
				
					</div>
    </section>

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

<!-- Modal -->
<form  id="addTopicModelForm"  >
<div id="addTopicModel" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content" style="background-image: url('${pageContext.request.contextPath}/images/bg/backgrounds.jpg');">
      <div class="modal-header"  style="background-color: #37abf2;height: 35px; ">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      <img src="${pageContext.request.contextPath}/images/course-icon.png" width="30px;"/>
            <p style="display: inline;margin-left: 20px;">   <span style="font-weight: bold;" id="name"></span></p>
      </div>
      <div class="bloading">
      <div class="modal-body">
       
       			<input type="hidden" name="language" id="techId">
              <div class="form-group">
       Technology   :   <span style="font-weight: bold;color:red;">*</span>
        	<label style="font-weight: bold;" id="ptechName">Angular2</label>
        </div>
        <hr/>
           <span style="color:red;font-size: 15px;" id="ErrorMessage"></span>
      <div class="form-group">
      	Topic Name    :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="topicName" name="topic"/>
        </div>
        
        
          <div class="form-group">
       Description   :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="description" name="description"/>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Add Topic" class="mc-btn btn-style-1" id="addNewTopic"/>
      </div>
    </div>

  </div>
</div>
</form>
</body>

</html>