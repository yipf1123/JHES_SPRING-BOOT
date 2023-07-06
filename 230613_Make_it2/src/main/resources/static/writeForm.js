const dayform = document.getElementById("dayform");


dayform.addEventListener("change", function(){
	dayform.submit();
})

dayform.addEventListener("submit", function(event) {
    event.preventDefault();
 })
 
 
let todo = document.querySelectorAll(".todo");
let todo_text = document.querySelectorAll(".todo_text");
let upd_bt = document.querySelectorAll(".upd_bt");
let do_id =document.querySelectorAll(".do_id");
let date = document.querySelector("#day");

for(let i=0; i<todo.length; i++){	
todo[i].addEventListener("click",function(){
	
	todo[i].style.display = "none";
	todo_text[i].style.display = "block";
	upd_bt[i].style.display = "block";	
})}

for(let i=0; i<upd_bt.length; i++){	
upd_bt[i].addEventListener("click",function(){
	
	let do_Id = do_id[i].value;
	let content = todo_text[i].value;
	let day = date.value;
	console.log("do_Id : ", do_Id .value);
	console.log("content : ", todo_text.value);
	console.log("day : ", day.value);
	
	update(do_Id, content, day );
	

})}



function update(a,b,c) {
  window.location.href = "/update?do_id="+a+"&toDo="+b+"&day="+c;
}
