<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/assets/js/code.jquery.com_jquery-3.7.0.js"></script>

<script>
   $(()=>{
      $('#dup').off("click").on("click", ()=>{
         let id = $('input[name=id]').val()
         
         let param = {
            "id" : id,
    
         }
         
         // ajax 실행
           let option = {
               "url" : "/api/todo",
               "type": "post",
               "data": JSON.stringify(param),
               "contentType": "application/json",
               "success" : function(data){
                  console.log("data", data)
                  if(data != 0){
                	  $("#msg").html("계정을 확인해 주세요")
                  }else{
                	  $("#msg").html("")
                  }
               },
               "error" : function(data){
                   console.error("ERROR", data)
               }
           }
           $.ajax(option);
         
      })
   })
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/join" method="post">
		id : <input type="text" name="id"><input type="button"
			id="dup" value="중복확인"> <br> pw : <input type="password"
			name="pw"><br> 이름 : <input type="text" name="name"><br>
		<div id="msg">${msg}</div><br> <input type="submit" value="회원가입">
	</form>
</body>
</html>