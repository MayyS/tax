<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
<%--

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>
--%>

    <title>角色管理</title>

    <%-- 第一次
    <script type="text/javascript">
  //实现搜索功能
 	function doSearch(){
 		$("#form").prop("action","${basePath}role/roleAction_listUI.action");
 		$("#form").submit();
 	}
    </script>
    <script type="text/javascript" charset="utf-8" src="${basePath}js/function/role_fun.js"></script>
    --%>

    <script type="text/javascript">
        $(function(){
            // 初始化datagrid组件
            $('#dg').datagrid({
                url:'${pageContext.request.contextPath}/role/roleAction_listUI_result.action',
                columns:[[
                    {field:'id_', title:'',checkbox:true},
                    {field:'id',title:'角色编号',width:100},
                    {field:'roleName',title:'角色名称',width:100},
                    {field:'roleDesc',title:'角色描述',width:100}
                ]],
                toolbar: [{
                    iconCls: 'icon-add',
                    text:"添加",
                    handler: function(){
                        $("#form").prop("action","${pageContext.request.contextPath}/role/roleAction_addUI.action");
                        $("#form").submit();
                    }
                },{
                    iconCls: 'icon-edit',
                    text: "编辑",
                    handler: function(){
                        var selRow=$('#dg').datagrid('getSelected');
                        if(selRow==null){
                           $.messager.alert("温馨提示","请选择需要修改的角色","warning");
                           return false;
                        }
                        var id=selRow.id;
                        alert(id);
                        $('#roleId').val(id);
                        $('#form').prop("action","${pageContext.request.contextPath}/role/roleAction_editUI.action");
                        $('#form').submit();
                    }
                },'-',{
                    iconCls: 'icon-remove',
                    text:"删除",
                    handler: function(){
                        var selRow=$('#dg').datagrid('getSelected');
                        if (selRow==null){
                            $.messager.alert("温馨提示","请选择要删除的角色","warning");
                            return false;
                        }
                        var id=selRow.id;

                        $.ajax({
                            url:"${pageContext.request.contextPath}/role/roleAction_deleteByAjax.action",
                            type:"post",
                            data:{
                                'role.id':id
                            },
                            dataType:"json",
                            success:function(data){
                                $.messager.alert("tips",data.message,"info");
                                $('#dg').datagrid('load');
                            },
                            error:function(data){

                            }

                        })
                    }
                },{
                    iconCls:'icon-add',
                    text:'添加标题',
                    handler:function () {
                        var selRow=$('#dg').datagrid('getSelected');
                        if(selRow==null){
                            $.messager.alert("tips","please checked","warning");
                            return false;
                        }
                        var id=selRow.id;
                        var url='${pageContext.request.contextPath}/role/roleAction_rolePermission.action?role.id='+id;
                        location.href=url

                    }
                }],
                pagination:true,
                pageList:[2,3,4,5,6],
                pageSize:2,
                fitColumns:true
            });
        })


    </script>


</head>
<body class="rightBody">
<form name="form1" id="form" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>角色管理 </strong></div> </div>
                <div class="search_art">
                    <li>
                        角色名称：<input type="text" name="role.roleName" class="s_text" id="roleName"  style="width:160px; " value="${role.name}"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd('role')"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll('role')"/>&nbsp;
                    </li>
                </div>

                <%--  第一次实训
                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll('role')" /></td>
                            <td width="120" align="center">角色名称</td>
                            <td align="center">权限</td>
                            <td width="80" align="center">状态</td>
                            <td width="120" align="center">操作</td>
                        </tr>
                       	<c:forEach items="${pageResult.items}" var="role">
                            <tr  bgcolor="f8f8f8"  >
                                <td align="center"><input type="checkbox" name="selectedRows" value="${role.id}"/></td>
                                <td align="center">${role.name}</td>
                                <td align="center">${role.permissions}</td>
                                <td align="center">${role.state=='1' ?'有效':'无效'}</td>
                                <td align="center">
                                    <a href="${basePath}role/roleAction_editUI.action?role.id=${role.id}">编辑</a>
                                    <a href="${basePath}role/roleAction_delete.action?role.id=${role.id}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                --%>

                <div id="dg" class="t_list" style="margin:0px; border:0px none;"></div>
                <input type="hidden" name="role.id" id="roleId">
                </div>


				<!-- <div class="c_pate" style="margin-top: 5px;">
					<table width="100%" class="pageDown" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="right">总共1条记录，当前第 1 页，共 1 页 &nbsp;&nbsp; <a
								href="#">上一页</a>&nbsp;&nbsp;<a href="#">下一页</a> 到&nbsp;<input
								type="text" style="width: 30px;"
								onkeypress="if(event.keyCode == 13){doGoPage(this.value);}"
								min="1" max="" value="1" /> &nbsp;&nbsp;
							</td>
						</tr>
					</table>
				</div> -->
				<%--<jsp:include page="/common/pageNavigator.jsp"></jsp:include>--%>
			</div>
    </div>
</form>

</body>
</html>