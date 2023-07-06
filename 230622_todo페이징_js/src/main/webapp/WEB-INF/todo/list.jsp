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
<style>
.tittle, .todo {
	display: inline-block;
	border: 1px, solid black;
	width: 150px;
	height: 50px;
	vertical-align: top;
}
</style>

</head>
<body>

	<header>
		<h1>할 일 목록</h1>
	</header>

	<section>
	<a href="/add.do">+등록</a>
		<div>
			<div class="tittle">할일 id</div>
			<div class="tittle">완료</div>
			<div class="tittle">할일</div>
			<div class="tittle">마감예정일</div>
			<div class="tittle">실제마감일</div>
			<div class="tittle">회원 이름</div>
			<div class="tittle">삭제</div>
		</div>


	<c:if test="${!empty list}">
		<c:forEach var="item" items="${list}">
		
			<div>
				<div class="todo">${item.todo_id}</div>
				<div class="todo">
					<input type="checkbox" class="chk" value="${item.todo_id}" 
					<c:if test="${not empty item.done_date}"> checked="checked"</c:if>>
				</div>
				<div class="todo">
					<a href="/update.do?todo_id=${item.todo_id}">${item.todo }</a>
				</div>
				<div class="todo">${item.due_date }</div>
				<div class="todo">${item.done_date }</div>
				<div class="todo">${item.name}</div>
				<div class="todo">
					<a href="/delete?todo_id=${item.todo_id}"> 
					<input type="button" value="삭제"></a>
				</div>
			</div>
		</c:forEach>
</c:if>
<c:if test="${empty list }">
<div style="margin: 10px auto 20px auto  ; color: red; text-align: center;"> 등록된 내용이 없습니다.</div>
</c:if>



<%-- 페이징 시작 --%>
		<%
//			int total2 = (int)request.getAttribute("total");
			int total= (int) request.getAttribute("total");
			int countPerpage = (int) request.getAttribute("countPerpage");
//			ceil(101/10) == 11
//			total 과 countPerpage 모두 int라서 ceil가 적용되려면 그전 계산결과를 double로 바꿔줘야 함
			double lastPage = Math.ceil((double)total/countPerpage); 

			// 페이징 그룹
			// 한 그룹당 보여줄 수
			int groupCount =3;
			// 현재 페이지
			int pageNum = (int) request.getAttribute("pageNum");
			// 현재 속한 그룹
			double group = Math.floor((((double)pageNum-1)/ groupCount) + 1);
			// 그룹의 시작 페이지, 끝 페이지
			int end = (int) group*groupCount;
			if(end > lastPage){
				end= (int)lastPage;
			}
			int begin = end - (groupCount-1);
			if(begin < 1){
				begin = 1;
				end = groupCount;
			}
			%>
			
			
<%--	total2 : <%= total2 %> <br>
		<c:set var="total3" value="<%= total2 %>" scope="page" />
		total3: ${total3}<br>
 --%>	
		
	<div style="width: 200px; margin: 0 auto;">
	
	<% if(begin > 1){%>
	<a href="/list.do?pageNum=<%=begin-1%>">이전</a>
	<% } %>
	
	<%
	for(int i=begin; i<=end; i++){	
	%>
	<a href="/list.do?pageNum=<%=i%>">
	<c:set var="i" value="<%= i%>" scope="page" />
	<c:if test="${pageNum eq i}"><strong><%=i%></strong>
	</c:if>
	<c:if test="${pageNum ne i}"><%=i%>
	</c:if>
	</a>
	<% } %>
	
	<% if(end != lastPage){ %>
	<a href="/list.do?pageNum=<%=end+1%>">다음</a>
	<% } %>

	</div>
	
	</section>
<%-- 페이징 끝 --%>


<script>

/* $(".chk").off("click").on("click",function(event){}) */

let list_chk = document.querySelectorAll(".chk")
for(let i=0; i<list_chk.length; i++){
	list_chk[i].addEventListener("click",function(event){
		
/* 		event.target : 실제 클릭된 요소
		event.currentTarget : 이벤트가 바인딩된 요소 */
		
		let target = event.target;
		console.log("target.value : ", target.value);
	    console.log("속성 value :", target.getAttribute("value"))
	    console.log("체크 여부:", target.checked)

	/*     debugger */
	    
		let todo_id = target.value;
		let checked = target.checked;
	    
	    
	    // ajax 객체 생성
        const xhr = new XMLHttpRequest();
        
        // 보낼 준비
        let url = "api/update";

 		xhr.open("PUT", url);
		
 		xhr.setRequestHeader("Content-Type","application/json");
 		
 		let param = {
 		"todo_id": todo_id,
 		"checked": checked
		}
       

        
        // 실행을 지시. 단! 언제 끝날지 모름
		xhr.send(JSON.stringify(param));

        // 다녀오는게 끝났을때(응답 이후)
        xhr.onload = function(){
            console.log(xhr.responseText);
            
            if(Number(xhr.responseText) != 0){
            	location.href="/list.do"
            }else {
            	alert("업데이트 실패")
            }
        }

	        
	    
	})
}

</script>

</body>
</html>