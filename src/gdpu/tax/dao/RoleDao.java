package gdpu.tax.dao;

import gdpu.tax.base.dao.BaseDao;
import gdpu.tax.entity.Role;

import java.util.List;

public interface RoleDao extends BaseDao<Role>{

    public List<Object>findUserRoleByRoleId(Integer id);

}
