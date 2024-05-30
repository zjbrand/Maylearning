<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>regist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script src="script/script.js"></script>
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p id="nowtime">
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1 style="margin: 5px;">
						新規 
					</h1>
					<h3 style="color: red;margin: 5px;">${param.msg}</h3>
					<form action="${pageContext.request.contextPath}/user/register" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									ユーザー名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username"  />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									名前:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="realname"  />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									パスワード:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性別:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri"  name="gender" value="1" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="gender"  value="0"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									検証コード:
									<img id="num" src="${pageContext.request.contextPath}/user/generateImageCode">
								</td>
								<td valign="middle" align="left">
									<input type="text" name="code" class="inputgri" />
								</td>
								<td>									
									<a href="javascript:;" onclick="document.getElementById('num').src=
									'${pageContext.request.contextPath}/user/generateImageCode?'+(new Date()).getTime()">换一张</a>
									<!-- <script>
									function numImageChg(){
										const num=document.getElementById('num')
										num.src='${pageContext.request.contextPath}/user/generateImageCode?'+(new Date()).getTime()
										console.log(num)
										}									
									</script> -->
								</td>
							</tr>
						</table>
						<p>
							<input type="submit"  class="button" value="提出 &raquo;" />
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
		const nowtime = document.querySelector('#nowtime')
		setInterval(() => {
			nowtime.innerHTML = getTime()
		  }, 1000)  
	
	</script>
	</body>
</html>
