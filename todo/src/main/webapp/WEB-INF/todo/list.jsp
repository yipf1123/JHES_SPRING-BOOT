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

	<header>
		<h1>할 일 목록</h1>
	</header>

	<section>
		<div>
			<div class="tittle">할일 id</div>
			<div class="tittle">완료</div>
			<div class="tittle">할일</div>
			<div class="tittle">마감예정일</div>
			<div class="tittle">실제마감일</div>
			<div class="tittle">회원 id</div>
		</div>
		
		<c:forEach var="item" items="${list}">
		<div>
			<div class="todo">${item.todo_id }</div>
			<div class="todo">
				<input type="checkbox">
			</div>
			<div class="todo">${item.todo }</div>
			<div class="todo">${item.due_date }</div>
			<div class="todo">${item.done_date }</div>
			<div class="todo">${item.user_id}</div>
		</div>
		</c:forEach>

	</section>

</body>
</html>