package gdpu.tax.base.action;

import gdpu.tax.entity.PageResult;

public class BaseAction {
	//--------------���ڽ��շ�ҳ����--------------------
		private Integer pageNo=1;  //��ǰҳ�ţ�Ĭ���ǲ��һҳ
		private Integer pageSize=3;  //ҳ��С ��Ĭ��ÿҳ��ʾ3��
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
		//--------------���ڽ��շ�ҳ����--------------------
		
		
		//����ҳ����Եķ�ҳ����
		public PageResult pageResult;
		public PageResult getPageResult() {
			return pageResult;
		}
		public void setPageResult(PageResult pageResult) {
			this.pageResult = pageResult;
		}
		
		
		//��������ɾ����id
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
