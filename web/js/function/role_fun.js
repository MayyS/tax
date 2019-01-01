var basePath="http://localhost:8080/gdpu-tax/";	
function findByPage(pageNo){
 		$("#form").prop("action",basePath+"role/roleAction_listUI.action?pageNo="+pageNo);
 		$("#form").submit();
}