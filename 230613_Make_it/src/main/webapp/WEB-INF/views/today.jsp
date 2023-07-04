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
<!-- css -->
<link rel="stylesheet" href="css/today.css">
</head>
<body>
	<div class="box">
		<div class="btn">
			<a href="/dayform?day=${list[0].day}">수정</a> 
			<a href="/dayform?day=${list[0].day}">추가</a>
		</div>
		<div class="container">
	
			<div class="title">
				<img alt="title img" src="/img/title.png">
			</div>
			<div class="info date">Date : ${list[0].day}</div>
			<div class="info goal">Today's Goal :</div>
	<hr>
			<div class="table">
				<table>
					<c:forEach var="dto" items="${list}">
						<tr>
							<td><input type="checkbox" name="check_status"
								value="${dto.check_status}"
								<c:if test="${dto.check_status == 'true'}"> checked="checked"</c:if>></td>
							<td>${dto.toDo}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>
</body>
</html>