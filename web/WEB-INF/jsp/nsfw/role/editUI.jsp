<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>角色管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}role/roleAction_edit.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="role.id" value="${role.id}"/>
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>角色管理</strong>&nbsp;-&nbsp;编辑角色</div></div>
    <div class="tableH2">编辑角色</div>
    
    
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    
        <tr>
            <td class="tdBg" width="200px">角色名称：</td>
            <td><input type="text" name="role.roleName" value="${role.roleName}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">角色描述：</td>
            <td>
                <input name="role.roleDesc" value="${role.roleDesc}">
            </td>
        </tr>
        <%--
        <tr>
            <td class="tdBg" width="200px">角色权限：</td>
            <td>
            	<input name="roots" type="checkbox" value="0"  ${fn:contains(role.permissions, '角色管理') ?'checked="checked"':''}/>角色管理<br>
            	<input name="roots" type="checkbox" value="1"  ${fn:contains(role.permissions, '用户管理') ?'checked="checked"':''}/>用户管理<br>
            	<input name="roots" type="checkbox" value="2"  ${fn:contains(role.permissions, '信息管理') ?'checked="checked"':''}/>信息管理<br>
            	<input name="roots" type="checkbox" value="3"  ${fn:contains(role.permissions, '咨询管理') ?'checked="checked"':''}/>咨询管理<br>
            	<input name="roots" type="checkbox" value="4"  ${fn:contains(role.permissions, '投诉管理') ?'checked="checked"':''}/>投诉管理<br>
            	<input name="roots" type="checkbox" value="5"  ${fn:contains(role.permissions, '调查管理') ?'checked="checked"':''}/>调查管理<br>
            	<input name="roots" type="checkbox" value="6"  ${fn:contains(role.permissions, '告知管理') ?'checked="checked"':''}/>告知管理<br>
            	<input name="roots" type="checkbox" value="7"  ${fn:contains(role.permissions, '预约管理') ?'checked="checked"':''}/>预约管理<br>
            </td>
        </tr>

        <tr>
            <td class="tdBg" width="200px">状态：</td>
            <td>
            	<input type="radio" name="role.state" value="1" ${role.state==1?'checked="checked"':'' } />有效
            	<input type="radio" name="role.state" value="0" ${role.state==0?'checked="checked"':'' } />无效
            </td>
        </tr>--%>


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