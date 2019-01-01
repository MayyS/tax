package gdpu.tax.service;

import gdpu.tax.base.service.Service;
import gdpu.tax.entity.Permission;

import java.util.List;

/**
 * @Auther:S
 * @Date:18/12/31
 */
public interface PermissionService extends Service<Permission> {
    public List<Object>findRolePermissionByPermissionId(Integer id);
}
