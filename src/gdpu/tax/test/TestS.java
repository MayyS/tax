package gdpu.tax.test;

import com.alibaba.fastjson.JSON;
import gdpu.tax.entity.Role;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @Auther:S
 * @Date:18/12/30
 */
public class TestS {
    @Test
    public void testMd5(){
        System.out.println(new Md5Hash("123456").toString());
    }

    @Test
    public void testJson(){
        Role role=new Role();
        role.setRoleName("dba");
        String obj= JSON.toJSONString(role);
        System.out.println(obj);
    }
}
