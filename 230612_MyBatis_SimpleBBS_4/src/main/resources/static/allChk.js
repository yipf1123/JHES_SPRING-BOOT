const allChk = document.getElementById("all_chk");
const chkSer = document.getElementById("chk_ser");
const chkDel = document.getElementById("chk_del");

var allCheck = false;
allChk.addEventListener("click", function() {
      var chkes = document.getElementsByName("chk");
		allCheck = !allCheck;
      for (var i = 0; i < chkes.length; i++) {
        chkes[i].checked = allCheck;
}
});

chkDel.addEventListener("click",function(event){
 event.preventDefault();
 document.getElementById("myForm").action = "/chkDelete";
 document.getElementById("myForm").submit();
});