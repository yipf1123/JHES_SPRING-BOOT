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
	${list[0].day}<br>
	
	<a href="/dayform?day=${list[0].day}">추가</a>
	<table>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.toDo}</td>
				<td><input type="checkbox" name="check_status"
					value="${dto.check_status}"
					<c:if test="${dto.check_status == 'true'}"> 
	checked="checked"</c:if>></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>