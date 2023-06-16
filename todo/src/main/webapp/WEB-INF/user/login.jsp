<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>어서옵쇼:)</h1>
<form action="/login" method="post">
id: <input type="text" name="id"><br>
pw: <input type="password" name="pw"><br>
<span style="color:red;"> ${msg}</span><br>
<input type="submit" value="로그인">
</form>
</body>
</html>