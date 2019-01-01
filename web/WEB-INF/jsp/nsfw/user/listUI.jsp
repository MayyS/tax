<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>用户管理</title>
    <%@include file="/common/header.jsp"%>
    <script type="text/javascript" charset="utf-8" src="${basePath}js/function/user_fun.js">   
    </script>



    <script>
        function toUserRole(){
            var selectCheckboxes=$("input[name='selectedRows'][type='checkbox']:checked");
            if(selectCheckboxes==null||selectCheckboxes.length!=1){
                $.messager.alert("提示操作","请选中一行，再点击操作","warning");
                return ;
            }
            var id=selectCheckboxes[0].value;
            $('#form').prop("action","${basePath}user/userAction_toUserRole.action?user.id="+id);
            $('#form').submit();
        }
    </script>


</head>
<body class="rightBody">
<form name="form1" id="form" action="#" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div> </div>
                <div class="search_art">
                    <li>
                    <!--  
                    	用户名：
                        <input type="text" name="user.name" class="s_text" id="userName" style="width:160px;" /> -->
                    <select name="attr">
                    	<option value="user.name" selected="selected">用户名</option>
                    	<option value="user.account">账号</option>
                    </select>
                    <input type="text" name="value" class="s_text" id="userName" style="width:160px;" />
                    
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd('user')"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll('user')"/>&nbsp;
                        <input type="button" value="导出" class="s_button" onclick="doExportExcel('user')"/>&nbsp;
                        <input type="button" value="添加角色" class="s_button" onclick="toUserRole()"/>
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll('')" /></td>
                            <td width="140" align="center">用户名</td>
                            <td width="140" align="center">帐号</td>
                            <td width="160" align="center">所属部门</td>
                            <td width="80" align="center">性别</td>
                            <td align="center">电子邮箱</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                        <%-- <%for(User user : userList) %> --%>
                        <c:forEach items="${pageResult.items}" var="user">
	                        <tr bgcolor="f8f8f8">
	                            <td align="center"><input type="checkbox" name="selectedRows" value="${user.id}"/></td>
	                            <td align="center">${user.name }</td>
	                            <td align="center">${user.account}</td>
	                            <td align="center">${user.dept}</td>
	                            <td align="center">${user.gender?'男':'女'}</td>
	                            <td align="center">${user.email}</td>
	                            <td align="center">
	                                <a href="${basePath}user/userAction_editUI.action?user.id=${user.id}">编辑</a>
	                                <a href="${basePath}user/userAction_delete.action?user.id=${user.id}">删除</a>
	                            </td>
	                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

       		
			<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
       		
        </div>
    </div>
</form>

</body>
</html>