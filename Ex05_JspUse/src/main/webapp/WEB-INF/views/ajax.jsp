<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
    <input type="button" id="btn1" value="js-ajax ����">
    <div id="result" style="border: 1px solid red;">�������</div>
    <script>
        // ���� : https://poiemaweb.com/js-ajax#3-xmlhttprequest

        let btn1 = document.querySelector("#btn1");
        btn1.addEventListener("click", function(){
            
            // ajax ��ü ����
            const xhr = new XMLHttpRequest();
            
            // ���� �غ�
            let url = "http://localhost:8080/test1";
            xhr.open("GET", url);
            
            // ������ ����. ��! ���� ������ ��
            xhr.send();

            // �ٳ���°� ��������(���� ����)
            xhr.onload = function(){
                console.log(xhr.responseText);

                let result = document.querySelector("#result");
                result.innerText = xhr.responseText
                // result.innerHTML = xhr.responseText
            }
        })
    </script>
</body>
</html>