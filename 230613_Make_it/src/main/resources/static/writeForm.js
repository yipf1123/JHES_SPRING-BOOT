const day = document.getElementById("dayform");


day.addEventListener("change", function(){
	day.submit();
})

day.addEventListener("submit", function(event) {
    event.preventDefault();
 })
 
 
 function editToDo(do_id,day) {
  const todoElement = document.getElementById(`todo-${do_id}`);
  const todoText = todoElement.innerText;

  // 입력 필드 생성
  const inputElement = document.createElement('input');
  inputElement.value = todoText;

  // 수정 버튼 생성
  const updateButton = document.createElement('button');
  updateButton.innerText = '수정';
 

  
 updateButton.addEventListener('click', function() {
    
   const updatedTodo = inputElement.value;
 
  console.log("updatedTodo : " , updatedTodo);
  console.log("do_id : " , do_id);
  console.log("day : ", day)
/*  update(updatedTodo, do_id);*/
  

    
  });

  // span 요소를 입력 필드와 수정 버튼으로 대체
  todoElement.replaceWith(inputElement, updateButton);

  // 입력 필드에 포커스 설정
  inputElement.focus();
  

}

function update(updatedTodo, do_id) {
  window.location.href = "/update";
}
