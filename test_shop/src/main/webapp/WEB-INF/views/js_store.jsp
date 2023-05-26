<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        ul {
            padding: 0;
        }

        ul li {
            list-style: none;
            width: 200px;
            height: 326px;

            display: inline-block;
            vertical-align: top;

            box-shadow: 1px 1px 5px 1px gray;
            margin: 20px 10px;
            padding: 10px;

        }

        ul li>div:first-child {
            height: 240px;
        }

        ul li img.thumb {
            padding: 10px;
            width: calc(100% - 20px);
        }

        ul li div.name {
            cursor: pointer;
            text-decoration: underline;
        }

        ul li div.desc {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        ul li div.price {
            text-align: right;
            padding-right: 10px;
        }
    </style>

    <script>

        // 페이지 로딩이 끝나면
        window.addEventListener("load", function () {

            // 리스트 가져오기
            let list_item = getList();

            // 가져온 리스트로 html에 표시
            drawList(list_item);


            // 확인 버튼을
            let btn_check = document.querySelector("#check")
            // 클릭하면
            btn_check.addEventListener("click", function(){
                // checkbox에 check된 요소들의
                let list_checked = document.querySelectorAll("input[name=chk]:checked")
                // 값을 출력한다
                for(let item of list_checked){
                    let value = item.value;      // value값 가져오기
                    let isChecked = item.checked // check 여부(true/false)
                    console.log("value :", value, ", isChecked :", isChecked)
                }
            })

	ajax();
        })

        function getList() {
            // 제품의 정보(json)가 있는 배열을 만들고
            let list_item = [];

            let item_info = {
                img_src: "//image.msscdn.net/images/goods_img/20230401/3199783/3199783_16844763299344_320.jpg"
                , name: "보테가베네타"
                , desc: "여성 카세트 크로스백 - 패러킷"
                , price: "1,308,000"
            }
            list_item.push(item_info);

            item_info = {
                img_src: "//image.msscdn.net/images/goods_img/20230321/3166507/3166507_16844777100078_320.jpg"
                , name: "끌로에"
                , desc: "여성 스몰 우디 토트백"
                , price: "935,000"
            }
            list_item.push(item_info);

            item_info = {
                img_src: "//image.msscdn.net/images/goods_img/20230313/3142239/3142239_16786716133209_320.jpg"
                , name: "아크테릭스"
                , desc: "[SS23] 맨티스 2 웨이스트팩"
                , price: "100,000"
            }
            list_item.push(item_info);
            list_item.push(item_info);
            list_item.push(item_info);
            list_item.push(item_info);
            list_item.push(item_info);
            list_item.push(item_info);
            list_item.push(item_info);
            list_item.push(item_info);
            list_item.push(item_info);

            console.log(list_item)

            return list_item;
        }

        function drawList(list_item) {
            // id가 item인 ul에
            let ul = document.querySelector("#item");
            console.log("ul", ul)

            // li에 제품 정보를 넣고
            let html = "";

            if (list_item.length > 0) {

                for (let i = 0; i < list_item.length; i++) {
                    html += '<li>';
                    html += '    <div>';
                    html += '        <img class="thumb" src="' + list_item[i].img_src + '">';
                    html += '    </div>';
                    html += '    <div>';
                    html += '        <input type="checkbox" name="chk" value="name_' + i + '">';
                    html += '    </div>';
                    html += '    <div class="name" id="name_' + i + '" data-price="' + list_item[i].price + '">';
                    html += '        ' + list_item[i].name;
                    html += '    </div>';
                    html += '    <div class="desc" title="' + list_item[i].desc + '">';
                    html += '        ' + list_item[i].desc;
                    html += '    </div>';
                    html += '    <div class="price">';
                    html += '        <span>' + list_item[i].price + '</span>원';
                    html += '    </div>';
                    html += '</li>';

                }
            } else {
                html += '<li>상품이 없습니다</li>'
            }

            // 그 li를 ul 넣기
            ul.innerHTML = html;


            // 방법 1: id로 하나씩 지정
            for (let i = 0; i < list_item.length; i++) {
                document.querySelector("#name_" + i).addEventListener("click", function () {

                })
            }

            // 방법 2: 속성을 이용해서
            document.querySelectorAll("[id^=name_]")

            // 방법 3: 클릭된 요소를 기준으로 처리
            let list_name = document.querySelectorAll(".name");
            for (let prod_name of list_name) {
                prod_name.addEventListener("click", (event) => {
                    
                	// 클릭된 요소
                    let dom = event.target;

                    // 여행을 떠나는 방법; 나에서 부모로 갔다가 원하는 자식으로 감
                    // console.log(dom, dom.parentNode)
                    let li = dom.parentElement
                    let span = li.querySelector(".price span")
                    console.log(span.innerHTML)

                    // 내 속성에 있는 값을 바로 읽기
                    let price = dom.getAttribute("data-price")
                    console.log("내 속성", price)
                })
            }
        }


       function ajax(){
    	  // ajax실행 버튼을 클릭하면
    	  let btn_ajax = document.querySelector("#ajax")
    	  
    	  btn_ajax.addEventListener("click", function(){
    	  // ajax를 이용해서 java로 값을 보내고
    	  
    	   // ajax 객체 생성
            const xhr = new XMLHttpRequest(); //final
            
            // 보낼 준비
            let count = 10;
            let type ="bag";
            let qs = "?"
            	qs += "count=" + count; 
            	qs  += "&type=" +type;
            	qs  += "&order=desc";
           
            let jsonData = {
            		"count" : count,
            		"type" : type,
            		"order" : "desc"
            }	
            
            let url = "/send2"
            	
            //get 방식으로 전송
           // xhr.open("GET", url);
           xhr.open("POST", url);
           
           
           // "status":415,"error":"Unsupported Media Type" 에러 발생
           // 디폴트 값이 text/plain 설정되어 있어서
           // 내가 보내는 데이터가 json 임을 알리는 설정
           xhr.setRequestHeader("Content-Type", "application/json")
           
           
            // 실행을 지시. 단! 언제 끝날지 모름
            xhr.send(JSON.stringify(jsonData));

            // 다녀오는게 끝났을때(응답 이후)
            xhr.onload = function(){
				console.log(xhr.responseText)
				
			try{	
				// JSON.parse :json 형식으로 변환
				let list_data = JSON.parse(xhr.responseText)
				console.log(list_data)
				
				// 받은 list를 화면에 표시
				drawList(list_data);
				
				}catch(e){
					console.log("ERROR", e)
				}
				
 
            }
                // 받은 list를 화면에 표시
    		  
    	  })
    	  
       }	
        
    </script>
</head>

<body>
    <header>
        <h1>쇼핑몰</h1>
    </header>

    <section>
        <div>
            <input type="button" value="확인" id="check">
        </div>
        
        <div>
            <input type="button" value="ajax사용" id="ajax">
        </div>
        
        <ul id="item">
            <li>상품이 없습니다.</li>
        </ul>
    </section>

    <footer>휴먼쇼핑몰</footer>
</body>




</html>