<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br/>
							<a href="javascript:;" @click="logout">安全退出</a>
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="/ems_vue/emplist.html">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						社員を追加する
					</h1>
					<form action="${pageContext.request.contextPath}/employee/add" method="post" onsubmit="return checkDate()">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									名前:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									誕生日:
								</td>
								<td valign="middle" align="left">
									<input type="text" id="birthdate" class="inputgri" name="birthday" placeholder="2000/01/01"/>
									<span id="birthmsg" style="color: red;"></span>									
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									月給:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" />
								</td>
							</tr>							
							<tr>
								<td valign="middle" align="right">
									性別:
								</td>
								<td valign="middle" align="left">
									<select name="gender">
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</td>								
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="提出" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	<script>
		var birthdate = document.querySelector('#birthdate')		
		var birthmsg = document.querySelector('#birthmsg')
		
		function checkDate() {
			
			var birthcontent=birthdate.value  
      		var regxName = /^(19|20)\d{2}\/(0[1-9]|1[0-2])\/(0[1-9]|[12]\d|3[01])$/

	      if (birthcontent.match(regxName)) {

	        return true
	      //} else if (!birthcontent.match(regxName)) {
			} else {
	    	  birthmsg.innerHTML = "誤る日付を入力している。"
	        return false
	      } 
    	} 
	</script>	
	</body>
</html>
