package gdpu.tax.dao;

import gdpu.tax.base.dao.BaseDao;
import gdpu.tax.entity.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * 
	 * @param account �˺�
	 * @param pwd ����
	 * @return �û�����
	 */
	public User findUserByAccountAndPwd(String account,String pwd);
	
	public boolean isExist(String account);
}
