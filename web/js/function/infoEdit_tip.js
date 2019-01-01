$(document).ready(function(){
    		var validator=$("#form").validate({

    			rules:{
    				"info.source":"required",
    				"user.name":"required",
    				"info.content":{
    					required: true,
						rangelength:[30,200]

					},
    				"info.title":"required"
    			},
    			messages:{
    				"info.source":"来源不能为空",
    				"info.content":{
    					required:"内容不能为空白",
						rangelength:"输入不少于30个字不多余200个字的内容"
					},
    				"info.title":"请填写标题"
    			},
    			success: function (label) {
    	            label.html("&nbsp&nbsp&nbsp&nbsp").addClass("checked");
    	        }
    		});

    	});