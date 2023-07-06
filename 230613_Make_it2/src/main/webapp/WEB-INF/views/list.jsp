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

	<h1>${id}님의Make it</h1>
	<br>

	<br>
	<form action="/serchM">
		<select name="month">
			<option value=""></option>
		</select>
	</form>

	<a href="/today">오늘</a>
	<a href="/writeForm"> + </a>

	<form action="/testForeach" id="myForm">
		<table>
			<tr>
				<td>날짜</td>
				<td>할일</td>
				<td>완료</td>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.day}</td>
					<td>${dto.toDo}</td>
					<td><input type="checkbox" name="check_status"
						value="${dto.check_status}"
						<c:if test="${dto.check_status == 'true'}"> 
	checked="checked"</c:if>></td>
				</tr>
			</c:forEach>
		</table>
	</form>


</body>
</html>