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
	//���ڷ�װҳ���<input>���ݹ�����ֵ
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//����һ��ȫ�ֱ���������ҳ��ȡֵ
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
	
	//��תaddUI.jsp
	public String addUI(){
		return "addUI";
	}
	
	
	//���ڱ���user
	public String add(){
		
		userService.save(user);
		
		return "list";
	}
	
	//��תedit.jsp
	public String editUI(){
		user = userService.findObjectById(user.getId());
		return "editUI";
	}
	
	
	
	//�����޸�
	
	public String edit(){
		userService.update(user);
		return "list";
	}
	
	//ɾ��һ��
	public String delete(){
		userService.delete(user);
		return "list";
	}
	
	
	//����ɾ��
	public String deleteSelected(){
		userService.deleteAll(getSelectedRows());
		return "list";
	}
	
	//����
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
	
	//����excel�ļ��������
	public void exportExcel() throws Exception{
		
		//��ȡ��Ӧ����
		HttpServletResponse response = ServletActionContext.getResponse();
		//��ȡ���������
		ServletOutputStream os = response.getOutputStream();
		
		//�����������ͣ���ʽΪexcel�ļ���ʽ
		response.setContentType("application/x-excel");
		//���������ļ������ԣ�������������չʾ�ļ�����
		response.setHeader("Content-Disposition", "attachment;filename="+new String("�û��б�.xls".getBytes(),"ISO-8859-1"));
		
		//��ѯ�б�����
		List<User> dataList = userService.findObjects("from User");
		//����excel�ļ�
		ExcelUtil.exportExcel(dataList, os);
	}
	
	private String account;
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	//ע��ʱ��֤�˺ŵ�Ψһ��
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
