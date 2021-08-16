<!DOCTYPE html>
<html lang="en">   
<head>
<title>Regarding online test link</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style>
table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}
</style>
<script type="text/javascript">
(function () {
    var beforePrint = function () {
        alert('Functionality to run before printing.');
    };

    var afterPrint = function () {
        alert('Functionality to run after printing');
    };

    if (window.matchMedia) {
        var mediaQueryList = window.matchMedia('print');
        mediaQueryList.addListener(function (mql) {
            //alert($(mediaQueryList).html());
            if (mql.matches) {
                beforePrint();
            } else {
                afterPrint();
            }
        });
    }

    //window.onbeforeprint = beforePrint;
    //window.onafterprint = afterPrint;

}());
</script>
</head>
<body>

<input type="button" value="HUEEUEU" onclick="window.print();">

<br/>
<p style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
Hello  $username,<br/><br/>
<b style="background-color: #e0d4d4;">Below is your test summary  of  online test:-</b><br/>
</p>	
<hr/>
<img src="cid:cimage" style="height: 150px;"/>
<p style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
  Tech Name : Core-Java &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Test Name : Core Java Beginner &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Test Duration : 10 minutes &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  
</p>
 <table border="1" style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
		<tr style="background-color: #1e2a7b;color:white;">
			<td>&nbsp;Questions Attempted</td>
					<td>&nbsp;Correct Questions</td>
					<td>&nbsp;Wrong Questions</td>
					<td>&nbsp;Not Attempted Questions</td>
					<td>&nbsp;Total Questions</td>
				<td>&nbsp;Scored%</td>
		</tr>
		<tr>
		<td>&nbsp;</td>
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
				<td>&nbsp;</td>
		</tr>
		
		<tr>
			<td colspan="6" style="background-color: #a1ff9a;color:white;">&nbsp;</td>
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