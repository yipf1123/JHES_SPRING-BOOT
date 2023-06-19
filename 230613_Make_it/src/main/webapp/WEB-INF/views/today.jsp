<%@page import="java.util.Calendar"%>

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

<%
  Calendar calendar = Calendar.getInstance();
  int year = calendar.get(Calendar.YEAR);
  int month = calendar.get(Calendar.MONTH) + 1; // 월은 0부터 시작하므로 1을 더해줍니다.
  int day = calendar.get(Calendar.DAY_OF_MONTH);
%>
<%= year %>년 <%= month %>월 <%= day %>일<br>
<%-- 	${list[0].day}<br> --%>
	
	<a href="/dayform?day=<%= year %>-<%= month %>-<%= day %>">추가</a>
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