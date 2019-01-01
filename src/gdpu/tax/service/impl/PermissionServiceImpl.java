package gdpu.tax.service.impl;

import gdpu.tax.dao.PermissionDao;
import gdpu.tax.entity.PageResult;
import gdpu.tax.entity.Permission;
import gdpu.tax.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther:S
 * @Date:18/12/31
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findObjects(String hql) {
        return permissionDao.findObjects(hql);
    }

    @Override
    public Permission findObjectById(Serializable id) {
        return permissionDao.findObjectById(id);
    }

    @Override
    public void save(Permission entity) {
        permissionDao.save(entity);

    }

    @Override
    public void update(Permission entity) {
        permissionDao.update(entity);
    }

    @Override
    public void delete(Permission entity) {
        permissionDao.delete(entity);
    }

    @Override
    public void deleteAll(Serializable[] ids) {
        permissionDao.deleteAll(ids);
    }

    @Override
    public List<Permission> searchObjects(String attr, String val) {
        return null;
    }

    @Override
    public PageResult findObjects(String hql, Integer pageNo, Integer pageSize) {
        List<Permission>items=permissionDao.findObjects(hql,pageNo,pageSize);
        Long totalCount=permissionDao.findTotalCount();
        PageResult pageResult=new PageResult(totalCount,pageNo,pageSize,items);
        return pageResult;
    }

    @Override
    public PageResult findObjects(String hql, List<Object> conditions, Integer pageNo, Integer pageSize) {
        List<Permission>items=permissionDao.findObjects(hql,conditions,pageNo,pageSize);

        Long totalCount=permissionDao.findTotalCount(hql,conditions);
        PageResult pageResult=new PageResult(totalCount,pageNo,pageSize,items);
        return pageResult;
    }

    @Override
    public List<Object> findRolePermissionByPermissionId(Integer id) {
        return permissionDao.findRolePermissionByPermissionId(id);
    }
}
