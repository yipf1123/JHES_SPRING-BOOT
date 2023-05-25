<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
welcome<br>
test : 123${ test }456  : model이 없어서 주소창에 test 정보를 가져 올 수 없음<!-- null 이면 아에 el 태그가 없는것 처럼 표현 됨 --><br>
test : 123${ param.test }456  : param을 붙이면 주소창에 test 정보를 가져 올 수 있음<!-- null 이면 아에 el 태그가 없는것 처럼 표현 됨 -->
</body>
</html>