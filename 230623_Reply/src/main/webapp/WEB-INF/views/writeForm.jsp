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
${content }
<!-- writer, title, content를 입력받음 -->

<form action="/write" method="post">
	<input type="hidden" name="parent_id" value="${simplebBsDto.parent_id}">
	writer : <input type="text" name="writer"><br>
	title : <input type="text" name="title"><br>
	content<br>
	<textarea name="content" cols="50" rows="10"></textarea><br>
	<input type="submit" value="글쓰기">
</form>


</body>
</html>