<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    <script type="text/javascript" src="${basePath}js/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${basePath}js/jquery/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${basePath}js/jquery/messages_zh.js"></script>


<%
    String path = request.getContextPath();
	//http://localhost:8080/itcast-tax/
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<%-- <base href="${basePath}"/> --%>
<link href="${basePath}css/skin1.css" rel="stylesheet" type="text/css" />



<%-- <link rel="stylesheet" href="${basePath}css/milk.css"> --%>
<script type="text/javascript" charset="utf-8" src="${basePath}js/function/BaseFun.js"></script>



<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/locale/easyui-lang-zh_CN.js"></script>