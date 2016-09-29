<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.IOdata" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>ChatRoom</title>

<script language="javascript">
	function refresh(){		
		form1.content.value="";
		document.form1.submit();

	}
	function Signout(){
		window.self.location = "windows.jsp";
	}

</script>

<style>
<!--
-->
</style>

</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		if ("0".equals(session.getAttribute("username"))||null==session.getAttribute("username")) {

			response.sendRedirect("windows.jsp");
		}
		String value = request.getParameter("reply");
		value = ("".equals(value) || value == (null)) ? "All" : value;
	%>
	<table width="600" align="center" valign="top" border="" style="background:#AAAAFF">
		<tr>
			<td colspan="2" align="center" style="font-size:45PX;font-family:幼圆"><b>
				<img src="title.png">
			</b></td>
		</tr>
		<tr>
			<td width="60%"><jsp:include page="comments.jsp"></jsp:include></td>
			<td>
				<form action="" name="form1" method="post" id="form1">
					<table align="center">
						<tr>
							<td width="40%" height="20">姓名</td>
							<td><select name="person" id="person">
									<option><%=session.getAttribute("username")==null?request.getParameter("person"):session.getAttribute("username")%></option>
									<option>匿名</option>
							</select>
							
							 回复 @
							<input type="text" name="reply" id="reply"  width="8" value=<%=value %>></td>
							
						</tr>
						<tr>
							<td>回复</td>
							<td><textarea name="content" cols="25" rows="8" id="content"
									style="background:#F5F5F5"></textarea></td>
						</tr>
					</table>
					<br>

					<table align="center">
						<tr>
							<td><input name="Button" type="submit" class="btn_gray"
								value="发送"></td>
							<td><input name="Button" type="button" class="btn_gray"
								value="刷新" onClick="refresh()"></td>
							<td><input name="signout" type="button" class="btn_gray"
								value="登出" onclick="Signout()"></td>	
						</tr>
					</table>

				</form>

			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="comments2.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="2"><img src="title.png"></td>
		</tr>
	</table>
</body>
</html>






