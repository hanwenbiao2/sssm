import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: HWB
 * @DateTime: 2019/6/2 21:22
 * @Description: TODO
 */
public class PermissionTest extends BaseTest {
    @Test
    public void testIsPermitted(){
        login("classpath:shiro-permission.ini", "zhang", "123");
        Assert.assertTrue(getSubject().isPermitted("user:create"));
        Assert.assertTrue(getSubject().isPermittedAll("user:create","user:delete"));
        Assert.assertFalse(getSubject().isPermitted("user:view"));
    }
}
