<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정</h1>
<form action="/modify" method="post">
	writer : <input type="text" name="writer" value="${dto.writer }"><br>
	title : <input type="text" name="title" value="${dto.title }"><br>
	content<br>
	<textarea name="content" cols="50" rows="10">${dto.content }</textarea><br>
	<input type="hidden" name="id" value="${dto.id }">
	<input type="submit" value="수정하기">
</form>

</body>
</html>