<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>PhoneBook注册</title>
</head>
<body>
<div align="center">
<h1>注册</h1>
<form action="RegisterServlet" method="post">
用户名:<input type="text" name="username"><br><br>
密码:<input type="password" name="password"><br><br>
地址:<input type="text" name="address"><br><br>
电话:<input type="text" name="mobile"><br><br>
昵称:<input type="text" name="name"><br><br>
QQ:<input type="text" name="qq"><br><br>
微信:<input type="text" name="wechat"><br><br>
邮箱:<input type="text" name="email"><br><br>
<input type="submit" value="点击注册">
</form>
</div>
</body>
</html>