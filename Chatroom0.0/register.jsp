<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>新用户注册</title>
</head>
<body>
	<table align="center" >
			<tr><td colspan="2" align="center"><br>注&nbsp;册<br></td></tr>
		<form action="" name="form0" method="post" border="1">

			<tr>
				<td  width="30%"><a>用户名</a></td>
				<td><input name="regname" type="text" id="regname"
					style="width: 120Px"></td>
			</tr>
			<tr>
				<td>设密码</td>
				<td><input name="code" type="password" id="code"
					style="width: 120Px"></td>
			</tr>
			<tr>
				<td>邀请码</td>
				<td><input name="code1" type="text" id="code1" value="wtt" readonly="true" style="width: 120Px"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input name="submit"
					type="submit" value="注册"> <input name="reset" type="reset"
					value="取消"></td>
			</tr>
		</form>
	</table>
</body>
</html>
