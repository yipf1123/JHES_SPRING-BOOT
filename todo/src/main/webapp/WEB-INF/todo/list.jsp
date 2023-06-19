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

	</section>

<script>
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