<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/rewrite" method="post">
<input type="hidden" name="id" value="${dto.id}">
writer : <input type="text"  name="writer" value="${dto.writer }"><br>
title : <input type="text"  name="title" value="${dto.title }"><br>
content<br>
<textarea name="content" cols="50" rows="10" >${dto.content }</textarea><br>
<input type="submit" value ="수정완료">
</form>

</body>
</html>