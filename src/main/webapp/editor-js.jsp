 <script type="text/javascript">
  	  $(document).ready(function(){
  		  	//logic to show and hide custom input box as per the problem types
  		  	var problemType="${item.problemType}";
  		  	
  		  	$("#custominputwithbutton").hide();
  		  	if("PUNINM"==problemType){
  	  		 	$("#custominputsection").hide();		  		
		  	}else if("PUINM"==problemType){
		  		//$("#inputchecklable").hide();
  	  		 	//$("#custominputwithbutton").show();		  		
		  	}
  		  
	  		$('#following-user').click(function() {
	  		  if ($(this).is(':checked')) {
	  			$("#custominputwithbutton").show();	  		    
	  		  }else{
	  			$("#custominputwithbutton").hide();
	  		  }
	  		});
  		  	
  		  	//code when finalSubmitCode button is clicked.........
  		  	 $("#submitFinalCode").click(function(){
  		  		//var javacode=$("#javacode").val();
  		  		var javacode = editor.getValue();
  		  		$("#tjavacode").val(javacode);
  				if(javacode.trim().length==0){
  					$("#customoutput").html("Please paste your code into above textarea & click on \"Submit Final Code\" button.");
  					$("#javacode").focus();
  					return;
  				}
				var yesno=confirm("Are you sure want to submit your final code.");
				if(yesno){
					$("#codetextform").submit();
				}else{
					alert("no no no");
				}
  		  	 });
  		  
  		  	//Hide the progress bar when data is loaded in  the begninng 
  		    $("#progressbar").hide();
  		  	$("#testSummarySection").hide();
  		  
  		  	$("#closesummary").click(function(){
  		  		$("#testSummarySection").hide();
  		  	});
  		  	
  			$("#custominput").keyup(function(){
  				$("#customoutput").html("");
  			});
  		  
  			$("#javacode").keypress(function(){
  				$("#codemessage").html("");
  				//$("#customoutput").html("");
  			}); 
  			$("#uploadCode").click(function(){
  				//alert("WOW");
  					$("#codemessage").html("");	
  				$("#customoutput").html("");
  				$("#custominput").val("");
  				//var javacode=$("#javacode").val();
  				var javacode = editor.getValue();
  				$("#tjavacode").val(javacode);
  				if(javacode.trim().length==0){
  					$("#customoutput").html("Please paste your code into above textarea & click on \"Upload Code & Execute Test Cases\" button.");
  					$("#javacode").focus();
  					return;
  				}
					$("#progressbar").show();
  				var contextPath="${pageContext.request.contextPath}";
  				$.ajax({url:contextPath+"/action/codings/java/compile-execute-all-tests", type: 'POST',data:$("#codetextform").serialize(),success:function(pdata) {  //data= this.responseText
  						$("#progressbar").hide();
  						$("#testSummarySection").hide();
  						if(pdata.status=="fail"){
  							$("#customoutput").html(pdata.comment);
  							$("#javacode").focus();
  							return;
  						}
  				
  						console.log(data);
  						var testContent="";
  						$("#testCasePassed").html(pdata.totalTestCasePassed);
  						$("#testPassed").val(pdata.totalTestCasePassed);
  						$("#testCaseFailed").html(pdata.totalTestCaseFailed);
  						$("#testFailed").val(pdata.totalTestCaseFailed);
  						var data=pdata.javaCodeResponseList;
  						for(var x=0;x<data.length;x++) {
  							testContent=testContent+'<tr>';
  							testContent=testContent+'<td>'+(x+1)+'</td>';
  							testContent=testContent+'<td>'+data[x].input+'</td>';
  							testContent=testContent+'<td>'+data[x].output+'</td>';
  							testContent=testContent+'<td>'+data[x].junitResult+'</td>';
  							if("pass"==data[x].status){	
  								testContent=testContent+'<td><img src="${pageContext.request.contextPath}/images/codings/test-pass.png" style="height:20px;">&nbsp;'+data[x].status+'</td>';
  							}else{
  								testContent=testContent+'<td><img src="${pageContext.request.contextPath}/images/codings/test-fail.png" style="height:20px;">&nbsp;'+data[x].status+'</td>';
  							}
  							testContent=testContent+'</tr>';
  						}
  					
  					$("#testsummarydata").html(testContent);	
  				 	$("#testSummarySection").show();
  					$("#codemessage").html(data.description);
				  }
 		 		});
  				console.log(javacode);
  				//var content=document.getElementById('techquizeditor').contentWindow.document.body.innerHTML;
  				//var content=$("#techquizeditor").contents().find("body").html();
  				//alert(content);
  			});
  			
  			$("#runCode").click(function(){
  				//alert("WOW");
  					$("#codemessage").html("");	
  				$("#testSummarySection").hide();
  				//var javacode=$("#javacode").val();
  				var javacode = editor.getValue();
  				$("#tjavacode").val(javacode);
  				$("#customoutput").html("");
  				if(javacode.trim().length==0){
  					$("#customoutput").html("Please paste your code into above textarea & enter custom input then click on \"Run Code\" button.");
  					$("#javacode").focus();
  					return;
  				}
  				var custominput=$("#custominput").val();
  				if(custominput.trim().length==0){
  					$("#customoutput").html("Please enter the custom input to run the code.");
  					$("#custominput").focus();
  					return;
  				}
  				var contextPath="${pageContext.request.contextPath}";
  				 $("#progressbar").show();
  				$.ajax({url:contextPath+"/action/codings/java/compile-execute-with-custominput", type: 'POST',data:$("#codetextform").serialize(),success:function(data) {  //data= this.responseText
  					$("#progressbar").hide();
  					console.log(data);
  					if(data.description.length==0) {
  						$("#customoutput").html("result is "+data.output);	
  					}else{
  						$("#codemessage").html(data.description);	
  					}
				  }
 		 		});
  				console.log(javacode);
  				//var content=document.getElementById('techquizeditor').contentWindow.document.body.innerHTML;
  				//var content=$("#techquizeditor").contents().find("body").html();
  				//alert(content);
  			});
  			
  			$("#compileRunCode").click(function(){
  				//alert("WOW");
  					$("#codemessage").html("");	
  				$("#testSummarySection").hide();
  				//var javacode=$("#javacode").val();
  				var javacode = editor.getValue();
  				$("#tjavacode").val(javacode);
  				$("#customoutput").html("");
  				if(javacode.trim().length==0){
  					$("#customoutput").html("Please write your code into above textarea & then click on \"Compile & Run Code\" button.");
  					$("#javacode").focus();
  					return;
  				}
  				
  				var contextPath="${pageContext.request.contextPath}";
  				 $("#progressbar").show();
  				$.ajax({url:contextPath+"/action/codings/java/compile-execute-with-nocustominput", type: 'POST',data:$("#codetextform").serialize(),success:function(data) {  //data= this.responseText
  					$("#progressbar").hide();
  					console.log(data);
  					if(data.description.length==0) {
  						$("#customoutput").html("result is "+data.output);	
  					}else{
  						$("#codemessage").html(data.description);	
  					}
				  }
 		 		});
  				console.log(javacode);
  				//var content=document.getElementById('techquizeditor').contentWindow.document.body.innerHTML;
  				//var content=$("#techquizeditor").contents().find("body").html();
  				//alert(content);
  			});
  			
  			$("#compileCode").click(function(){
  				//alert("WOW");
  				$("#testSummarySection").hide();
  				//var javacode=$("#javacode").val();
  				var javacode = editor.getValue();
  				$("#tjavacode").val(javacode);
  				$("#customoutput").html("");
  				if(javacode.trim().length==0){
  					$("#customoutput").html("Please paste your code into above textarea & enter custom input then click on \"Run Code\" button.");
  					$("#javacode").focus();
  					return;
  				}
  				
  				var contextPath="${pageContext.request.contextPath}";
  				 $("#progressbar").show();
  				$.ajax({url:contextPath+"/action/codings/java/compile-code", type: 'POST',data:$("#codetextform").serialize(),success:function(data) {  //data= this.responseText
  					$("#progressbar").hide();
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
  
   <script type="text/javascript">
    var initialSec=${sessionScope.pduration*60};
    var currentRole="${sessionScope.user_session_data.role}"
    if(currentRole!='admin') {
 		countDown(initialSec,"timeRemaining");
    }
   		
   var ccontextPath="${pageContext.request.contextPath}";
   function countDown(secs,elem) {
		var realsec = secs % 60;
		var minutes = Math.floor(secs / 60);
		//var realmin = minutes % 60;
	    //var hours = Math.floor(minutes / 60);
	              // alert("____H___");
		//var xc=document.getElementById(elem);
	    $("#timeRemaining").html("Time Remaining "+minutes+":"+realsec+" (Minutes)");
		//xc.innerHTML="<h6><b>Time remaining = "+hours+":"+minutes+":"+realsec+"<b></h6>" ;
	    //  alert("Please wait for "+secs+" seconds");
		 secs--;
	      if(secs>=0) {
			 	var timer=setTimeout('countDown('+secs+',"status")',1000);
	       } else {
	                	// alert("Sorry! Your Test Time is timeout.");
	                	 $("#testTimeoutModel").modal("show");
	                	// timeLeft(5);
	                	 timeLeft(5);
	                 	 setTimeout(function() { 
	                 		 	$("#testTimeoutModel").modal("hide");
	                		 		// document.forms[0].action="testTimeOut";
	                		 		// document.forms[0].submit();
	                		 		$("#problemTimeout").val("Timeout");
	                		 		$("#codetextform").attr("action",ccontextPath+"/action/codings/problem-time-out")
	                		 		$("#codetextform").submit();
	                	 }, 5000);
	       }  
	}
   
   function timeLeft(psecs)  {
       $("#secondsTimer").html(psecs);
       psecs--;
       if(psecs>=0)
       setTimeout('timeLeft('+psecs+')',1000);
}	
   
   </script> 