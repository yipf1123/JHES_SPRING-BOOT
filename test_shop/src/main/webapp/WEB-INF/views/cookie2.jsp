<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
.popup{
border: 1px solid red;
width: 300px;
height: 300px;

position: absolute;
top : 50%;
left: 50%;
transform : translate(-50%, -50%); 
}
</style>

<body>
cookie 냠냠<br>
크롬 브라우저를 열고 네이버에 접속해서 로그인을 한다.<br>
그리고 새로운 탭을 열어서 네이버에 접속하면 로그인된 화면을 볼 수 있다. 
<div class= "popup">
공지 팝업<br>
<input type="checkbox" id="popup_1">1분동안 보이지 않기
</div>

<script>
function setCookie(){
	let now = new Date(); // 현재 시간을 가져오기
	let after_10s = now.getSeconds() + 10 // 현재 초에 10을 더한 값 계산
	now.setSeconds(after_10s) //  현재 시간을 계산된 초로 설정
	
	
	//cookie?
	document.cookie = "popup7=true;  path=/; expires=" + now.toGMTString();
	document.cookie = "popup1=true;  path=/; expires=" + now.toGMTString();
	console.log("쿠키 설정 완료")
}

// 쿠키에 추가
// 단 maxAge의 단위는 초
function setCustomCookie(key, value, maxAge){
	let now = new Date();
	let after = now.getSeconds() + maxAge // 현재 초에 maxAge를 더한 값 계산
	now.setSeconds(after)
	
	document.cookie = key +"=" + value +"; path=/; expires=" + new.toGMTString();
}

function getCookie(key){
	let value = null;
	let cookie = document.cookie;
	console.log(cookie)
	
	let cookies = cookie.split(";") //문자열을 세미콜론과 공백을 기준으로 분리하여 배열로 만드는 코드
	for(c of cookies){
		let kv = c.split("=") // c
		if(kv[0] == key){
			console.log("kv[0] : ", kv[0])
			console.log("kv[1] : ", kv[1])
			value = kv[1];
			break
		}
	}
}

</script>

</body>
</html>