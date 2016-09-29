<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.Account" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>ChatRoom</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		Account ac = new Account();
		ac.readAccount();
		session.removeAttribute("username");
		session.setAttribute("signin", "0");//登出跳转后，登录状态重置为0（登出）
		
	
		if (request.getParameter("username") != null
				&& ac.isUser(request.getParameter("username"), request.getParameter("pwd"))) {
			System.out.println(request.getParameter("username") + "：登录成功");
			session.setAttribute("username", request.getParameter("username"));
			session.setAttribute("signin", "1");
			response.sendRedirect("index.jsp");

		} else {
			System.out.println(request.getParameter("username") + "：登录失败");
	%>
			<table align="center">
				<tr><td><img src="title0.png"></td></tr>
				<tr><td align="center">
					<label style="color:red">请输入用户名、密码登录</label></td></tr>
				<tr><td>	
					<jsp:include page="login.jsp"></jsp:include></td></tr>
				<tr><td align="center">已有注册用户<%=ac.numOfUser() %>人</td></tr></table>
	<%
		}
		if (request.getParameter("regname") != null){
			String alert = ac.creatAccount(request.getParameter("regname"), request.getParameter("code"),request.getParameter("code1"));
	%>
		<table align="center"><tr><td>
			<label align="center" style="color:red"><%=alert %></label></td></tr></table>
	<%
		}
	%>

</body>
</html>