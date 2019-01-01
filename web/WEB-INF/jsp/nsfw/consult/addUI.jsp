<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<%@include file="/common/header.jsp"%>
    <title>纳税咨询管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="#" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>纳税咨询管理</strong>&nbsp;-&nbsp;新增咨询</div></div>
    <div class="tableH2">新增咨询</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">咨询标题：</td>
            <td><s:textfield name="consult.title"/> </td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">咨询内容：</td>
            <td><s:textarea id="editor" name="consult.content" rows="8" cols="80"></s:textarea> </td>
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