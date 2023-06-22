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

<script src="/assets/js/code.jquery.com_jquery-3.7.0.js"></script>
<script>
	
	//페이지 로딩이 끝나면
	window.onload = function(){
		// 한 페이지에 하나밖에 못 씀
		// 여러 페이지를 이 jsp에서 로딩하는 경우
		// 각각 onload가 지정되어 있다면
		// 마지막 onload만 적용됨
		// 변수에 덮어쓰기 방식이라서
	}
	
/* 	function a(){		
	}
	window.addEventListener("load",a)
	window.removeEventListener("laod",a); // 익명구현 메소드는 적용할 수 없음
	 */
	
/* 	window.addEventListener("load",function(){
		init();
		bind();		
	}); 								*/
	

/* 	$(document).ready(function(){
			})

	$(window).on("laod",function(){
			})
										 */

	$(function(){
		init();
		bind();
	})
			
			
	function init(){
		// ajax로 컨트롤러에 요청
		// 받은 내용(json)을
		// html에 표시

	   getList()
	
	}
	
	function bind(){
		$(".paging").off("click").on("click",function(event){
			// event.target, this 같은 것
			//$(event.target), $(this)는 jquery 객체로 감싸줌
			
			// 내 요소 안의 모든 text만 가져오기
			console.log("$(this).text()",$(this).text())
			
			
			// 자식요소 찾기
			console.log('$(this).find("strong").text()',$(this).find("strong").text())
			
			//참고로 부모는 .parent()
			//참고로 부모중에서 찾은거 .parents(".abc")
			console.log('$(this).attr("data-page")',$(this).attr("data-page"))
			console.log('$(this).attr("page")',$(this).attr("page"))
			
			let pageNum = $(this).attr("data-page")
			getList(pageNum)
		})
		
	/* 	//화살표 함수, 익명함수
		function fn(a,b,c)
		(a,b,c) =>{}
		
		function fn(a){}
		(a) =>{}
		a=>{}
		
		function fn(){}
		() => {}
		=> {} //이거 안됨
		
		let fn = function (a){
			return a+1
		}
		let fn = a =>a+1
		fn(3) //4 */
		
		
		
		$("#countPerpage").off("change").on("change",()=>{
			getList(1)
		})
		
		
	}
	
	function getList(pageNum){
		
		console.log(typeof(pageNum)) //'undefined' 라고 나옴
		
		let param = {}
		
		if(pageNum != undefined) {param.pageNum = pageNum}
		
		console.log("param", param)
		
		// 페이지당 표시 수
		param.countPerpage = $("#countPerpage").val()
		
		//ajax 실행
        let option = {
            "url" : "/api/todo?",
            "type" : "get",
            "data" : param,
		
          
            "success" : function(data){
            	$("#content").html("")
//            	$("#content").remove() // tag 자체를 삭제
            	
				//JSON.parse("{a:1}")
				//JSON.stringify("{data}") // '{"a":"1"}'            	
            	console.log("data",data);
                console.log("countPerpage", data.countPerpage);
                console.log("data['total']",data['total']);
                
                //이런 것도 있다; string을 넣으면 실행해줌
                // eval("console.log(1)")
                
                // 리스트 표시
                
                // 백틱 사용법; 템플릿 리터럴

                // jsp 그냥은 el로 인식해서 사용 불가
                // \${변수명} dlfjgrp goruf
                console.log(`data.countPerpage : \${data.countPerpage}`)
                
               		for(let i=0; i<data.list.length; i++){
               			let item = data.list[i];
   
            
               		let html = "";
           			html +='<div class="row">';
        			html +='<div class="todo">'+ item.todo_id +'</div>';
        			html +='<div class="todo">';
        			html +='	<input type="checkbox" class="chk" value="'+ item.todo_id +'" >';
        			
        			console.log()
        			if(item.done_date != null){
        			html +='checked="checked"';			
        			}
        			html +='</div>';
        			html +='<div class="todo">';
        			html +='	<a href="/update.do?todo_id='+item.todo_id+'">'+item.todo +'</a>';
        			html +='</div>';
        			html +='<div class="todo">'+item.due_date +'</div>';
        			
        			//javascript에서 false란?
        			// flase, null, undefiened 0
        			// true란? flase가 아닌 모든것
        			
        			let done_date =item.done_date;
        			if(done_date == null){
        				done_date=""; // 그냥 쓰면 "null" 표시 되니까
        			}
        			
        			
        			
        			html +='<div class="todo">'+done_date+'</div>';
        			
        			html +='<div class="todo">'+item.name+'</div>';
        			html +='<div class="todo">';
        			html +='	<a href="/delete?todo_id='+item.todo_id+'"> ';
        			html +='	<input type="button" value="삭제"></a>';
        			html +='</div>';
        			html +='</div>';
               		
        			$("#content").append(html)
               		} 
            }, 
            "error" : function(data){
                console.log("ERROR", data)
            }
        }
        $.ajax(option)
		
	}
	 
	 
	
</script>

</head>
<body>

	<header>
		<h1>할 일 목록</h1>
	</header>

	<section>
		<a href="/add.do">+등록</a>
		<div style="text-align: right; padding-right : 80px;">
			<select id="countPerpage">
				<option value="5">5개</option>
				<option value="10">10개</option>
				<option value="25">15개</option>
				<option value="20">20개</option>
			</select>
		</div>
		<div>
			<div class="tittle">할일 id</div>
			<div class="tittle">완료</div>
			<div class="tittle">할일</div>
			<div class="tittle">마감예정일</div>
			<div class="tittle">실제마감일</div>
			<div class="tittle">회원 이름</div>
			<div class="tittle">삭제</div>
		</div>
		<!--  목록 -->
		<div id="content"></div>


		<!-- 페이징  -->
		<div style="width: 200px; margin: 0 auto">
			<span class="paging" data-page="1"> <strong>1</strong>
			</span> <span class="paging" data-page="2"> <strong>2</strong>
			</span> <span class="paging" data-page="3"> <strong>3</strong>
			</span>

		</div>

	</section>

</body>
</html>