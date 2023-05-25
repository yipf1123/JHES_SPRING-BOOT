<%@ page 
language="java" 
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.ArrayList"
%> 
<%! // 필드
	String name = "은솔";

	void test(){
		
	}
%>

<!-- html -->
<%-- JSP 주석 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int a = 10;
	System.out.println(a); // Console에 찍힘
	
	out.println("<h1>Hello World!"+ a + "</h1>"); // html에 적어주는 역할

%>

a의 값은 : <%= a %>

</body>
</html>