<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
     <script type="text/javascript" src="${basePath}js/function/userSign.js"></script>
     
    <%--  <script type="text/javascript" src="${basePath}js/function/back.js"></script>
     --%> 
     <style>
    	.error{
    		/* background:url("${basePath}images/myown/unchecked.gif") no-repeat 0px 0px; */
			color:red;
		/* 	padding-left: 16px;
		    padding-bottom: 2px;
		    font-weight: bold; */
		}
		.checked{
			background:url("${basePath}images/myown/checked.gif") no-repeat 0px 0px;
			color:green;
		}
    </style><link rel="stylesheet" href="${basePath}css/milk.css">
    <title>用户管理</title>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
</head>

<body class="rightBody">
<form id="form" name="form" action="${basePath}user/userAction_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;新增用户</div></div>
    <div class="tableH2">新增用户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">所属部门：</td>
            <td>
            	<input type="text" name="user.dept"/>
            	<!-- <span id="tip_user.dept"><font color='green'>*请输入所属部门</font></span>	 -->
            	<label id="user.dept-error" class="error" for="user.dept" ></label>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td>
            	<input type="text" name="user.name"/>
            	<label id="user.name-error" class="error" for="user.name"></label>
            	<!-- <span id="tip_user.name"><font color='green'>*请输入用户名</font></span>	 -->
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td>
            	<input type="text" id="user.account" name="user.account" />
            	<label id="user.account-error" class="error" for="user.account"></label>
            <!-- 	<span id="tip_user.accout"><font color='green'>*请输入账号</font></span> -->
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td>
            	<input type="text" name="user.password" />
            	<label id="user.password-error" class="error" for="user.password" ></label>
            <!-- 	<span id="tip_user.password"><font color='green'>*请输入密码</font></span> -->
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td>
				&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="user.gender" value="true"/>男&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="user.gender" value="false"/>女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<!-- <span id="tip_user.gender">&nbsp;<font color='green'>*请选择性别</font></span>     --> 
            	&nbsp;&nbsp;&nbsp;&nbsp;<label id="user.gender-error" class="error" for="user.gender"></label>       
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">电子邮箱：</td>
            <td>
            	<input type="text" name="user.email"/>
            	<label id="user.email-error" class="error" for="user.email"></label>
            <!-- 	<span id="tip_user.email"><font color='green'>*请输入电子邮箱</font></span> -->
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td>
            	<input type="text" name="user.mobile"/>
            	<label id="user.mobile-error" class="error" for="user.mobile"></label>
            	<!-- <span id="tip_user.mobile"><font color='green'>*请输入手机号码</font></span>
            --> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">生日：</td>
            <!-- {key:value} json格式  -->
            <td><input type="text" id="birthday" name="user.birthday" 
            		 readonly="readonly" 
            		 onfocus="WdatePicker({skin:'whyGreen',el:'birthday',dateFmt:'yyyy-MM-dd'})"/>
            	<!-- <span id="tip_uer.birthday"><font color='green'>*选择出生日期</font></span>	 
           	 --></td>
           	 
        </tr>
		<tr>
            <td class="tdBg" width="200px">状态：</td>
            <td> 
            	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="user.state" value="1"/>有效&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="user.state" value="0"/>无效&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	<label id="user.state-error" class="error" for="user.state" ></label>
           <!--  	<span id="tip_user.state"><font color='green'>&nbsp;&nbsp;*选择状态</font></span>
            --> </td>
       </tr>
    </table>
    
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>