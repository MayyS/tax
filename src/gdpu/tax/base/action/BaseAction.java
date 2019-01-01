package gdpu.tax.base.action;

import gdpu.tax.entity.PageResult;

public class BaseAction {
	//--------------用于接收分页参数--------------------
		private Integer pageNo=1;  //当前页号，默认是查第一页
		private Integer pageSize=3;  //页大小 ，默认每页显示3条
		public Integer getPageNo() {
			return pageNo;
		}
		public void setPageNo(Integer pageNo) {
			this.pageNo = pageNo;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		//--------------用于接收分页参数--------------------
		
		
		//用于页面回显的分页对象
		public PageResult pageResult;
		public PageResult getPageResult() {
			return pageResult;
		}
		public void setPageResult(PageResult pageResult) {
			this.pageResult = pageResult;
		}
		
		
		//接收批量删除的id
		private Integer[] selectedRows;
		public Integer[] getSelectedRows() {
			return selectedRows;
		}
		public void setSelectedRows(Integer[] selectedRows) {
			this.selectedRows = selectedRows;
		}




		//////////

	private int rows;
	private int page;
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String listUI(){
			return "listUI";
		}

	public String addUI(){
			return "addUI";
		}

		
}
