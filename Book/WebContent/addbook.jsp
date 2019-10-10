<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main">
	<form action="Submit?id=${book.id}" method="post">
		<p id="addcontacts"></p>
		书名:<input type="text" name="bookName" value="${book.bookName}"><br>
		<br> 价格:<input type="text" name="price" value="${book.price}"><br>
		<br> 描述:<input type="text" name="description" value="${book.description}"><br>
		<input type="submit" name="submit" value="点击上传">
	</form>
</div>
</body>
</html>