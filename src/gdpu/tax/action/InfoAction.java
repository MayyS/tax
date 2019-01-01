package gdpu.tax.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gdpu.tax.service.InfoService;
import gdpu.tax.base.action.BaseAction;
import gdpu.tax.entity.Info;
import gdpu.tax.entity.PageResult;

public class InfoAction extends BaseAction{

	private Info info;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
	
	//用于页面取信息列表的对象
		private List<Info> infoList;
		public List<Info> getInfoList() {
			return infoList;
		}
		public void setInfoList(List<Info> infoList) {
			this.infoList = infoList;
		}

		@Autowired
		private InfoService infoService;
		
		
		public String listUI(){
			//infoList = infoService.findObjects("from Info");
			String hql="from Info";
			pageResult=infoService.findObjects(hql, getPageNo(),getPageSize());
			
			return "listUI";
		}
		
		//跳转到addUI.jsp页面
		public String addUI(){
			return "addUI";
		}
		
		//做新增保存
		public String add(){
			info.setCreateTime(new Date());
			info.setState("0");
			infoService.save(info);
			return "list";
		}

		//查出数据跳转编辑页面editUI.jsp
		public String editUI(){
			info = infoService.findObjectById(info.getId());
			info.setState("0");
			return "editUI";
		}
		
		
		//保存修改的信息
		public String edit(){
			info.setState("0");
			infoService.update(info);
			return "list";
		}
		
		
		public String deleteSelected() {
			infoService.deleteAll(getSelectedRows());
			return "list";
		}
		
		public String delete() {
			infoService.delete(info);
			return "list";
		}
		
		public void changeState() {
			Info selectedInfo = infoService.findObjectById(info.getId());
			selectedInfo.setState(info.getState());
			infoService.update(selectedInfo);
		}
	
	
}
