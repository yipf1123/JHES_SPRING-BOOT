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



<form action="/login_check" method="post">
id : <input type="text" name="id"> <br>
pw : <input type="password" name="pw"><br>
<input type="submit" value="로그인">
</form>
<h1>${msg}</h1>

</body>
</html>