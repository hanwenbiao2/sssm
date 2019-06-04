package io.udi.dao;

import io.udi.entity.User;

import java.util.Set;

/**
 * @Author: HWB
 * @DateTime: 2019/6/4 21:56
 * @Description: TODO
 */
public interface UserDao {
    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);

    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
