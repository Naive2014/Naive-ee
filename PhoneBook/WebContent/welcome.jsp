<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="onest.dao.impl.*"%>
<%@page import="onest.entity.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
Users users =  (Users)usersDaoImpl.UsersSelect((String)session.getAttribute("ID"));//获取ID并查询数据
pageContext.setAttribute("user", users);
System.out.print((String)session.getAttribute("ID")+"/n");
%>
<div align="left">
	<h1>欢迎您${user.username}</h1><br><br>
	用户信息:<br><br>
	ID:${sessionScope.ID}<br><br>
	昵称:${user.name}<br><br>
	手机:${user.mobile}<br><br>
	QQ:${user.QQ}<br><br>
	邮箱:${user.email}<br><br> 
	微信:${user.wechat}<br><br>
	地址:${user.address}<br><br>
	<a href="reviseuser.jsp" >修改信息</a>
	<a href="/PhoneBook/WelcomeServlet?id=${user.username}%>" >删除用户</a><br>
	<a href="add.html">添加联系人</a> <a href="/PhoneBook/WelcomeServlet?Exit=esc">退出系统</a>
</div>

		<div id="content" align="center">
			<table border="1" >
				<tr>
					<th class="tablehead">联系人ID</th>
					<th class="tablehead">姓名</th>
					<th class="tablehead">地址</th>
					<th class="tablehead">电话</th>
					<th class="tablehead">QQ</th>
					<th class="tablehead">微信</th>
					<th class="tablehead">学校</th>
					<th class="tablehead">性别</th>
					<th class="tablehead">修改</th>
					<th class="tablehead">删除</th>
				</tr>
				<%	ContactsDaoImpI contactsDaoImpI = new ContactsDaoImpI();
					//ArrayList<Contacts> arrayList = new ArrayList<Contacts>(contactsDaoImpI.ContactsSelect((String)session.getAttribute("ID")));
					ArrayList<Contacts> arrayList = (ArrayList<Contacts>)(contactsDaoImpI.ContactsSelect((String)session.getAttribute("ID")));
					for (Contacts contacts : arrayList) {
						pageContext.setAttribute("contacts", contacts);
				%>
				<tr>
					<td>${contacts.pid}</td>
					<td>${contacts.name}</td>
					<td>${contacts.address}</td>
					<td>${contacts.mobile}</td>
					<td>${contacts.QQ}</td>
					<td>${contacts.wechat}</td>
					<td>${contacts.school}</td>
					<td>${contacts.sex}</td>
					<td><a href="update.jsp?id=${contacts.id}&pid=${contacts.pid}">修改</a></td>
					<td><a href="/PhoneBook/ContactsDeleteServlet?id=${contacts.id}&pid=${contacts.pid}">删除</a></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>
</body>
</html>