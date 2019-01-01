<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>角色权限管理</title>
    <%@include file="/common/header.jsp"%>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/zTree_v3/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>

    <script type="text/javascript">
        var setting = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        var treeObj;
        $(document).ready(function(){
            var roleId = $("#roleId").val();

            $.ajax({
                url:"${pageContext.request.contextPath}/role/roleAction_getRolePermissionJson.action",
                type:"post",
                data:{"role.id":roleId},
                dataType:"json",
                success:function(jsonData){
                    treeObj= $.fn.zTree.init($("#treeDemo"), setting, jsonData);
                }
            })
        });

        function getSelectedNodes() {
            var nodes=treeObj.getCheckedNodes(true);
            var permissionIds="";
            for (var i=0; i<nodes.length; i++){
                permissionIds+=nodes[i].id+",";
            }
            permissionIds=permissionIds.substring(0,permissionIds.length-1);
            $('#permissionIds').val(permissionIds);
            document.forms[0].submit();
        }

    </script>
</head>
<body class="rightBody">
<form name="form1" id="form1" action="${pageContext.request.contextPath }/role/roleAction_saveUserRole.action" method="post">
    <!-- 隐藏域保存用户id -->
    <input type="hidden" name="role.id" id="roleId" value="${role.id}"/>
    <input type="hidden" name="permissionIds" id="permissionIds"/>

    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>角色添加权限</strong></div> </div>
                <div class="t_list" style="margin:0px; border:0px none;">
                    <!-- 显示ztree的区域 -->
                    <ul id="treeDemo" class="ztree"></ul>
                </div>

            </div>
            <div class="tc mt20">
                <input type="button" class="btnB2" value="保存" onclick="getSelectedNodes()" />
                &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
            </div>

        </div>
    </div>
</form>

</body>
</html>
