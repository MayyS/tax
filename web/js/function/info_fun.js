
var basePath="http://localhost:8080/gdpu-tax/";	
	function changeState(infoId, state){
		//异步发送请求到后台修改状态
		$.ajax({
			url:basePath+"info/infoAction_changeState.action",		//发送请求的地址
			data:{"info.id":infoId,"info.state":state},	//要发送的数据
			type:"POST",	//发送的方式
			success:function(){
				if(state==1){
					$("#state_"+infoId).html("发布");
					$("#oper_"+infoId).html('<a href="javascript:changeState('+infoId+',0)">停用</a>');
				}else{
					$("#state_"+infoId).html("停用");
					$("#oper_"+infoId).html('<a href="javascript:changeState('+infoId+',1)">发布</a>');
				}
			},
			error:function(){
				alert("状态更新失败！");
			}
			
		});
	}
	  function findByPage(pageNo){
	 		$("#form").prop("action",basePath+"info/infoAction_listUI.action?pageNo="+pageNo);
	 		$("#form").submit();
	  }	