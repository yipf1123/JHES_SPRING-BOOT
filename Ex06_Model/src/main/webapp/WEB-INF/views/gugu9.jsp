<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp에서 jstl과 el을 이용해서 구구단 출력</h1>
	<h2>0단계 : 7단 모두 출력</h2>

	<%
	List list = new ArrayList();
	int p = 7;
	for (int i = 1; i <= 9; i++) {
		list.add(p + " x " + i + " = " + (i * p));
	}
	%>

	<c:forEach var="item" items="<%=list%>" begin="0" end="8">
	${item}<br>
	</c:forEach>
	<br>
	<br>

	<h2>1-1단계 : 7단 중에서 홀수번째만 표시</h2>


	<%
	List list2 = new ArrayList();
	for (int i = 1; i <= 9; i += 2) {
		list2.add(p + " x " + i + " = " + (i * p));
	}
	%>

	<c:forEach var="item" items="<%=list2%>" begin="0" end="9">
	${item}<br>
	</c:forEach>
	<br>
	<br>

	<h2>1-2단계 2~9단까지 출력</h2>

	<%
	List list3 = new ArrayList();
	for (int i = 1; i <= 9; i++) {
		for (int a = 2; a <= 9; a++) {
			list3.add(a + " x " + i + " = " + (i * a));
		}
	}
	%>

	<c:forEach var="item" items="<%=list3%>" begin="0" end="81"
		varStatus="loop">
	${item}&nbsp;&nbsp;&nbsp;
		<c:if test="${loop.count % 9 == 0}">
			<br>
		</c:if>

	</c:forEach>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<c:forEach var="a" begin="1" end="9">
		<c:forEach var="b" begin="2" end="9">
			<c:choose>

			<c:when test="${a*b < 10}">
			${b} x ${a}  = &nbsp;&nbsp;0${a*b}&nbsp;&nbsp;
			</c:when>
				
			<c:otherwise>
			${b} x ${a}  = &nbsp;&nbsp;${a*b}&nbsp;&nbsp;
			</c:otherwise>
			
			
			</c:choose>
		</c:forEach>
		<br>
	</c:forEach>

	<h2>2단계 홀수번째 줄과 짝수번째 줄의 배경색이 다르게</h2>
	<%
	int a = 7;
	%>
	<c:set var="a" value="<%=a%>" />
	<c:forEach var="b" begin="1" end="9" varStatus="loop">
		<c:choose>

			<c:when test="${loop.count % 2 == 0}">
				<div style="background-color: #054954;">${a}x ${b} = ${a*b}</div>
			</c:when>

			<c:otherwise>
		 			${a} x ${b}  = ${a*b}
				</c:otherwise>











		</c:choose>
	</c:forEach>


</body>
</html>