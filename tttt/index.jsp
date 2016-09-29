<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片转换字符</title>
</head>
<body>
	<h1>请上传图片，仅供个人娱乐</h1>
	<form action="servlet/MyServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="test0" id="test">
		<input type="submit" value="提交">	
	</form>
	
</body>
</html>