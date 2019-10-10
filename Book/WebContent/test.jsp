<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>书本ID</th>
				<th>书名</th>
				<th>价格</th>
				<th>书本描述</th>
				<th>操作</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="i" begin="0" end="${num}" items="${sessionScope.arrayList}">
			<tr>
				<td>${i.id}</td>
				<td>${i.bookName}</td>
				<td>${i.price}</td>
				<td>${i.description}</td>
				<td>
					<a href="AddServlet?id=${i.id}"><button>修改</button></a>
					<a href="DelServlet?id=${i.id}"><button>删除</button></a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="addbook.jsp"><button type="button">新增书本</button></a>
</body>
</html>