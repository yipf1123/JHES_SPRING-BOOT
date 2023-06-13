<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글 목 록</h1>
	<br>
<a href="/writeForm">글쓰기</a>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>제목</td>
<!-- 			<td>글 내용</td> -->
		</tr>
		<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.id }</td>
			<td>${dto.writer }</td>
			<td><a href="/view?id=${dto.id}">${dto.title}</a></td>
<%-- 			<td>${dto.content }</td> --%>
		</tr>
		</c:forEach>
	</table>

</body>
</html>