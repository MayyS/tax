package gdpu.tax.dao.impl;

import org.springframework.stereotype.Repository;
import java.util.List;


import org.hibernate.Query;

import gdpu.tax.base.dao.impl.BaseDaoImpl;
import gdpu.tax.dao.UserDao;
import gdpu.tax.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findUserByAccountAndPwd(String account, String pwd) {
		// TODO Auto-generated method stub
		Query query =getSession().createQuery("from User where account= ? and password = ?");
		query.setParameter(0, account);
		query.setParameter(1, pwd);
		List list=query.list();
		if(list.size()>0) {
			return (User)list.get(0);
		}
		return null;
	}

	@Override
	public boolean isExist(String account) {
		Query query =getSession().createQuery("from User where account= ?");
		query.setParameter(0, account);
		return query.list().size()>0;
	}
	
	

}
