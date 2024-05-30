<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"	href="../css/style.css" />
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
						社員情報更新
					</h1>
				<form action="${pageContext.request.contextPath}/employee/update" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									社員ID:
								</td>
								<td valign="middle" align="left">
									${employee.id}<input type="hidden" name="id" value="${employee.id}"/>
								</td>
							</tr>							
							<tr>
								<td valign="middle" align="right">
									名前:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${employee.name}"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									誕生日:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="birthday" value="<fmt:formatDate value="${employee.birthday}" pattern="yyyy/MM/dd"/>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									月給:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${employee.salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性別:
								</td>
								<td valign="middle" align="left">
									<select name="gender">
										<option value="1" 
										<c:if test="${employee.gender}">
											selected
										</c:if>
										>男</option>
										<option value="0"
										<c:if test="${!employee.gender}">
											selected
										</c:if>
										>女</option>
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="更新" />
							<input type="button" class="button" value="戻る&gt&gt" onclick="returnlist()">
						</p>
						<script type="text/javascript">
							function returnlist(){
								location="${pageContext.request.contextPath}/employee/list"
							}
						</script>						
					</form>
					
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
