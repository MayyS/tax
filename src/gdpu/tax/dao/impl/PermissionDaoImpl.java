package gdpu.tax.dao.impl;

import gdpu.tax.base.dao.impl.BaseDaoImpl;
import gdpu.tax.dao.PermissionDao;
import gdpu.tax.entity.Permission;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther:S
 * @Date:18/12/31
 */

@Repository
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {
    @Override
    public List<Object> findRolePermissionByPermissionId(Integer id) {
        String sql="select * from role_permission where permissionId=?";
        Session session=getSession();
        return session.createSQLQuery(sql).setParameter(0,id).list();
    }
}
