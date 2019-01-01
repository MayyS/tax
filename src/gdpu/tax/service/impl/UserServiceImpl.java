package gdpu.tax.service.impl;

import java.io.Serializable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gdpu.tax.dao.RoleDao;
import gdpu.tax.entity.Role;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdpu.tax.dao.UserDao;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.User;
import gdpu.tax.service.UserService;

@Service
@Transactional

public class UserServiceImpl implements UserService  {
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<User> findObjects(String hql) {
		return userDao.findObjects(hql);
	}

	@Override
	public User findObjectById(Serializable id) {
		User user= userDao.findObjectById(id);
		Hibernate.initialize(user.getRoles());
		return user;
	}

	@Override
	public void save(User entity) {
		Md5Hash md5Hash=new Md5Hash(entity.getPassword());
		String pwd=md5Hash.toString();
		entity.setPassword(pwd);
		userDao.save(entity);

	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public void delete(User entity) {
		userDao.delete(entity);

	}

	@Override
	public void deleteAll(Serializable[] ids) {
		userDao.deleteAll(ids);

	}

	@Override
	public User findUserByAccountAndPwd(String account, String pwd) {
		// TODO Auto-generated method stub
		return userDao.findUserByAccountAndPwd(account, new Md5Hash(pwd).toString());
	}

	@Override
	public List<User> searchObjects(String attr, String val) {
		return userDao.searchObjects(attr, val);
	}

	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		List<User>items=userDao.findObjects(hql, pageNo, pageSize);

		Long totalCount = userDao.findTotalCount();
		PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}

	@Override
	public boolean isExist(String account) {
		
		return userDao.isExist(account);
	}

	@Override
	public void savaUserRole(Integer userId, Integer[] roleIds) {
		User user=userDao.findObjectById(userId);
		Set<Role>roles=new HashSet<>();
		if(roleIds!=null&&roleIds.length>0){
			for (Integer roleId:roleIds){
				Role role=roleDao.findObjectById(roleId);
				roles.add(role);
			}
		}
		user.setRoles(roles);
		userDao.update(user);
	}

	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
