<!DOCTYPE html>
<html lang="en">   
<head>
<title>Regarding online test link</title>
<style>
table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}
</style>
</head>
<body>
<p style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
Hello  $emailMessageVO.name<br/><br/>
<b style="background-color: #e0d4d4;">Below is your summary of coding problem :-</b><br/>
</p>	
<hr/>
<img src="cid:cimage" style="height: 150px;"/>
<p style="width: 85%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
  Name : $emailMessageVO.name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Userid : $userOnlineExamStatus.userId &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tech Name : $userOnlineExamStatus.techName &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</p>
 <table border="1" style="width:85%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
		<tr style="background-color: #1e2a7b;color:white;">
			<td>&nbsp;Problem Title</td>
					<td>&nbsp;Duration</td>
					<td>&nbsp;Test Cases Passed</td>
					<td>&nbsp;Test Cases Failed</td>
					<td>&nbsp;Grade</td>	
			</tr>
		<tr>
					<td>&nbsp;$problemTitle</td>
					<td align="center">&nbsp;$cduration</td>
					<td>&nbsp;$testCasesPassed</td>
					<td>&nbsp;$testCasesFailed</td>
					<td>&nbsp;$grade</td>
		</tr>
		<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td colspan="7" style="background-color: #a1ff9a;color:white;">&nbsp;</td>
		</tr>
</table> 
 <br/> <br/>
 <table border="1" style="width:85%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
		<tr style="background-color: #03a9f4;color:white;font-size: 17px;">
			<td>&nbsp;Code Submitted</td>
			</tr>
		<tr>
					<td>&nbsp;
					
					$scode
					
					</td>
		<tr>
					<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td colspan="1" style="background-color: #e7f2f5;color:white;">&nbsp;</td>
		</tr>
</table> 

    
<p style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
<br/>
Please feel free to reach use in case of any question or query.
<br/>
Thanks & Regards,<br/>
<b>JavaHunk Tech Test Admin</b>
<br/>
<img src="cid:image"/>
</p>
</body>
</html>