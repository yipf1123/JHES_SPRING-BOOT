<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	set, if, choose, forEach, out
	<br>
	<h3>c:set</h3>
	스코프scope에 등록
	<br>
	<c:set var="id" value="아이디"></c:set>
	<c:set var="pw" value="비밀번호" />
	el : ${id}
	<br> 스코프scope에 등록
	<br>
	<c:set var="pw" value="비밀번호" scope="session" />

	<hr>
	java에 있는 변수를 el에서 사용할 수 있도록 해보기
	<br>
	<%
	int a = 20;
	%>
	<c:set var="a2" value="<%=a%>" />
	<%-- <%가 먼저 실행되어 a에 20이 채워지고 실행됨--%>
	a2 : ${a2}
	<br>
	<c:set var="a3" value="${a2}" />
	a3 : ${a3}

	<hr>
	<h3>c:if</h3>
	<c:if test="<%=a < 10%>">
	a < 10 <br>
	</c:if>
	<c:if test="<%=!(a < 10)%>">
	!(a < 10) <br>
	</c:if>
	<c:if test="${  a2 lt 10 }">
	(a2 lt 10) <br>
	</c:if>

	<hr>
	<h3>c:choose</h3>
	<c:choose>
		<c:when test="true">
		true
		</c:when>
		
		<c:when test="false">
		false
		</c:when>
		
		<c:otherwise>
		 otherwise
		</c:otherwise>
	
	</c:choose>
	
	<hr>
	<h3>c:forEach</h3>
	<%
	 List list = new ArrayList();
	 list.add(1);
	 list.add(2);
	 list.add(3);
	 list.add(4);
	 list.add(5);
	 list.add(6);
	 list.add(7);
	%>
	<%=list %><br>
	<c:forEach 
	var="item" items="<%= list %>"
	begin="5" end="10"
	varStatus="loop"
	>
	item : ${item }<br>
	${loop.index} : 반복되는 index<br>
	${loop.count} : 현재 반복 횟수<br>
	${loop.first} : true/false 반복의 첫번째인가? <br>
	${loop.last} : T/F 마지막 반복인가?<br>
	<br>
	</c:forEach>
	
	<h3>c:out</h3>
	<c:out value="한eng123"/><br>
	${"<strong>ID</strong>"}<br>
	<c:out value="<strong>ID</strong>"/><br>
	<%
	 String nickname = "<strong>별명</strong>";
	%>
	<c:set var="nickname" value="<%= nickname %>"></c:set>
	

</body>
</html>



















