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

	<h1>글목록</h1>
	<br>

	<form action="/testIf">
		<select name="type">
			<option value="w">작성자</option>
			<option value="t">제목</option>
		</select> 
		<input type="text" name="keyword" placeholder="검색어를 입력하세요"> 
		<input type="submit" value="검색">
	</form>

	<br>
	<br>
	<a href="/writeForm">글쓰기</a>
	<form action="/testForeach">
		<input type="submit" value="일괄 조회">
		<table border="1">
			<tr>
				<td>체크</td>
				<td>글번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>부모글</td>
				<!-- 		<td>글 내용</td> -->
				<td>삭제</td>
			</tr>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td><input type="checkbox" name="chk" value="${dto.id }"></td>
					<td>${dto.id }</td>
					<td>${dto["writer"] }</td>
					<td><a href="/view?id=${dto.id }">${dto.title }</a></td>
					<%-- 		<td>${dto.content }</td> --%>
					<td>${dto.parent_id}</td>
					<td><a href="/delete?id=${dto.id }">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>