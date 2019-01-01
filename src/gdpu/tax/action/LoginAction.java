package gdpu.tax.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import gdpu.tax.entity.User;
import gdpu.tax.service.UserService;

public class LoginAction {
	@Autowired
	private UserService userService;
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//������ʾ��Ϣ
	private String errorMessage="";
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	//��ת����¼ҳ��
		public String loginUI(){
			return "loginUI";
		}
	public String login() {
		User selectedUser=userService.findUserByAccountAndPwd(user.getAccount(), user.getPassword());
		if(selectedUser!=null) {
			//���û���Ϣ������HttpSession��
			//��ȡsession����
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("SYS_USER", selectedUser);
			return "home";
		}
		this.errorMessage="�û�������������";

		return "fail";
	}
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("SYS_USER");
		return "fail";
	}
}
