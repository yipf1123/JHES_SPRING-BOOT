<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${list[0].day}
		<table>
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
</body>
</html>