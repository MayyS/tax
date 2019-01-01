<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>用户角色管理</title>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript" charset="utf-8" src="${basePath}js/function/user_fun.js">
    </script>



    <script>

    </script>


</head>
<body class="rightBody">
<form name="form1" id="form" action="${pageContext.request.contextPath }/user/userAction_saveUserRole.action" method="post">
    <!-- 隐藏域保存用户id -->
    <input type="hidden" name="user.id" value="${user.id }"/>

    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户添加角色</strong></div> </div>
                <div class="search_art">
                    <li>
                        角色名：
                        <input type="text" name="user.name" class="s_text" id="userName" style="width:160px;" />
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll()" /></td>
                            <td width="140" align="center">角色ID</td>
                            <td width="140" align="center">角色名称</td>
                            <td width="140" align="center">角色描述</td>
                        </tr>
                        <!-- 用户已经具有的角色id：${roleIds } -->
                        <c:forEach items="${allRoleList}" var="role">

                            <tr bgcolor="f8f8f8">
                                <td align="center">
                                    <input
                                            type="checkbox"
                                        ${fn:contains(roleIds, role.id)?'checked':''}
                                            name="selectedRows"
                                            value="${role.id}"
                                    />
                                </td>
                                <td align="center">${role.id }</td>
                                <td align="center">${role.roleName }</td>
                                <td align="center">${role.roleDesc }</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="tc mt20">
                    <input type="submit" class="btnB2" value="保存" />&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
                </div>

            </div>
        </div>
    </div>
</form>

</body>

</body>
</html>