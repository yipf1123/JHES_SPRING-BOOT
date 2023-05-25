<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("Model : Hellow World");
%>

<br>

<%-- EL태그 ${} --%>
그녀의 이름은 ${name} 입니다.<br>
${name}씨는 현재 ${adress}에 거주중 입니다.
</body>
</html>