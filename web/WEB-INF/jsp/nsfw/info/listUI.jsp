<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
 <!--    <script type="text/javascript">
  //分页实现
 	function findByPage(pageNo){
 		$("#form").prop("action","${basePath}info/infoAction_listUI.action?pageNo="+pageNo);
 		$("#form").submit();
 	}
   
    </script> -->
    <script type="text/javascript" chartset="utf-8" src="${basePath}js/function/info_fun.js"></script>

</head>
<body class="rightBody">
<form name="form1" id="form" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        信息标题：<input type="text" name="info.title" class="s_text" id="infoTitle"  style="width:160px;"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch('info')"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd('info')"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll('info')"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" id="selAll" onclick="doSelectAll('info')" /></td>
                            <td align="center">信息标题</td>
                            <td width="120" align="center">信息分类</td>
                            <td width="120" align="center">创建人</td>
                            <td width="140" align="center">创建时间</td>
                            <td width="80" align="center">状态</td>
                            <td width="120" align="center">操作</td>
                        </tr>
                        <c:forEach items="${pageResult.items}" var="info">
                        	 <tr>
                                <td align="center"><input type="checkbox" name="selectedRows" value="${info.id}"/></td>
                                <td align="center">${info.title}</td>
                                <td align="center">${info.type}</td>
                                <td align="center">${info.creator}</td>
                                <td align="center">
                                	<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td align="center" id="state_${info.id}">${info.state==0?'停用':'发布'}</td>
                                <td align="center">
                                	<span id="oper_${info.id}">
                                		<c:if test="${info.state=='0' or empty info.state}">
                                			<a href="javascript:changeState(${info.id},1)">发布</a>
                                		</c:if>
                                		<c:if test="${info.state=='1' }">
                                			<a href="javascript:changeState(${info.id},0)">停用</a>
                                		</c:if>
                                	</span>
                       
                                    <a href="${basePath}info/infoAction_editUI.action?info.id=${info.id}">编辑</a>
                                    <a href="${basePath}info/infoAction_delete.action?info.id=${info.id}">删除</a>
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