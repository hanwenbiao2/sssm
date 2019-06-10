package chapter6.service;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: HWB
 * @DateTime: 2019/6/4 22:48
 * @Description: TODO
 */
public class UserRealmTest extends  BaseTest {

    @Test
    public void testLoginSuccess() {
        login("classpath:chapter6/shiro.ini", u1.getUsername(), password);
        Assert.assertTrue(subject().isAuthenticated());
    }

    @Test
    public void testLoginFailWithUnknownUsername() {
        try {
            login("classpath:chapter6/shiro.ini", u1.getUsername() + "1", password);
        }catch (UnknownAccountException e){
            e.printStackTrace();
        }

    }
    @Test(expected = IncorrectCredentialsException.class)
    public void testLoginFailWithErrorPassowrd() {
        login("classpath:shiro.ini", u1.getUsername(), password + "1");
    }
    @Test(expected = LockedAccountException.class)
    public void testLoginFailWithLocked() {
        login("classpath:chapter6/shiro.ini", u4.getUsername(), password + "1");
    }
    @Test(expected = UnauthenticatedException.class)
    public void testLoginFailWithLimitRetryCount() {
        for(int i = 1; i <= 5; i++) {
            try {
                login("classpath:chapter6/shiro.ini", u3.getUsername(), password + "1");
            } catch (Exception e) {/*ignore*/}
        }
        login("classpath:shiro.ini", u3.getUsername(), password + "1");

        //需要清空缓存，否则后续的执行就会遇到问题(或者使用一个全新账户测试)
    }
    @Test
    public void testLoginMutil() {
        login("classpath:chapter6/shiro-mutil.ini", "zhan1g", "123");
        Assert.assertTrue(subject().isAuthenticated());
    }
    @Test
    public void testHasRole() {
        login("classpath:chapter6/shiro.ini", u1.getUsername(), password );
        Assert.assertTrue(subject().hasRole("admin"));
    }
}
