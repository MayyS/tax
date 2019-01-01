package gdpu.tax.test;

import gdpu.tax.dao.UserDao;
import gdpu.tax.entity.Role;
import gdpu.tax.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Auther:S
 * @Date:18/12/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testSave(){
        User user=new User();
        user.setName("test1");
        user.setBirthday(new Date());
        Role role1=new Role();
        role1.setRoleName("avg");
        Role role2=new Role();
        role2.setRoleName("dba");
        user.getRoles().add(role1);
        user.getRoles().add(role2);
        userDao.save(user);
    }
}
