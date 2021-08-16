<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery.owl.carousel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery.appear.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/library/jquery.easing.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/core/js/src-min-noconflict/ace.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}//resources/core/js/src-min-noconflict/ext-language_tools.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-loading.js"></script>
<script type="text/javascript">
$("#searchConsultantId").keyup(function(e) {
	 if(e.keyCode == 13) {
		// var yesno=confirm("Do you want to search consultant test reasult!");
		 //if(yesno) 
		 $("#searchConsulatTestForm").submit();
	 }
});

  $(document).ready(function(){
	  $.ajaxSetup({
	             "error":function() { alert("Data loading issue due to ajax timeout, please logout and login again.");  }
	});
  });

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-loading.js"></script>

