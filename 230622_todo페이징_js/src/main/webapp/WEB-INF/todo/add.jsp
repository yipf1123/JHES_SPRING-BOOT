<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>할 일 추가</h1>

<form action="/add" method="post">	
	할 일: <input type="text" name="todo"><br>
	마감일 : <input type="date" name="due_date"><br>
	<input type="submit" value="등록">
</form>

</body>
</html>