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

	<h1>Make it</h1> <br>
	
	<br>
	<form action="/serchM">
	<select name="month">
	<option value=""></option>
	</select>
	</form>
	
	<a href="/today">오늘</a>
	<a href="/write"> + </a>
	
	<form action="/testForeach" id="myForm">
	
	</form>
	
	
</body>
</html>