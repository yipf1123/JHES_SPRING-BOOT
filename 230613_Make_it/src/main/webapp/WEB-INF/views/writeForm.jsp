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
 
<form id="dayform" action="/dayform" method="post">
날짜 <input type="date" name="day" value="${day}"><br>
</form>

<form  action="/write" method="post">
<input type="hidden" name="day" id="day" value="${day}">
할일 <input type="text" name="toDo"> <input type="submit" value="추가"><br><br>
</form>

	<table>
	<c:forEach var="dto" items="${list}">
	<tr>
	<td><input type="checkbox" name="check_status" value="${dto.check_status}"
	<c:if test="${dto.check_status == 'true'}"> checked="checked"</c:if>></td>
	<td><span id="todo-${dto.do_id}" onclick="editToDo(${dto.do_id},${day})">${dto.toDo}</span></td>
	<td><a href="/delete?do_id=${dto.do_id}&day=${dto.day}">삭제</a></td>
	</tr>
	</c:forEach>
	</table>
	
		<a href="/list">목록으로</a>
	<!-- js -->
	<script src="writeForm.js"></script>
</body>
</html>