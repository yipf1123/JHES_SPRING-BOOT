<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
id: ${dto.id } <br>
writer: ${dto.writer } <br>
title: <h1>${dto.title }</h1> <br>
content<br>
<textarea>
${dto.content }
</textarea>
<br>
<a href="/list">목록으로</a>
</body>
</html>