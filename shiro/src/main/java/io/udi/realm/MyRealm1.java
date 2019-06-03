package io.udi.realm;


import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Author: HWB
 * @DateTime: 2019/6/2 14:21
 * @Description: TODO
 */
public class MyRealm1 implements Realm {
    public String getName() {
        return "myrealm1";
    }

    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        String password =new String((char[])token.getCredentials());
        if (!"zhang".equals(username))
        {
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException(); //如果密码错误
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
