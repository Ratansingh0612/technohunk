function init()  {
	  //alert(")00000init0000000");	
	 $("input[type='radio'][name*='selectedAnswerId']").click(function() {
			var tvalue= $(this).attr("cvalue");
			 $("input[type='text'][name='showSelectedAnswerIdAnswer']").val(tvalue);
			 for(var i=1;i<=8;i++){
				 $("#selectedAnswerIdOption"+i).attr('style',"width:40px;background-color:#91f3d778;font-size: 16px;");
			 } 
			 if(tvalue=="A"){
				  $("#selectedAnswerIdOption1").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }else if(tvalue=="B"){
				  $("#selectedAnswerIdOption2").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }else if(tvalue=="C"){
				  $("#selectedAnswerIdOption3").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }
			  else if(tvalue=="D"){
				  $("#selectedAnswerIdOption4").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }
			  else if(tvalue=="E"){
				  $("#selectedAnswerIdOption5").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }
			  else if(tvalue=="F"){
				  $("#selectedAnswerIdOption6").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }
			  else if(tvalue=="G"){
				  $("#selectedAnswerIdOption7").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }
			  else if(tvalue=="H"){
				  $("#selectedAnswerIdOption8").attr('style',"width:40px;background-color:#bf38bf47;font-weight: bold;font-size: 16px;");
			  }
			  
	 }); 
	
	//Hinding unnecessary options when first questions are rendered
	//$("#nextButtonInvisible").hide();
	 var rgenId="";
	 for(var p=1;p<8;p++) {
		 rgenId="selectedAnswerId"+p;
		 var ansSelectorId="input[type='radio'][id$='"+rgenId+"']";
		 var textData= $(ansSelectorId).val();
		// alert(")@)@(#(##("+textData);
		 if(textData ==undefined ){
			return; 
		 }
		 if(textData.length==0){
			 var tbrowId="#optionTable tr[id='tr"+p+"th']";
			//alert("tbrowId = "+tbrowId);
			 $(tbrowId).hide();
		 }
	 }
	
	 //This code I have commented!!!!!!!!
	// $("input[type='button'][id$='submittest']").click(function() {
		// if($("input[type='radio'][id*='selectedAnswerId']").is(':checked')){
			// document.forms[0].action="submitTechTest";
			// $("#startTechTestForm").submit();		 
		 //}else{
			// alert("Please select a least one correct option!");
		    // jAlert('Please fill this field.',"OK");
		 
 		//}
	 //});
	 
	//alert("IIIIIIIIIIIIIIIIIII");
	//alert()
	 $("input[type='button'][id*='nextId']").click(function() {
		 //alert("__)))((");
		 submitAnswer('#b5e61d');
	 });
	 
	//alert("IIIIIIIIIIIIIIIIIII");
		//alert()
		 $("input[type='button'][id$='markForReview']").click(function() {
			 submitAnswer('yellow');
		 });
	 
}

function submitAnswer(pcolor){
	 //alert("Mot!");
	 //var pselectedAnswerId= $("input[type='radio'][id*='selectedAnswerId']").val();
	 //var selected = $("input[type='radio'][id*='selectedAnswerId'']:checked");
	 //there was a bug in the application.it was always seleting first option
	 if($("input[type='radio'][id*='selectedAnswerId']").is(':checked')){
		 var linkid="#questionNum"+$("#currentQuestionNo").html();
		 //alert("linkid = "+linkid);
		 $(linkid+"").css("background-color",pcolor);
	 }else{
		 var yesno=confirm("Are you sure want to skip this question.");
		 if(!yesno){
			 return;	 
		 }
	 }
	 $("input[type='text'][name='showSelectedAnswerIdAnswer']").val('');
	 var pselectedAnswerId =$('input:radio[name=selectedAnswerId]:checked').val()
	 //alert("pselectedAnswerId = "+pselectedAnswerId);
	 //alert("len = "+pselectedAnswerId.length);
	 	 $('.bloading').loading({ overlay: true,base: 0.6 });
 	$('.bloading').loading('show');
	 $.getJSON(ccontextPath+"/action/submitTechAnswer.json", { selectedAnswerId: pselectedAnswerId}, function(jsonResponse) {
		 var cqno=0;
		 if(!jQuery.isEmptyObject(jsonResponse)) {
				 jQuery.each(jsonResponse, function(i, val) {
				  // alert("val = "+val);
				   if(val=='disabled') {
					   //below code is hiding the next button
					   $("#nextButtonInvisible").show();
					   //$("#nextButtonVisible").hide();
					   //alert("val = "+val);
					   $("#nextId").attr('disabled',true);
					   $("#userinfo").show();
				   } else {
					   //alert("val 11= "+val['questionText']);
					   var selectedOption=val['selectedOption'];
					   $("#currentQuestionNo").html(val['id']);
					   cqno=val['id'];
					  // alert("mk = "+val['topic']);
					   $("#questionTopic").html(val['topic']);
					   $('#questionText').html(val['questionText']);
					   $('#questionTextId').html(val['questionText']);
					   $('#questionNo').html("Question "+val['id']);

					   if(val['answerText1']!=null) {
					   		$('#answerText1Id').html(val['answerText1']);
					   		$("input[type='radio'][id$='selectedAnswerId1']").val(val['answerId1']);
					   		if(val['answerId1']==selectedOption){
					   				$("input[type='radio'][id$='selectedAnswerId1']").prop('checked','checked');
					   				$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("A");
					   		}else{
					   			   $("input[type='radio'][id$='selectedAnswerId1']").removeAttr('checked');
					   		}
					   		$('#optionTable tr[id="tr1th"]').show();
					   		$("#selectedAnswerIdOption1").attr('style',"background-color:#91f3d778;width:30px");
					   }else {
						   $('#optionTable tr[id="tr1th"]').hide();
					     }
					   
					   if(val['answerText2']!=null) {
							   $('#answerText2Id').html(val['answerText2']);
							   $("input[type='radio'][id$='selectedAnswerId2']").val(val['answerId2']);
							   if(val['answerId2']==selectedOption){
					   				$("input[type='radio'][id$='selectedAnswerId2']").prop('checked','checked');
					   				$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("B");
					   		  }else{
					   			   $("input[type='radio'][id$='selectedAnswerId2']").removeAttr('checked');
					   	      }
					   		  $('#optionTable tr[id="tr2th"]').show();
						   $("#selectedAnswerIdOption2").attr('style',"background-color:#91f3d778;width:30px");
					   }
					   else {
						   $('#optionTable tr[id="tr2th"]').hide();
					     }
					   
					   if(val['answerText3']!=null) {
			   				$('#answerText3Id').html(val['answerText3']);
			   				$("input[type='radio'][id$='selectedAnswerId3']").val(val['answerId3']);
				   			 if(val['answerId3']==selectedOption){
					   				$("input[type='radio'][id$='selectedAnswerId3']").prop('checked','checked');
					   				$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("C");
					   		  }else{
					   			   $("input[type='radio'][id$='selectedAnswerId3']").removeAttr('checked');
					   	      }
				   			 $('#optionTable tr[id="tr3th"]').show();
			   		    	 $("#selectedAnswerIdOption3").attr('style',"background-color:#91f3d778;width:30px");
					   }else {
						   $('#optionTable tr[id="tr3th"]').hide();
					     }
					   
					   if(val['answerText4']!=null) {
					        $('#answerText4Id').html(val['answerText4']);
					   		$("input[type='radio'][id$='selectedAnswerId4']").val(val['answerId4']);
						   	 if(val['answerId4']==selectedOption){
					   				$("input[type='radio'][id$='selectedAnswerId4']").prop('checked','checked');
					   				$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("D");
					   		  }else{
					   			   $("input[type='radio'][id$='selectedAnswerId4']").removeAttr('checked');
					   	      }
				   			 $('#optionTable tr[id="tr4th"]').show();
					   	    $("#selectedAnswerIdOption4").attr('style',"background-color:#91f3d778;width:30px");
					   }
					   else {
						   $('#optionTable tr[id="tr4th"]').hide();
					     }
					   
					   if(val['answerText5']!=null) {
					   	$('#answerText5Id').html(val['answerText5']);
					   	$("input[type='radio'][id$='selectedAnswerId5']").val(val['answerId5']);
					 	 if(val['answerId5']==selectedOption){
				   				$("input[type='radio'][id$='selectedAnswerId5']").prop('checked','checked');
				   				$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("E");
				   		  }else{
				   			   $("input[type='radio'][id$='selectedAnswerId5']").removeAttr('checked');
				   	      }
			   			 $('#optionTable tr[id="tr5th"]').show();
					    $("#selectedAnswerIdOption5").attr('style',"background-color:#91f3d778;width:30px");
					   }else {
						   $('#optionTable tr[id="tr5th"]').hide();
					     }
					   
					   if(val['answerText6']!=null) {
					   		$('#answerText6Id').html(val['answerText6']);
					   		$("input[type='radio'][id$='selectedAnswerId6']").val(val['answerId6']);
						   	 if(val['answerId6']==selectedOption){
					   				$("input[type='radio'][id$='selectedAnswerId6']").prop('checked','checked');
					   				$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("F");
					   		  }else{
					   			   $("input[type='radio'][id$='selectedAnswerId6']").removeAttr('checked');
					   	      }
				   			 $('#optionTable tr[id="tr6th"]').show();
					    	 $("#selectedAnswerIdOption6").attr('style',"background-color:#91f3d778;width:30px");
					   } else {
							   $('#optionTable tr[id="tr6th"]').hide();
					     }
					   
					   if(val['answerText7']!=null) {
					   			$('#answerText7Id').html(val['answerText7']);
					   			$("input[type='radio'][id$='selectedAnswerId7']").val(val['answerId7']);
						   	  	 if(val['answerId7']==selectedOption){
						   				$("input[type='radio'][id$='selectedAnswerId7']").prop('checked','checked');
						   				$("input[type='text'][name='showSelectedAnswerIdAnswer']").val("G");
						   		  }else{
						   			   $("input[type='radio'][id$='selectedAnswerId7']").removeAttr('checked');
						   	      }
					   			 $('#optionTable tr[id="tr7th"]').show();
					   		    $("#selectedAnswerIdOption7").attr('style',"background-color:#91f3d778;width:30px");
					   }else {
						   $('#optionTable tr[id="tr7th"]').hide();
					   }
					   
					   //$('#optionTable tr[id="hideme"]').hide();//in table1 hide tr that are with attribute id="hideme"
					   //$('#table1 tr:first').hide();
						//Alternatively you could use the id of the tr as it is intended to be unique:
						//$('#hideme').hide();
					   //unselecting the radio button
					   //alert("clearing the selection")
				   }
   			});
  			 var questionText=jsonResponse['nextButton'];
  		     //alert("questionText = "+questionText);  
  			//  alert("tquesions = "+tquesions);
   			 // alert("cqno = "+cqno);
   		     if(cqno==tquesions){
   		  	    $("#nextId").attr('disabled',true);
   		  	    $("#userinfo").show();
   		     }else{
   				   $("#nextId").removeAttr('disabled');
   				  $("#userinfo").hide();
   		     }
  		 }  
  	 }).fail(function(jqXHR, textStatus, errorThrown)  {
  		         console.log(jqXHR);
  		       console.log(textStatus);
  		     console.log(errorThrown);
  		     $('.bloading').loading('hide');
  		 		  if (jqXHR.status == 500) {
  		 				 alert("Your session is timeout so redirecting to login page");
  		 				 window.location.href=ccontextPath+"/action/logout";
  		 		}  else if (textStatus === 'timeout') {
  					 	alert("Your request is timeout so redirecting to login page");
		 				 window.location.href=ccontextPath+"/action/logout";
  		 		}else{
  		 			alert("Some problem occurs at server side so redirecting to login page");
	 				 window.location.href=ccontextPath+"/action/logout";
  		 		} 
  		 		
  	 	})
		.always(function() { 
			$('.bloading').loading('hide');
		});
	 
	 window.moveTo(0, 100);
}


function submitFinalTest() {
		 document.forms[0].action="submitTechTest";
		document.forms[0].submit();
}

var initialSec;  
function countDown(secs,elem) {
	var realsec = secs % 60;
	var minutes = Math.floor(secs / 60);
	//var realmin = minutes % 60;
    //var hours = Math.floor(minutes / 60);
              // alert("____H___");
	//var xc=document.getElementById(elem);
    $("#status").html("Time Remaining "+minutes+":"+realsec+" (Minutes)");
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
                		 		$("#startTechTestForm").attr("action",ccontextPath+"/action/test-time-out")
                		 		$("#startTechTestForm").submit();
                	 }, 5000);
       }  
}

function timeLeft(psecs)  {
        $("#secondsTimer").html(psecs);
        psecs--;
        if(psecs>=0)
        setTimeout('timeLeft('+psecs+')',1000);
}    