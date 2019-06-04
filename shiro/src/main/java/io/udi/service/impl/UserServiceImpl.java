package io.udi.service.impl;

import io.udi.dao.UserDao;
import io.udi.dao.impl.UserDaoImpl;
import io.udi.entity.User;
import io.udi.service.UserService;
import io.udi.utils.PasswordHelper;

import java.util.Set;

/**
 * @Author: HWB
 * @DateTime: 2019/6/4 21:41
 * @Description: TODO
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private PasswordHelper passwordHelper = new PasswordHelper();
    public User createUser(User user) {
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    public void changePassword(Long userId, String newPassword) {

    }

    public void correlationRoles(Long userId, Long... roleIds) {

    }

    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    public User findByUsername(String username) {
        return null;
    }

    public Set<String> findRoles(String username) {
        return null;
    }

    public Set<String> findPermissions(String username) {
        return null;
    }
}
