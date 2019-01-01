var basePath="http://localhost:8080/gdpu-tax/";
      //批量导出
  function doExportExcel(){
	  $("#form").prop("action",basePath+"user/userAction_exportExcel.action");
	  $("#form").submit();
  }
  
  function findByPage(pageNo){
	  if(pageNo)
 		$("#form").prop("action",basePath+"user/userAction_listUI.action?pageNo="+pageNo);
 		$("#form").submit();
  }