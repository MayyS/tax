<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    
    <script type="text/javascript" src="${basePath}js/function/roleAdd.js"></script>
     
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
    </style>
    
    
    <title>角色管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}role/roleAction_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;新增角色</div></div>
    <div class="tableH2">新增角色</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">角色名称：</td>
            <td>
            	<input type="text" name="role.roleName" />
            	<label id="role.roleName-error" class="error" for="role.roleName"></label>
            </td>
        </tr>
        <%--
        <tr>
            <td class="tdBg" width="200px">角色权限：</td>
            <td>
            	<input name="roots" type="checkbox" value="0"/>角色管理<br>
            	<input name="roots" type="checkbox" value="1"/>用户管理<br>
            	<input name="roots" type="checkbox" value="2"/>信息管理<br>
            	<input name="roots" type="checkbox" value="3"/>咨询管理<br>
            	<input name="roots" type="checkbox" value="4"/>投诉管理<br>
            	<input name="roots" type="checkbox" value="5"/>调查管理<br>
            	<input name="roots" type="checkbox" value="6"/>告知管理<br>
            	<input name="roots" type="checkbox" value="7"/>预约管理<br>
            </td>
        </tr>

        <tr>
            <td class="tdBg" width="200px">状态：</td>
             <td>
            	<input type="radio" name="role.state" value="1"/>有效
            	<input type="radio" name="role.state" value="0"/>无效

            	<label id="role.state-error" class="error" for="role.state"></label>
            	
            </td>
        </tr>--%>
        <tr>
            <td class="tdBg" width="200px">角色描述：</td>
            <td>
                <input type="text" name="role.roleDesc"><br/>
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