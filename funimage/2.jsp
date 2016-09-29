<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>潭老师逗你玩</title>
</head>
<body>
	成功生成图片，可以另存为本地图片&nbsp;<a href="index.jsp">返回  </a><br>
	
	<img src="<%=request.getAttribute("uri") %>"/>
</body>
</html>