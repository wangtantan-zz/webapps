<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.getAccount" %>
<%@ page import="java.io.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>ChatRoom</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		getAccount ac = new getAccount();
		session.removeAttribute("username");
		session.setAttribute("signin", "0");//登出跳转后，登录状态重置为0（登出）

		if (request.getParameter("username") != null&&!"".equals(request.getParameter("username"))&& ac.isUser(request.getParameter("username"), request.getParameter("pwd"))) {
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
				<tr><td align="center">已有注册用户<%=ac.numOfUser() %>人</td></tr>
        <tr><td align="center">Invited Code:tantan</td></tr>
      </table>
	<%
		}
		if (!"".equals(request.getParameter("rgname"))&&request.getParameter("regname") != null){
			String alert = ac.createAccount(request.getParameter("regname"), request.getParameter("code"),request.getParameter("code1"));
	%>
		<table align="center"><tr><td>
			<label align="center" style="color:red"><%=alert %></label></td></tr></table>
	<%
		}
	%>

</body>
</html>
