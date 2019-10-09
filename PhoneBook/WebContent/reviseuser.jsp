<%@page import="onest.dao.impl.UsersDaoImpl"%>
<%@page import="onest.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
Users users = new Users();
users = usersDaoImpl.UsersSelect((String)session.getAttribute("ID"));//获取ID并查询数据
String password = users.getPassword();
String name = users.getName();
String mobile = users.getMobile();
String qq = users.getQQ();
String email = users.getEmail();
String wechat = users.getWechat();
String address = users.getAddress();
%>
<div align="center">
<h1>修改信息</h1>
<form action="ReviseUsers" method="post">
密码:<input type="password" name="password" value="<%=password%>"><br><br>
昵称:<input type="text" name="name" value="<%=name%>"><br><br>
手机:<input type="text" name="mobile" value="<%=mobile%>"><br><br>
QQ:<input type="text" name="qq" value="<%=qq%>"><br><br>
邮箱:<input type="text" name="email" value="<%=email%>"><br><br>
微信:<input type="text" name="wechat" value="<%=wechat%>"><br><br>
地址:<input type="text" name="address" value="<%=address%>"><br><br>
<input type="submit" value="确认修改">
</form>
</div>
</body>
</html>