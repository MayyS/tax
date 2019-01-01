package gdpu.tax.dao;

import gdpu.tax.base.dao.BaseDao;
import gdpu.tax.entity.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * 
	 * @param account 账号
	 * @param pwd 密码
	 * @return 用户对象
	 */
	public User findUserByAccountAndPwd(String account,String pwd);
	
	public boolean isExist(String account);
}
