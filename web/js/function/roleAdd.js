$(document).ready(function(){
    		var validator=$("#form").validate({
    			rules:{
    				"role.name":"required",
//    				"role.right":"required",
    				"role.state":"required"
    			},
    			messages:{
    				"role.name":"请输入角色的名字",
//    				"role.right":"",
    				"role.state":"请选择状态"
    			},
    			success: function (label) {
    	            label.html("&nbsp&nbsp&nbsp&nbsp").addClass("checked");
    	        }
    		});

    	});