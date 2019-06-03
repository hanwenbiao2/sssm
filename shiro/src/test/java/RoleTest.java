import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


/**
 * @Author: HWB
 * @DateTime: 2019/6/2 19:58
 * @Description: TODO
 */
public class RoleTest extends BaseTest {

    @Test
    public void testHashRole(){
        login("classpath:shiro-role.ini","zhang","123");
        Assert.assertTrue(getSubject().hasRole("role1"));
        Assert.assertTrue(getSubject().hasAllRoles(Arrays.asList("role1","role2")));
        boolean[] result = getSubject().hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }
    @Test(expected = UnauthorizedException.class)
    public void testCheckRole(){
        login("classpath:shiro-role.ini","zhang","123");
        getSubject().checkRole("role1");
        getSubject().checkRoles("role1","role3");

    }
}
