package gdpu.tax.action;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import gdpu.tax.entity.Role;
import gdpu.tax.service.RoleService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import gdpu.tax.service.UserService;
import gdpu.tax.util.ExcelUtil;
import gdpu.tax.base.action.BaseAction;
// import gdpu.tax.util.ExcelUtil;
import gdpu.tax.entity.User;

public class UserAction extends BaseAction{
	//用于封装页面的<input>传递过来的值
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//定义一个全局变量，用于页面取值
	private List<User> userList;
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	@Autowired
	private UserService  userService;

	@Autowired
	private RoleService roleService;
	
	public String listUI(){
		
		pageResult = userService.findObjects("from User", getPageNo(), getPageSize());
		System.out.println(userList);
		return "listUI";
	}
	
	//跳转addUI.jsp
	public String addUI(){
		return "addUI";
	}
	
	
	//用于保存user
	public String add(){
		
		userService.save(user);
		
		return "list";
	}
	
	//跳转edit.jsp
	public String editUI(){
		user = userService.findObjectById(user.getId());
		return "editUI";
	}
	
	
	
	//保存修改
	
	public String edit(){
		userService.update(user);
		return "list";
	}
	
	//删除一行
	public String delete(){
		userService.delete(user);
		return "list";
	}
	
	
	//批量删除
	public String deleteSelected(){
		userService.deleteAll(getSelectedRows());
		return "list";
	}
	
	//搜索
	private String attr;
	private String value;
	
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String search() {
		userList=userService.searchObjects(attr, value);
		System.out.println(userList.size());
		if(userList.size()==0) {
			userList=null;
			System.out.println("is null");
		}
		return "list";
	}
	
	//导出excel文件到浏览器
	public void exportExcel() throws Exception{
		
		//获取响应对象
		HttpServletResponse response = ServletActionContext.getResponse();
		//获取输出流对象
		ServletOutputStream os = response.getOutputStream();
		
		//设置下载类型，格式为excel文件格式
		response.setContentType("application/x-excel");
		//设置下载文件的属性，告诉浏览器如何展示文件内容
		response.setHeader("Content-Disposition", "attachment;filename="+new String("用户列表.xls".getBytes(),"ISO-8859-1"));
		
		//查询列表数据
		List<User> dataList = userService.findObjects("from User");
		//生成excel文件
		ExcelUtil.exportExcel(dataList, os);
	}
	
	private String account;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	//注册时验证账号的唯一性
	public boolean accountChecked(String account) {
		return userService.isExist(account);
	}
	

	public String toUserRole(){
		System.out.println("toUesrRole");
		user=userService.findObjectById(user.getId());
		Set<Role>roles=user.getRoles();
		String roleIds="";
		if(roles!=null&&roles.size()>0){
			for (Role role:roles){
				roleIds+=role.getId()+",";
			}
			System.out.println(roleIds);
		}
		List<Role>allRoleList=roleService.findObjects("from Role");
		ActionContext ac=ActionContext.getContext();
		ac.put("roleIds",roleIds);
		ac.put("allRoleList",allRoleList);
		return "toUserRole";
	}

	public String saveUserRole(){
		userService.savaUserRole(user.getId(),getSelectedRows());
		return "list";
	}


}
