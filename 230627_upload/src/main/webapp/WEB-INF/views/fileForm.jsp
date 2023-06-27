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

	<form action="/uploadOk" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
	<input type="file" name="filename"><br><br><br>
	<input type="submit" value="업로드">
	</form>

	<hr>
	<table>
	<tr>
	 <th>파일명</th>
	 <th>파일 크기</th>
	 <th>미리보기</th>
	</tr>
	<c:forEach var="item" items="${list}">
	<tr>
	<td>
	<c:url value="/download" var="url">
               <c:param name="path" value="${item.path }" />
               <c:param name="fileName" value="${item.name}" />
            </c:url>
            <a href="${url }">
               ${item.name }
            </a>
	
	
	<%-- <a href="<c:url value='/download?path=${item.path}&fileName=${item.name}'/>">${item.name }</a> --%>
	
	</td>
	<td>${item.size}KB</td>
	<td><img src="${url }" style="width: 100px;">
	</tr>
	
	</c:forEach>
	
	
	</table>

</body>
</html>