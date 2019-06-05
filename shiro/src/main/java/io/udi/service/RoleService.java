package io.udi.service;


import io.udi.entity.Role;

/**
 * @Author: HWB
 * @DateTime: 2019/6/4 21:39
 * @Description: TODO
 */
public interface RoleService {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);
    //添加角色-权限之间关系
    public void correlationPermissions(Long roleId, Long... permissionIds);
    //移除角色-权限之间关系
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);//
}
