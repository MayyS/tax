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
    
    
    <title>权限管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}permission/permissionAction_add.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>权限管理</strong>&nbsp;-&nbsp;新增权限</div></div>
    <div class="tableH2">新增权限</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <input type="hidden" name="permission.id" value="${permission.id}"/>
        <tr>
            <td class="tdBg" width="200px">权限名称：</td>
            <td>
            	<input type="text" name="permission.permissionName" />
            	<label id="permission.permissionName-error" class="error" for="permission.permissionName"></label>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">权限URL：</td>
            <td>
                <input type="text" name="permission.url"><br/>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">父菜单ID：</td>
            <td>
                <input type="text" name="permission.pid"><br/>
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