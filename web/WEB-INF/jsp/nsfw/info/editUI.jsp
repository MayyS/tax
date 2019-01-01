<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
    <!-- 引入富文本编辑器的相关文件 -->
     <!-- 参数配置文件 -->
     <script type="text/javascript" chartset="utf-8" src="${basePath}js/ueditor/ueditor.config.js"></script>
     <script type="text/javascript" chartset="utf-8" src="${basePath}js/ueditor/ueditor.all.min.js"></script>
     <script type="text/javascript" chartset="utf-8" src="${basePath}js/ueditor/lang/zh-cn/zh-cn.js"></script>
     <script type="text/javascript" src="${basePath}js/function/infoEdit_tip.js"></script>
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
    <script>
    <!-- 实例化编辑器 -->
    var ue=UE.getEditor('editor');
	
    </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath}info/infoAction_edit.action" method="post" enctype="multipart/form-data">
	<input type="hidden" name="info.id" value="${info.id}"/>
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong>&nbsp;-&nbsp;修改信息</div></div>
    <div class="tableH2">修改信息</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">信息分类：</td>
            <td>
            	<select name="info.type">
            		<option value="通知公告" ${info.type=="通知公告" ?'selected="selected"':''}>通知公告</option>
            		<option value="政策速递" ${info.type=="政策速递" ?'selected="selected"':''}>政策速递</option>
            		<option value="纳税指导" ${info.type=="通知公告" ?'selected="selected"':''}>纳税指导</option>
            	</select>
            </td>
            <td class="tdBg" width="200px">来源：</td>
            <td><input type="text" name="info.source" value="${info.source}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息标题：</td>
            <td colspan="3"><input type="text" name="info.title" style="width:90%" value="${info.title}"/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息内容：</td>
            <td colspan="3">
            	<textarea id="editor" name="info.content" style="width:90%;height:160px;" >${info.content}</textarea>
            	<label id="info.content-error" class="error" for="info.content"></label>
            </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">创建人：</td>
            <td>
            	<input name="info.creator" type="text" readonly="readonly" value="${info.creator}"> 
            </td>
            <td class="tdBg" width="200px">创建时间：</td>
            <td>
            	<input type="text" name="info.createTime" value='<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd" />' readonly="readonly">

            </td>
        </tr>
    </table>
  <%--   <s:hidden name="info.id"/>
    <s:hidden name="info.state"/> --%>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>