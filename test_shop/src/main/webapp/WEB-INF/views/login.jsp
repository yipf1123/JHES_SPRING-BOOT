<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test ="${msg != null }">
<h1>${msg}</h1>
</c:if>
	
	
	<form action="/login_check" method="post">
		id : <input type="text" name="id"><br> 
		password : <input type="text" name="pw"><br> 
		<input type="submit" value="로그인">

	</form>

</body>
</html>