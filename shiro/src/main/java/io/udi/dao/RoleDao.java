package io.udi.dao;

import io.udi.entity.Role;

/**
 * @Author: HWB
 * @DateTime: 2019/6/5 15:48
 * @Description: TODO
 */
public interface RoleDao {
    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    public void correlationPermissions(Long roleId, Long... permissionIds);
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
