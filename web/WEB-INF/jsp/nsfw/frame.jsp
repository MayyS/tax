<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>国税协同办公平台-纳税服务</title>
    <%@include file="/common/header.jsp"%>
    <base href="${basePath}">
    <link href="${basePath}css/nsfw/css.css" rel="stylesheet" type="text/css" />
    <link href="${basePath}css/nsfw/style.css" rel="stylesheet" type="text/css" />
</head>

<frameset cols="*,1222,*" class="bj" frameborder="no" border="0" framespacing="0">

    <frame src="${basePath}common/bg.jsp" scrolling="No" noresize="noresize"/>
    
    <frameset rows="156,*" cols="*" frameborder="no" border="0" framespacing="0">
        <frame src="${basePath}home/homeAction_top.action" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
        <frameset cols="14%,60%" frameborder="no" border="0" framespacing="0">
            <frame src="${basePath}home/homeAction_left.action" scrolling="yes" noresize="noresize" id="leftFrame" />
            <frame src="${basePath}common/welcome.jsp" name="mainFrame" id="mainFrame" />
        </frameset>
    </frameset>
    
    <frame src="${basePath}common/bg.jsp" scrolling="No" noresize="noresize"/>
    
</frameset>

<body>
<br>
</body>
</html>