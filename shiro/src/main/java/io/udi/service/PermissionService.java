package io.udi.service;


import io.udi.entity.Permission;

/**
 * @Author: HWB
 * @DateTime: 2019/6/4 21:39
 * @Description: TODO
 */
public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
