$(document).ready(function(){
    var validator;
    validator = $("#form").validate({
        rules: {
            "user.dept": "required",
            "user.name": "required",
            "user.account": "required",
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
            "user.dept": "请输入部门",
            "user.name": "请输入名字",
            "user.account": "请输入账号",
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