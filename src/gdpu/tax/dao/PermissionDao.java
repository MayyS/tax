package gdpu.tax.dao;

import gdpu.tax.base.dao.BaseDao;
import gdpu.tax.entity.Permission;

import java.util.List;

/**
 * @Auther:S
 * @Date:18/12/31
 */
public interface PermissionDao extends BaseDao<Permission> {
    public List<Object>findRolePermissionByPermissionId(Integer id);
}
