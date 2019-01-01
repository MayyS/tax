<%@ page contentType="text/html; charset=UTF-8"%>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>失败提示信息</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<%-- <link rel="stylesheet" href="${basePath}styles/body.css" type="text/css" /> --%>
		<style type="text/css">
			.submit_hint{
				border-collapse:collapse;
				border:1px solid #CCDEF6;
				text-align:left;
				vertical-align:middle;
				width:100%;
			}
			input.button {
			    padding-left:5px;padding-right:5px;border: 1px solid #387DB5; COLOR: #000;  HEIGHT: 30px; 
				background:url(${basePath}images/common/whole_btn_bg.gif);CURSOR: hand;height:25px; 
			}
		</style>
	</head>
	<body>
		<table class="submit_hint">
						<tr><td>
							<div id="tabBtnContainer" width="100%">
								<ul id="tabBtnUi">
									<li><a href="#"></a>失败提示信息</li>
								</ul>
							</div></td>
						</tr>
								<tr><td style="font-size: 14px;color:#ff0000;padding-top: 2px;" align='center' valign="middle">
								<img alt="" src="${basePath}images/common/info.png" align="middle" height="30" width="30" />
								<span style="vertical-align: middle">出现未知错误！点击确定返回！</span>
								</td></tr>
					</table>
					<table width='100%'>
						<tr><td align="center">
									<input type="button" align="middle" class="button" value="确定" onclick="history.go(-1);" />
							</td></tr>
					</table>
	</body>
</html>