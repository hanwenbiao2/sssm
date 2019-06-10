package io.udi.service.impl;

import io.udi.dao.RoleDao;
import io.udi.dao.impl.RoleDaoImpl;
import io.udi.entity.Role;
import io.udi.service.RoleService;

/**
 * @Author: HWB
 * @DateTime: 2019/6/5 15:46
 * @Description: TODO
 */
public class RoleServiceImpl  implements RoleService {
    RoleDao roleDao = new RoleDaoImpl();
    public Role createRole(Role role) {
        Role role1 = roleDao.createRole(role);
        return role1;

    }

    public void deleteRole(Long roleId) {

    }

    public void correlationPermissions(Long roleId, Long... permissionIds) {

    }

    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {

    }
}
