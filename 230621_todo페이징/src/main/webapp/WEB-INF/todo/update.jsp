<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>할 일 수정</h1>

<form action="/update" method="post">	
	할 일: <input type="text" name="todo" value="${dto.todo}"><br>
	마감일 : <input type="date" name="due_date" value="${dto.due_date}" ><br>
	<input type="hidden" name="todo_id" value="${dto.todo_id}" >
	<input type="submit" value="수정">
	<a href="/list.do">
	<input type="button" value="취소">
	</a>
	
</form>

</body>
</html>