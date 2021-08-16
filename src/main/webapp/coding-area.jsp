 <section style="margin:20px;"> 
 <!-- <iframe src="https://paiza.io/projects/e/Nwil16aj1wu1LslzpftYNA?theme=Eclipse" width="100%" height="500" scrolling="no" seamless="seamless"></iframe> -->
 <form id="codetextform" method="post" action="${pageContext.request.contextPath}/action/codings/submit-coding-problem">
 	<input type="hidden" name="javacode" id="tjavacode" value=""/>
 		<input type="hidden" name="problemTimeout" id="problemTimeout" value="No"/>
 	<input type="hidden" name="cpid" id="cpid" value="${item.cpid}"/> 
 <!-- 	   <p  class="ptextarea">
 	<textarea rows="13" cols="8" id="javacode" name="javacode" class="form-control" style="width: 100%;margin-bottom: 5px;font-size: 16px;border:dotted 1px red;"></textarea>
 	</p>
  -->	
  
  	<h5 style="background-color: #f4ff8566;">
  	<img src="${pageContext.request.contextPath}/images/icon/process-warning-icon.png" style="height: 35px;">
  	Note :- Please write your code in below text area  &  you can't change method's signature + return type!!!!!.</h5>	
  	<span id="timeRemaining" style="float: right;font-size: 16px;color:black">Time Remaining : 00 Minutes: 00 seconds </span>
 	<section id="javacode"  style="top: 0px;margin-left: 20px; padding: .5%;
    width: 100%;
 	  font-weight: 400;
    font-size: 14px;
    line-height: 20px;
    border-left: 5px solid #48e244;
    border-right: 5px solid #f44336;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: right;">
</section>
		<br/>	<br/>	<br/>	<br/>	<br/>
 		<table style="width: 100%;margin-top: 400px;" border="0">
 			<tr id="custominputsection">
 			 <td colspan="2">
 					<div class="notification-setting setting-box" style="background-color: #fff; position: relative;padding: 0px;margin-bottom: 0px;">
                            <ul style="display: inline;" id="inputchecklable">
                                <li style="width: 220px;">
                                     <input type="checkbox" class="inputcheck" id="following-user">
                                    <label for="following-user">
                                       Test Against Custom Input
                                        <i class="icon md-check-1"></i>
                                    </label>
                                </li>
                            </ul>
                             <table id="custominputwithbutton">
                             <tr>
                             <td>
                            <textarea rows="2" cols="2" id="custominput" name="custominput" class="form-control" style="font-size: 16px;display: inline;width: 670px;"></textarea>
                            </td>
                            <td>
                            <input type="button" value="Compile & Run Code" class="mc-btn btn-style-1" id="runCode" style="background-color: #00bcd4;margin-left:30px;margin-top: 3px; font-weight: 500;font-size: 16px;"/>
                            </td>
                            <tr>
                            </table>
               		 </div>
 			</td>
 			</tr>
 		<tr  id="customInputText">
 		 <td align="left" width="100%" colspan="2">	
 		 	<img src="${pageContext.request.contextPath}/images/codings/results.jpg" style="height: 40px;margin-left: 15px;">
 			<span id="customoutput" style="color:red;font-size: 16px;margin-left: 5px;">.....</span>
 			  <div class="loader" id="progressbar">
 			  Please wait code is executing.....&nbsp;&nbsp;&nbsp;&nbsp;
  <div class="dot"></div>
  <div class="dot"></div>
  <div class="dot"></div>
  <div class="dot"></div>
  <div class="dot"></div>
</div>
 		</td>
 		</tr>
 		<tr>
 		<td colspan="2">
 			 <k:if test="${item.problemType=='PUINM'}">	
 			 	<br/>
 			 		<input type="button" value="Compile Your Code" class="mc-btn btn-style-1" id="compileCode" style="background-color: #607d8b;;margin: 0px; font-weight: 500;font-size: 16px;margin-right:60px;"/>
 				<input type="button" value="Submit Final Code" class="mc-btn btn-style-1" id="submitFinalCode" style="background-color: #8bc34a;;margin: 0px; font-weight: 500;font-size: 16px;display: inline;"/>
 			</k:if>		
 			
 			 <k:if test="${item.problemType=='PUNINM'}">		
 			<input type="button" value="Compile & Run Code" class="mc-btn btn-style-1" id="compileRunCode" style="background-color: #2196f3;;margin-right: 10px; font-weight: 500;font-size: 16px;display: inline;"/>
 			<input type="button" value="Submit Final Code" class="mc-btn btn-style-1" id="submitFinalCode" style="background-color: #8bc34a;;margin: 0px; font-weight: 500;font-size: 16px;display: inline;"/>
 			</k:if>
 		</td>	
 		</tr>
 		</table>
 	<hr/>	
 	 <k:if test="${item.problemType=='PUIM'}">	
 	<input type="button" value="Compile Your Code" class="mc-btn btn-style-1" id="compileCode" style="background-color: #607d8b;;margin: 0px; font-weight: 500;font-size: 16px;margin-right:60px;"/>
 	<input type="button" value="Upload Code & Execute Test Cases" class="mc-btn btn-style-1" id="uploadCode" style="background-color: #046dc9;;margin: 0px; font-weight: 500;font-size: 16px;margin-right:60px"/>
 	<input type="button" value="Submit Final Code" class="mc-btn btn-style-1" id="submitFinalCode" style="background-color: #8bc34a;;margin: 0px; font-weight: 500;font-size: 16px;display: inline;"/>
 	</k:if>
	<%--  <k:if test="${sessionScope.user_session_data.role!='admin'}">	
 		<input type="button" value="Submit Final Code" class="mc-btn btn-style-1" id="submitFinalCode" style="background-color: #8bc34a;;margin: 0px; font-weight: 500;font-size: 16px;"/>
     </k:if> --%>	
 	 <hr/>
 	 <span id="codemessage" style="margin-left: 15px;color:black;font-size: 22px;white-space: pre">
 	   
 	 </span>
 	 <div id="testSummarySection">
 	 <p class="ptestsummary">Test Case Summary
 	 	<a href="javascript:" id="closesummary"><img src="${pageContext.request.contextPath}/images/codings/close.png" style="height: 20px;margin-right: 200px;"></a>
 	 	 <img src="${pageContext.request.contextPath}/images/codings/test-pass.png" style="height: 20px;">Test Case Passed :
 	 	  <span id="testCasePassed"></span>  &nbsp;&nbsp;&nbsp;&nbsp;   <img src="${pageContext.request.contextPath}/images/codings/test-fail.png" style="height: 20px;">Test Case Failed : <span id="testCaseFailed">
 	 	  </span>
 	 	  <input type="hidden" id="testPassed" name="testPassed" value="0"/>
 	 	  <input type="hidden" id="testFailed" name="testFailed" value="0"/>
 	 	  <input type="hidden" id="compilationError" name="compilationError"/>
 	 	
 	 </p>
 	 <k:if test="${sessionScope.user_session_data.role=='admin'}">	
 	 <table class="table table-bordered" id="testCasesDetailTab">
    <thead>
      <tr style="background-color: #82a7c6;">
        <th>SNO</th>
        <th>Input</th>
      <th>Expected Output</th>
         <th>Actual Output</th>
         <th>Test Status</th>
      </tr>
    </thead>
    <tbody id="testsummarydata">
      <tr>
      	<td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
      </tr>
       <tr>
      	<td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
         <td>&nbsp;</td>
         <td>&nbsp;</td>
      </tr>
    </tbody>
  </table></k:if>
  </div>
  </form>
  
    <!-- END / SETTING -->
</section>