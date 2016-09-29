<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Account" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>请登录</title>
</head>
<body>
	<table align="center">
		<form action="" name="form" method="post" border="1">
			<tr><td colspan="2" align="center">登&nbsp;录<br></td></tr>
			<tr>
				<td width="30%"><a>用户名</a></td>
				<td><input name="username" type="text" id="username"
					style="width: 120Px"></td>
			</tr>
			<tr>
				<td>密&nbsp;码</td>
				<td><input name="pwd" type="password" id="pwd"
					style="width: 120Px"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input name="submit"
					type="submit" value="提交"> <input name="reset" type="reset"
					value="重置"></td>
			</tr>
		</form>
		<tr>
		<form  action="" name="form0" method="post">
			
				<td colspan="2"><jsp:include page="register.jsp"></jsp:include>
		</form>
	</table>
</body>
</html>