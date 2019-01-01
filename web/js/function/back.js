$(document).ready(function(){
	var basePath="http://localhost:8080/gdpu-tax/";
    var validator;
    validator = $("#form").validate({
        rules: {
            "user.dept": "required",
            "user.name": "required",
            "user.account": {
            	required:true,
            	remote:{
            		url:basePath+"user/userAction_accountChecked.action",
            		type:"post",
            		data:{
            			"user.account":function(){
            				return $("#user.account").val();
            			}
            		}
            		
            	}
            },
            "user.password": {
                required: true,
                rangelength: [6, 20]
            },
            "user.gender": "required",
            "user.email": {
                required: true,
                email: true
            },
            "user.state": "required"
        },
        messages: {
            "user.dept": "test",
            "user.name": "请输入名字",
            "user.account":{ 
            	required:"请输入账号",
            	remote:"账号已经存在！"
            },
            "user.password": {
                required: "请输入密码",
                rangelength: "密码长度为6-20"
            },
            "user.gender": "请选择性别",
            "user.email": {
                required: "请输入邮箱",
                email: "请规范输入邮箱"
            },
            "user.state": "请选择状态"
        },
        success: function (label) {
            label.html("&nbsp&nbsp&nbsp&nbsp").addClass("checked");
        }
    });
});