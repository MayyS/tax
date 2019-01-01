<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>权限管理</title>
</head>


<body class="rightBody">
<form id="form" name="form" action="${basePath}permission/permissionAction_edit.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="permission.id" value="${permission.id}"/>
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>权限管理</strong>&nbsp;-&nbsp;编辑权限</div></div>
    <div class="tableH2">编辑权限</div>
    

    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    
        <tr>
            <td class="tdBg" width="200px">权限名称：</td>
            <td><input type="text" name="permission.permissionName" value="${permission.permissionName}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">权限URL：</td>
            <td>
                <input type="text" name="permission.url" value="${permission.url}"><br/>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">父菜单ID：</td>
            <td>
                <input type="text" name="permission.pid" value="${permission.pid}"><br/>
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