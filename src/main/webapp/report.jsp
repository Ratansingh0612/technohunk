<!DOCTYPE html>
<html lang="en">   
<head>
<title>ONLINE CARRER COUNSELLING RESULT</title>
<style>

table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid #65d946;
}
</style>
</head>
<body>
<p style="width: 70%;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 20px;font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
Hello  $emailMessageVO.name
<br/><br/>
<img src="cid:clogo" width="40px;"/><br/>
<b style="background-color: #e0d4d4;">
BELOW IS YOUR ONLINE CARRER COUNSELLING RESULT:-</b><br/>
</p>	
 <hr style="height: 4px;background-color: #bdbdd9"/>  
 		   <div style="font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';background-color: #f49347;height: 28px;font-size: 20px;font-weight: bold;"><b>Personal Details</b></div>
  			 <table  style="font-size: 16px;width:100%">
        <tbody>
          <tr style="font-size:23px;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-size: 16px;font-style: normal;	font-variant: normal;font-weight: 500;">
                <td style="width: 30%;">Name : ${emailMessageVO.name}</td>
                <td style="width: 30%"><img src="cid:emailicon" style="height: 25px;">&nbsp;Email  : <b>${emailMessageVO.toEmail}</b></td>
               <td style="width: 20%">Test ID : <b>${emailMessageVO.userSessionId}</b></td>
                <td style="width: 20%;"><img src="cid:mobileicon"  style="height: 25px;"/>&nbsp;Test Status : <b>${emailMessageVO.mobile}</b></td>
            </tr>
            </tbody>
         </table>   
<br/>
<img src="cid:cimage" style="height: 150px;"/>
    <div style="font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';background-color: #e4e339;height: 28px;font-size: 22px;font-weight: bold;">Your Self Awareness Test Result Are - ></div>
     	<hr/>
       <table class="table table-bordered" style="font-size: 16px;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';">
       			<thead style="background-color: #40c9a2;">
       				<th>Trait</th>
       				<th>Description</th>
       				<th>Score%</th>
       			</thead>
               <tbody>
           <tr>
                <td style="font-weight: bold;">&nbsp;Realistic </td>
                <td>Involve work activities that include practical, hands-on problems and solutions. They often deal with
real-world materials, and do not involve a lot of paperwork or working closely with others.
                </td>
                <td>&nbsp;${traitScopeVO.realistic}</td>
                </tr>
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Artistic  </td>
                <td>Involve working with forms, designs and patterns. They often require self-expression and the work can be done without following a clear set of rules.
                </td>
                <td>&nbsp;${traitScopeVO.artistic}</td>
                </tr>
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Investigative   </td>
                <td>Involve working with ideas, and require an extensive amount of thinking. These occupations can involve searching for facts and figuring out problems
mentally.

                </td>
                <td>&nbsp;${traitScopeVO.investigative}</td>
                </tr>
                
                 <tr>
                <td style="font-weight: bold;">&nbsp;Enterprising    </td>
                <td>Involve starting up and carrying out projects, leading people and making many decisions, risk taking, dealing with business.

                </td>
                <td>&nbsp;${traitScopeVO.enterprising}</td>
                </tr>
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Conventional     </td>
                <td>Involve following set procedures and routines, working with data and details more than with ideas. Usually there is a clear line of authority to follow.

                </td>
                <td>&nbsp;${traitScopeVO.conventional}</td>
                </tr>
                
                
                  <tr>
                <td style="font-weight: bold;">&nbsp;Social     </td>
                <td>Involve working with, communicating with, and teaching people. These occupations often involve helping or providing service to others.

                </td>
                <td>&nbsp;${traitScopeVO.social}</td>
                </tr>
        </tbody>
         </table> 
         <br/> 
                  <div style="background-color: #bfe5ff;height: 28px;font-size: 20px;font-weight: bold;">Some  Skill options for you can be : </div>
			<table class="table table-bordered" style="font-size: 17px;">
               <tbody>
           <tr>
                <td><img src="cid:jobcard1"/> </td>
                   <td><img src="cid:jobcard2"/></td>
                       <td><img src="cid:jobcard3"/> </td>
                </tr>
                </tbody>
                </table>         
                    <br/> 
                  <div style="background-color: #c7f9c1;height: 28px;font-size: 20px;font-weight: bold;">Next 3 Skills options can be  </div>
			<table class="table table-bordered" style="font-size: 17px;">
               <tbody>
           <tr>
                <td><img src="cid:jobcard4"/> </td>
                   <td><img src="cid:jobcard5"/></td>
                       <td><img src="cid:jobcard6"/> </td>
                </tr>
                </tbody>
                </table>  
         
<p style="width: 70%;font-size:18px;font-family: 'Trebuchet MS', 'Lucida Grande', 'Lucida Sans Unicode', 'Lucida Sans';font-style: normal;	font-variant: normal;font-weight: 500;line-height: 26.4px;">
<br/>
Please feel free to reach use in case of any question or query.
<br/>
Thanks & Regards,<br/>
<b>JSPR Tech Test Admin</b>
<br/>
 Email : <b>jspraction@gmail.com</b>  
<br/>
<img src="cid:image"/>
</p>
</body>
</html>