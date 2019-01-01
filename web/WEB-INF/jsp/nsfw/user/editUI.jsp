<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>用户管理</title>
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${basePath}js/function/userEdit_tip.js"></script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}user/userAction_edit.action" method="post" enctype="multipart/form-data">
	<!-- 设置隐藏标签，传递id到后台，以便后台根据id执行update语句
	update user set name='' , dept='' where id=; -->
	<input type="hidden" name="user.id" value="${user.id}"/>
	
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>用户管理</strong>&nbsp;-&nbsp;编辑用户</div></div>
    <div class="tableH2">编辑用户</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">所属部门：</td>
            <td><input type="text" name="user.dept" value="${user.dept}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">用户名：</td>
            <td><input type="text" name="user.name" value="${user.name}"/> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">帐号：</td>
            <td><input type="text" name="user.account" value="${user.account}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">密码：</td>
            <td><input type="text" name="user.password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">性别：</td>
            <td>
            	<input type="radio" name="user.gender" ${user.gender?'checked="checked"':'' } value="true"/>男
            	<input type="radio" name="user.gender" ${user.gender?'':'checked="checked"' } value="false"/>女
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">电子邮箱：</td>
            <td><input type="text" name="user.email" value="${user.email}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">手机号：</td>
            <td><input type="text" name="user.mobile" value="${user.mobile}"/></td>
        </tr>        
        <tr>
            <td class="tdBg" width="200px">生日：</td>
            <td>
            	<input type="text" id="birthday" name="user.birthday"
            			readonly="readonly" onfocus="WdatePicker({skin:'whyGreen',el:'birthday',dateFmt:'yyyy-MM-dd'})"
            	 		value='<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>' >
            </td>
        </tr>
		<tr>
            <td class="tdBg" width="200px">状态：</td>
            <td>
            	<input type="radio" name="user.state" ${user.state==1?'checked="checked"':'' } value="1"/>有效
            	<input type="radio" name="user.state" ${user.state==0?'checked="checked"':'' } value="0"/>无效
            </td>
        </tr>
    </table>
    
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>