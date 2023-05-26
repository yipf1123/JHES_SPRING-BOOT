<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 	#popup{
 		 display : none;
 		 width : 500px;
		 height: 500px;
		 position: absolute;
		 top : 50px;
		 left : 100px;
		 border : 1px solid red;
	 }
 
</style>
</head>
<body>
<a href="http://localhost:8080/send1?id=admin">abchor 태그를 이용</a> 
<br>
<form action="http://localhost:8080/send1">

 id : <input type="text" name="id"><br>

<div id="wrap" style="border = 1px solid red">
 <input type="submit" value="전송"> 
</div>
</form>


<div id ="popup">
	공지입니다.
</div>

<script>
let wrap = document.querySelector("#wrap")
wrap.addEventListener("click", function(event){
	
	console.log("wrap 클릭")	// 자식(submit) 동작이 부모(wrap)도 동작에 영향을 끼치는 버블링이 발생
	
})




let submit = document.querySelector("[type=submit]")
submit.addEventListener("click", function(event){
	// 원래 dom이 동작해야하는 행동(type=submit의 기본 동작)을 막아준다
	event.preventDefault();
	
	// event의 전파를 막아 버블링을 막음
	event.stopPropagation();
		
	console.log(document.querySelector("#popup").style.display) //?? 주의
	setTimeout(function(){	 
	document.querySelector("#popup").style.display = "block"; 
	}, 0) // 0 이후에 가장 빨리 실행시켜라
	
	// 이렇게 하면 if문을 넣어서 submit에 조건문을 걸어 줄 수 있다.
	let frm = document.querySelector("form") 
	let id = document.querySelector("input[name=id]").value 
	console.log("id : ", id)
	
 	if(id.trim().length == 0){ //trim : 스페이스 제거
	setTimeout(function(){
		alert("id를 입력하세요")
	}, 500) 
	}else {
		frm.submit();}
})
</script>
</body>
</html>