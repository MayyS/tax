package gdpu.tax.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import gdpu.tax.base.dao.impl.BaseDaoImpl;
import gdpu.tax.dao.RoleDao;
import gdpu.tax.entity.Role;

import java.util.List;

@Repository

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

    @Override
    public List<Object> findUserRoleByRoleId(Integer id) {
        String sql="select * from user_role where roleId=?";
        Session session=getSession();
        SQLQuery sqlQuery=session.createSQLQuery(sql);
        sqlQuery.setParameter(0,id);
        return sqlQuery.list();
    }
}
