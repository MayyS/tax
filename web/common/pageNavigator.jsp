<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="c_pate" style="margin-top: 5px;">
	<table width="100%" class="pageDown" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="right">
	               	总共${pageResult.totalCount}条记录，当前第${pageResult.pageNo}页，共${pageResult.totalPageCount} 页 &nbsp;&nbsp;
	               	 每页显示<select name="pageSize" onchange="javascript:findByPage(1)">
	               	 	<option value="3" ${pageResult.pageSize==3? 'selected="selected"' :'' }>3</option>
	               	 	<option value="5" ${pageResult.pageSize==5? 'selected="selected"' :'' }>5</option>
	               	 	<option value="10" ${pageResult.pageSize==10? 'selected="selected"' :'' }>10</option>
	               	 </select>条，
	               	 	<c:if test="${pageResult.pageNo>1}">
	               	 		<a href="javascript:findByPage(${pageResult.pageNo-1})">上一页</a>
	               	 	</c:if>
                       	<c:if test="${pageResult.pageNo < pageResult.totalPageCount}">
                       		<a href="javascript:findByPage(${pageResult.pageNo+1})">下一页</a>
                       	</c:if>
                       
				到&nbsp;<input type="text" style="width: 30px;" 
				onkeypress="if(event.keyCode == 13){findByPage( (this.value > ${pageResult.totalPageCount} || this.value <1)? ${pageResult.totalPageCount}:this.value)}" min="1"
				max="" /> &nbsp;&nbsp;
		    </td>
		</tr>
	</table>	
</div>

