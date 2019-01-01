package gdpu.tax.service.impl;

import java.io.Serializable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gdpu.tax.dao.PermissionDao;
import gdpu.tax.entity.Permission;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdpu.tax.dao.RoleDao;
import gdpu.tax.entity.Info;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.Role;
import gdpu.tax.service.RoleService;

@Service
@Transactional

public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermissionDao permissionDao;
	
	@Override
	
	
	public List<Role> findObjects(String hql) {
		return roleDao.findObjects(hql);
	}

	@Override
	public Role findObjectById(Serializable id) {
		Role role=roleDao.findObjectById(id);
		Hibernate.initialize(role.getPermissions());

		return role;
	}

	@Override
	public void save(Role entity) {
		roleDao.save(entity);
		
	}

	@Override
	public void update(Role entity) {
		roleDao.update(entity);
		
	}

	@Override
	public void delete(Role entity) {
		roleDao.delete(entity);
		
	}

	@Override
	public void deleteAll(Serializable[] ids) {
		roleDao.deleteAll(ids);
		
	}

	@Override
	public List<Role> searchObjects(String attr, String val) {
		return null;
	}

	@Override
	public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
		List<Role> items =roleDao.findObjects(hql, pageNo, pageSize);
		
		Long totalCount=roleDao.findTotalCount();
		PageResult page=new PageResult(totalCount, pageNo, pageSize, items);
		return page;
	}

	@Override
	public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
		//分页查询数据结果
				List<Role> items = roleDao.findObjects(hql, conditions,pageNo, pageSize);
				
				//查询总记录数
				Long totalCount = roleDao.findTotalCount(hql,conditions);
				
				PageResult page = new PageResult(totalCount, pageNo, pageSize, items);
				return page;
	}

	public List<Object> findUserRoleByRoleId(Integer id){
		return roleDao.findUserRoleByRoleId(id);
	}

	@Override
	public void savaRolePermission(Integer roleId, String permissionIds) {
		Role role=roleDao.findObjectById(roleId);

		Set<Permission>permissions=new HashSet<>();

		if(StringUtils.isNotBlank(permissionIds)){
			String []permissionArray=permissionIds.split(",");
			for (String permissinId:permissionArray){
				Permission permission= permissionDao.findObjectById(Integer.parseInt(permissinId));
				permissions.add(permission);
			}
		}
		System.out.println(permissions);
		role.setPermissions(permissions);
		roleDao.update(role);
	}

}
