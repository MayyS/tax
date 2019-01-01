<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>纳税咨询管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="#" method="post" enctype="multipart/form-data">
	<input type="hidden" name="consult.id" value="${consult.id}"/>
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>纳税咨询管理</strong>&nbsp;-&nbsp;纳税咨询</div></div>
    <div class="tableH2">咨询详细信息<span style="color:red;">(未处理)</span></div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	<tr><td colspan="2" align="center">咨询人信息</td></tr>              
        <tr>
            <td class="tdBg">咨询人单位：</td>
            <td>${consult.consulterDept }</td>
        </tr>
        <tr>
            <td class="tdBg">咨询人姓名：</td>
            <td>${consult.consulter }</td>
        </tr>
        <tr>
            <td class="tdBg">咨询人手机：</td>
            <td>
            ${consult.consulterMobile }
            </td>
        </tr>
        <tr><td colspan="2" align="center">咨询信息</td></tr>
        <tr>
            <td class="tdBg">咨询时间：</td>
            <td>${consult.consultTime }</td>
        </tr>      
        <tr>
            <td class="tdBg">咨询标题：</td>
            <td>${consult.title }</td>
        </tr>
        <tr>
            <td class="tdBg">咨询内容：</td>
            <td>${consult.content }</td>
        </tr>
        <tr><td colspan="2" align="center">处理信息</td></tr>
        <!-- 已回复过；则只能查看回复信息 -->
        <tr>
            <td class="tdBg">回复部门：</td>
            <td>
            ${consult.replyDept }
            </td>
        </tr>
        <tr>
            <td class="tdBg">回复人：</td>
            <td>
            ${consult.replyer }
            </td>
        </tr>
        <tr>
            <td class="tdBg">回复时间：</td>
            <td>
            ${consult.replyTime }
            </td>
        </tr>

		<tr>
            <td class="tdBg" width="200px">回复内容：</td>
            <td> <textarea rows="8" cols="100" name="consult.replyContent"></textarea> </td>
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