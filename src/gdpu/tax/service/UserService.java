package gdpu.tax.service;

import java.io.Serializable;
import java.util.List;

import gdpu.tax.base.service.Service;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.User;
public  interface UserService extends Service<User>{
		public void deleteAll(Serializable[] ids);
		/**
		 * 
		 * @param account 账号
		 * @param pwd 密码
		 * @return 用户对象
		 */
		public User findUserByAccountAndPwd(String account,String pwd);
		
		public boolean isExist(String account);

		public void savaUserRole(Integer userId,Integer[]roleds);
	
}
