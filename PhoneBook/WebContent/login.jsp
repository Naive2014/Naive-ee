<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Phonebook登录</title>
</head>
<body>
<div align="center"> 
<form action="LoginServlet" method="post">
用户名:<input type="text" name="username" value=""><br><br>
密码:<input type="password" name="password"><br><br>
<input type="submit" value="登录"><br>
</form>
<button onclick="window.location.href ='register.jsp'">注册</button>
</div>
</body>
</html>