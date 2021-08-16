<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Add/Edit Technology</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.2.js" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/trainer-css/trainer.css" type="text" media="all">
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
 <script type="text/javascript">
$(document).ready(function() {
	  $("#applicationMessage").html("");
	     $(".alert").hide();
	$("input[type='button'][id='addTechnology']").click(function() {
		$("input[type='text'][name='tname']").val('');
		$("#description").val('');
		  $("#applicationMessage").html("");
		     $(".alert").hide();
		  $("#addTechnologyModel").modal("show");
	});
	
	 $("input").keyup(function(){
		 $("#ErrorMessage").html("");
	 });
		//alert("good morning!");
  	 $("input[type='button'][id='addNewTechnology']").click(function() {
  		    //validating the test name
  			var tname=$("input[type='text'][name='tname']").val();
  			if(tname.length==0){
  					$("#ErrorMessage").html("Technolgy Name cannot be blank..");
  					$("input[type='text'][name='tname']").focus();
  					return;
  			}
  			var description=$("#description").val();
  			if(description.length==0){
  					$("#ErrorMessage").html("Description cannot be blank..");
  					$("#description").focus();
  					return;
  			}
  			
  		  var totalRecords= $("#totalRecords").html(); 
  		  totalRecords=parseInt(totalRecords)+1;
  			var tableConent="";
  			tableConent=tableConent+'<tr height="25px" style="color: black">';
  			tableConent=tableConent+'<td><b>'+totalRecords+'.</b></td>';
  			tableConent=tableConent+'<td>&nbsp;'+tname+'</td>';
  			tableConent=tableConent+'<td>&nbsp;'+description+'</td>';
  			tableConent=tableConent+'<td>&nbsp;<img src="${pageContext.request.contextPath}/images/not-started.png" width="40px;"/></td>';
  			tableConent=tableConent+'<td>&nbsp;12-06-2018</td>';
  			tableConent=tableConent+'<td align="center">';
  			tableConent=tableConent+'<a href="#"><img alt=""	src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 40px;"/></a>';
  			tableConent=tableConent+'<a href="#"> <img alt=""		src="${pageContext.request.contextPath}/images/icon/delete.png" style="height: 40px;"/></a>';
  			tableConent=tableConent+'</td></tr>';
  			 var ccontextPath="${pageContext.request.contextPath}";
  		  $.getJSON(ccontextPath+"/action/add-new-technology",{tname:tname,description:description},function(jsonResponse) {
  			  if(jsonResponse.status=="success") {
  				  var totalRecords= $("#totalRecords").html(); 
  				  totalRecords=parseInt(totalRecords)+1;
  				  $("#totalRecords").html(totalRecords); 
  				  $(".alert").show();
  				  $("#applicationMessage").html(jsonResponse.message);
  				  $("#addTechnologyModel").modal("hide");
  				  $("#tableContentId").append(tableConent);
  			  }else{
  				  $(".alert").show();
  				  $("#applicationMessage").html(jsonResponse.message);
  				  $("#addTechnologyModel").modal("hide");
  			  }
  		  });
  			//$("#technologyFormId").submit();		
	 }); 
});
</script>	
</head>
<body>
  <div class="main">
   <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
  </div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->
    <!-- CONTEN BAR -->
   <!-- END / CONTENT BAR -->
    <!-- COURSE CONCERN -->
  <section class="quizz-intro-section" style="padding-top: 0px;padding-bottom:10px;background-color: #eee;min-height: 600px;" id="content">
  		<hr/>
        <div class="container" style="background-color: white;">
         <div class="title-ct">
                 &nbsp;&nbsp;<h3 style="color: black;font-size: 17px;display: inline;"><img src="${pageContext.request.contextPath}/images/not-started.png" width="40px;"/> - <b> Add/Edit Technology</b></h3>
                    <span style="float: right;">
                   <input type="button" value="Add Technology"	class="mc-btn btn-style-1" id="addTechnology"/> 
                   </span>
            </div>

 <div class="alert alert-info fade in" style="margin-top: 20px;padding: 8px;" id="alertMessage">
   			    		 <strong>Note!</strong> <span style="font-size:14px;font-weight: bold;" id="applicationMessage">${ApplicationMessage}</span> 
			    </div>
			 <br/>   
		   <hr style="color: blue;height: 2px;background-color: #37abf2;"/>	
       
			 <!--  <hr style="color: blue;height: 5px;background-color: #37abf2;"/>		  -->
             <img src="${pageContext.request.contextPath}/images/tech.ico" width="20px;"/>
					    <span style="font-size: 14px;font-weight: bold;">Technology List:-</span>
					    <div style="float: right;">
                           <img src="${pageContext.request.contextPath}/images/question2.png" width="20px;"/>   <span style="font-size: 14px;">Total Records : <span id="totalRecords">${fn:length(allTechs)}</span></span>
                             </div> 
                          <table class="table  table-bordered" id="tableContentId" style="font-size: 15px;">
      			            <tr style="color: white;background-color:#607D8B">
      			          <td class="score" style="width:5%">SNo </td>
                            <td class="submit-date" style="width:20%">Technology</td>
                            <td class="author" style="width:40%">Description</td>
                            <td class="submit-date" style="width:10%">Image</td>
                            <td class="submit-date" style="width:10%">Doe</td>
                             <td class="submit-date" style="width:15%">OP</td> 
                         </tr>
                       <c:forEach var="tech" items="${allTechs}" varStatus="status">
					      <tr height="25px" style="color: black">
					     <td><b>${status.count}.</b></td>
					   	   <td>&nbsp;${tech.tname}</td>
					   	   <td>&nbsp;${tech.description}</td>
					   	      <td>&nbsp;<img src="${pageContext.request.contextPath}/images/not-started.png" width="40px;"/></td>
					   	     <td>&nbsp;12-06-2018</td>
					   	    <td align="center">
					   	   <a href="#"><img alt=""
											src="${pageContext.request.contextPath}/images/icon/edit.png" style="height: 40px;"/></a>
							<a href="#">
					   	    <img alt=""
											src="${pageContext.request.contextPath}/images/icon/delete.png" style="height: 40px;"/>
											</a>
							</td>
					     </tr>
					   </c:forEach> 
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
<form  id="addTechnologyModelForm">
<div id="addTechnologyModel" class="modal fade" role="dialog">
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
        	<label style="font-weight: bold;" id="ptechName">Popup</label>
        </div>
        <hr/>
           <span style="color:red;font-size: 14px;font-weight: bold;" id="ErrorMessage"></span>
      <div class="form-group">
      	Technology Name    :   <span style="font-weight: bold;color:red;">*</span>
        <input type="text" class="form-control" id="tname" name="tname"/>
        </div>
        
        
          <div class="form-group">
       Description   :   <span style="font-weight: bold;color:red;">*</span>
       <textarea id="description" name="description" class="form-control" cols="60"></textarea>
        </div>
        
      </div>
      </div>
      <div class="modal-footer">
        	<input type="button" value="Close"  class="mc-btn btn-style-1" id="close"  data-dismiss="modal"/>
        	<input type="button"  value="Add Technology" class="mc-btn btn-style-1" id="addNewTechnology"/>
      </div>
    </div>
  </div>
</div>
</form>
</body>

</html>