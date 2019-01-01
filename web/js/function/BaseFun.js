var basePath="http://localhost:8080/gdpu-tax/";
//跳转新增页面
      function doAdd(event){
    	$("#form").prop("action", basePath+event+"/"+event+"Action_addUI.action");
    	$("#form").submit();
    }
      //批量删除
      function doDeleteAll(event){
    	  var length=$("input[name=selectedRows]:checked").length;
    	  if(length<=0){
    		  alert("请选择要删除的数据");
    		  return ;
    	  }
    	  $("#form").prop("action",basePath+event+"/"+event+"Action_deleteSelected.action");
    	  $("#form").submit();
      }
      
      //实现全选与反选
      function doSelectAll(event){
    	  $("input[name=selectedRows]").prop("checked", $("#selAll").is(":checked"));
      }
//
//      function doSearch(event){
//    	  val=$(".s_text").val();
//    	  if(val.length==0){
//    		  alert("不能为空");
//    		  return;
//    	  }
//    	  $("#form").prop("action",basePath+event+"/"+event+"Action_search.action");
//    	  $("#form").submit();
//      }
//      