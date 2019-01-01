package gdpu.tax.service;

import gdpu.tax.base.service.Service;
import gdpu.tax.entity.Role;

import java.util.List;

public interface RoleService extends Service<Role> {
    public List<Object> findUserRoleByRoleId(Integer id);

    public void savaRolePermission(Integer roleId,String permissionIds);

}
