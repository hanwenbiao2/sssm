import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: HWB
 * @DateTime: 2019/6/1 15:10
 * @Description: TODO
 */
public class LoginLogoutTest {
    private static Log log = LogFactory.getLog(LoginLogoutTest.class);

    @Test
    public void testHelloworld() {
//       获取securityManger工厂，使用shiro.ini来初始化SecurityManager工厂
        log.info("使用shiro.ini来初始化SecurityManager工厂");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        获取SecurityManger实例，并绑定该SecurityUtils
        SecurityManager securityManger = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManger);
//        得到Subject
        Subject subject = SecurityUtils.getSubject();
//      创建验证用户和密码的Token（即用户/凭证）
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//        登录即验证身份
        try {
            subject.login(token);

        } catch (UnknownAccountException e) {
            log.info("登陆失败");
//            登录失败
        }
        Assert.assertEquals(true, subject.isAuthenticated());
//        退出登录
        subject.logout();
        log.info("退出登录");

    }

    @Test
    public void testRealm() {
//       获取securityManger工厂，使用shiro.ini来初始化SecurityManager工厂
        log.info("使用shiro-realm.ini来初始化SecurityManager工厂");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
//        获取SecurityManger实例，并绑定该SecurityUtils
        SecurityManager securityManger = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManger);
//        得到Subject
        Subject subject = SecurityUtils.getSubject();
//      创建验证用户和密码的Token（即用户/凭证）
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//        登录即验证身份
        try {
            subject.login(token);

        } catch (UnknownAccountException e) {
            log.info("登陆失败");
//            登录失败
        }
        log.info("退出成功");
        Assert.assertEquals(true, subject.isAuthenticated());
//        退出登录
        subject.logout();
        log.info("退出登录");

    }
    @Test
    public void testMutilRealm() {
//       获取securityManger工厂，使用shiro-multi-realm.ini来初始化SecurityManager工厂
        log.info("使用shiro-realm.ini来初始化SecurityManager工厂");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
//        获取SecurityManger实例，并绑定该SecurityUtils
        SecurityManager securityManger = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManger);
//        得到Subject
        Subject subject = SecurityUtils.getSubject();
//      创建验证用户和密码的Token（即用户/凭证）
        UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
//        登录即验证身份
        try {
            subject.login(token);

        } catch (UnknownAccountException e) {
            log.info("登陆失败");
//            登录失败
        }
        log.info("退出成功");
        log.info(subject.getPrincipal());
//        退出登录
        subject.logout();
        log.info("退出登录");

    }

    @Test
    public void testJdbcRealm() {
//       获取securityManger工厂，使用shiro-multi-realm.ini来初始化SecurityManager工厂
        log.info("使用shiro-realm.ini来初始化SecurityManager工厂");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
//        获取SecurityManger实例，并绑定该SecurityUtils
        SecurityManager securityManger = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManger);
//        得到Subject
        Subject subject = SecurityUtils.getSubject();
//      创建验证用户和密码的Token（即用户/凭证）
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//        登录即验证身份
        try {
            subject.login(token);

        } catch (UnknownAccountException e) {
            log.info("登陆失败");
//            登录失败
        }
        log.info("登录成功");
        log.info(subject.getPrincipal());
//        退出登录
        subject.logout();
        log.info("退出登录");

    }
}
