<%@page import="onest.dao.impl.ContactsDaoImpI"%>
<%@page import="onest.entity.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: #FFF68F;
}
#main{
    width:35%;
	font-size: 20px;
	margin:5% auto 5% auto;
	padding: 1% 1% 1% 1%;
	text-align:center;
}
input {
    width:80%;
	font-size: 20px;
	margin:auto auto 10px auto;
}
#sexid{
	text-align:left;
}
.sex{
	width:50px;
}
</style>
</head>
<body>
<body>
<%
	String id = request.getParameter("id");
	String pid=request.getParameter("pid");
	ContactsDaoImpI contactsDaoImpI = new ContactsDaoImpI();
	Contacts contacts =  (Contacts)contactsDaoImpI.ContactsSelectOne(pid, id);
%>
<div id="main">
	<form action="updataservlet?pid=<%=pid%>&id=<%=id%>" method="post">
		<p id="addcontacts">修改联系人信息</p>
		<h3>编号<%=pid%></h3>
		<h3>所属<%=id%></h3><br><br>
		姓名:<input type="text" name="name" value="<%=contacts.getName()%>"><br>
		<br> 地址:<input type="text" name="address" value="<%=contacts.getAddress()%>"><br>
		<br> 电话:<input type="text" name="mobile" value="<%=contacts.getMobile()%>"><br>
		<br> Q Q:<input type="text" name="qq" value="<%=contacts.getQQ()%>"><br>
		<br> 微信:<input type="text" name="wechat" value="<%=contacts.getWechat()%>"><br>
		<br> 学校:<input type="text" name="school" value="<%=contacts.getSchool()%>"><br>
		<br> 性别:<input type="radio" name="sex" value="男" class="sex">男 <input
			type="radio" name="sex" value="女" class="sex">女 <br>
		<input type="submit" name="submit" value="点击修改" id="btnaddcontacts">
	</form>
</div>
</body>
</body>
</html>