<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>

    <title>权限管理</title>

    <script type="text/javascript">
        $(function(){
            // 初始化datagrid组件
            $('#dg').datagrid({
                url:'${pageContext.request.contextPath}/permission/permissionAction_listUI_result.action',
                columns:[[
                    {field:'id_', title:'',checkbox:true},
                    {field:'id',title:'权限编号',width:100},
                    {field:'permissionName',title:'权限名称',width:100},
                    {field:'url',title:'权限url',width:100},
                    {field:'pid',title:'父菜单',width:100}
                ]],
                toolbar: [{
                    iconCls: 'icon-add',
                    text:"添加",
                    handler: function(){
                        $("#form").prop("action","${pageContext.request.contextPath}/permission/permissionAction_addUI.action");
                        $("#form").submit();
                    }
                },{
                    iconCls: 'icon-edit',
                    text: "编辑",
                    handler: function(){
                        var selRow=$('#dg').datagrid('getSelected');
                        if(selRow==null){
                           $.messager.alert("温馨提示","请选择需要修改的权限","warning");
                           return false;
                        }
                        var id=selRow.id;
                        $('#objId').val(id);
                        $('#form').prop("action","${pageContext.request.contextPath}/permission/permissionAction_editUI.action");
                        $('#form').submit();
                    }
                },'-',{
                    iconCls: 'icon-remove',
                    text:"删除",
                    handler: function(){
                        var selRow=$('#dg').datagrid('getSelected');
                        if (selRow==null){
                            $.messager.alert("温馨提示","请选择要删除的权限","warning");
                            return false;
                        }
                        var id=selRow.id;

                        $.ajax({
                            url:"${pageContext.request.contextPath}/permission/permissionAction_deleteByAjax.action",
                            type:"post",
                            data:{
                                'permission.id':id
                            },
                            dataType:"json",
                            success:function(data){
                                if(data.success==true){
                                    $.messager.alert("温馨提示","删除成功","info");
                                    $('#dg').datagrid('load');
                                }
                            },
                            error:function(data){

                            }

                        })
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
                <div class="c_crumbs"><div><b></b><strong>权限管理 </strong></div> </div>
                <div class="search_art">
                    <li>
                        权限名称：<input type="text" name="permission.permissionName" class="s_text" id="roleName"  style="width:160px; " value="${permission.permissionName}"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd('role')"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll('role')"/>&nbsp;
                    </li>
                </div>

                <div id="dg" class="t_list" style="margin:0px; border:0px none;"></div>
                <input type="hidden" name="permission.id" id="objId">
                </div>

			</div>
    </div>
</form>

</body>
</html>