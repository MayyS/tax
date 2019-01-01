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
	//错误提示信息
	private String errorMessage="";
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	//跳转到登录页面
		public String loginUI(){
			return "loginUI";
		}
	public String login() {
		User selectedUser=userService.findUserByAccountAndPwd(user.getAccount(), user.getPassword());
		if(selectedUser!=null) {
			//将用户信息保存在HttpSession中
			//获取session对象
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("SYS_USER", selectedUser);
			return "home";
		}
		this.errorMessage="用户或密码名错误";

		return "fail";
	}
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("SYS_USER");
		return "fail";
	}
}
