<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>纳税咨询管理</title>
    <script type="text/javascript">
    
    </script>
</head>
<body class="rightBody">
<form name="form1" id="form" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>纳税咨询管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	咨询标题：<input type="text" name="consult.title" class="s_text"  style="width:160px;"/>
                    </li>
                   
                    <li>
                       	状态：
                       	<select name="consult.state">
                       		<option value="">全部</option>
                       		<option value="0">未处理</option>
                       		<option value="1">已处理</option>
                       	</select>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
					<li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="doAdd('consult')"/>&nbsp;
                    </li>
                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td align="center">咨询标题</td>
                            <td width="120" align="center">咨询人单位</td>
                            <td width="120" align="center">咨询人</td>
                            <td width="140" align="center">咨询时间</td>
                            <td width="100" align="center">状态</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                       
                      	 <tr>
                      	 	<td align="center"></td>
                           <td align="center"></td>
                           <td align="center"></td>
                           <td align="center"></td>
                           <td align="center"></td>
                           <td align="center">
                               <a href="#">处理</a>
                           </td>
                       </tr>
                        
                    </table>
                </div>
            </div>


			<jsp:include page="/common/pageNavigator.jsp"></jsp:include>
        </div>
    </div>
</form>

</body>
</html>