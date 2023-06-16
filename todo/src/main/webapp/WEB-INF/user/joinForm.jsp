<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/join" method="post">
		id : <input type="text" name="id"> <br> 
		pw : <input type="password" name="pw"><br> 
		이름 : <input type="text" name="name"><br>
		${msg}<br> 
		<input type="submit" value="회원가입">
	</form>
</body>
</html>