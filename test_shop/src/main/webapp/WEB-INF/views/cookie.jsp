<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.popup {
		border: 1px solid red;
		width: 300px;
		height: 300px;
		
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
	}
</style>
</head>
<body>
	cookie

	<div class="popup">
		공지 팝업<br>
		<input type="checkbox" id="popup_1">1분동안 보이지 않기<br>
	</div>

<script>
	function setCookie(){
		// 읽기
// 		document.cookie
		
		// 쓰기
		// key=value; path=/; expires= GMT,UTC
		
		let now = new Date();
		let after_10s = now.getSeconds() + 10
		now.setSeconds( after_10s )
		
		document.cookie = "popup7=true; path=/; expires="+ now.toGMTString();
		document.cookie = "popup1=false; path=/; expires="+ now.toGMTString();
		console.log("쿠키 설정 완료")
	}
	
	// 쿠키에 추가
	// 단 maxAge의 단위는 초
	function setCustomCookie(key, value, maxAge){
		let now = new Date();
		let after = now.getSeconds() + maxAge
		now.setSeconds( after )
		
		document.cookie = key +"="+ value +"; path=/; expires="+ now.toGMTString();
	}
	
	
	function getCookie(key){
		let value = null;
// 		let key = "popup7";
		let cookie = document.cookie;
		console.log( cookie ) // "popup7=true"
		// "popup7=true; popup5=true; popup7=true; popup6=false"
		// 방법 1
		let cookies = cookie.split("; ")
		for(c of cookies){
			let kv = c.split("=") // =으로 자른 배열
			if(kv[0] == key){
				console.log("kv[0] :", kv[0])
				console.log("kv[1] :", kv[1])
				value = kv[1];
				break
			}
		}
		
		// 방법 2
		let temp_val = c.split(key+"=")
		if(temp_val.length == 1){
			// 원하는 key가 맨 처음에 나오는 겨우
			console.log(" value = ", temp_val[0].split(";")[0])
		} else {
			console.log(" value = ", temp_val[1].split(";")[0])
		}
		
		return value;
	}
	
	setCookie()
	
	getCookie()
	setTimeout(function(){
		getCookie()
	}, 11*1000)
	
	let popup_1 = document.querySelector("#popup_1");
	popup_1.addEventListener("click", function(event){
		// 클릭된(이벤트가 발생한) 요소
		// 그 요소의 체크 여부
		console.log(event.target.checked);
		
		if( event.target.checked ){
			setCustomCookie('popup_1', true, 60);
			document.querySelector(".popup").style.display = "none";
		}
	})
	
	function showPopup(){
		let value = getCookie("popup_1")
		console.log("value :", value, typeof(value) , ( value == 'true' ))
		if( value == 'true' ){
			document.querySelector(".popup").style.display = "none";
		} else {
			document.querySelector(".popup").style.display = "block";
		}
	}
	showPopup();
	
	
</script>
</body>
</html>