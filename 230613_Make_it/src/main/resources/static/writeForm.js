const day = document.getElementById("dayform");

day.addEventListener("change", function(){
	day.submit();
})

day.addEventListener("submit", function(event) {
    event.preventDefault();
 })