package io.udi.dao.impl;

import io.udi.dao.RoleDao;
import io.udi.entity.Role;
import io.udi.utils.JdbcTemplateUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @Author: HWB
 * @DateTime: 2019/6/5 15:49
 * @Description: TODO
 */
public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

    public Role createRole(final Role role) {
        final String sql = "insert into sys_roles(role, description, available) values(?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                psst.setString(1, role.getRole());
                psst.setString(2, role.getDescription());
                psst.setBoolean(3, role.getAvailable());
                return psst;
            }
        }, keyHolder);
        role.setId(keyHolder.getKey().longValue());
        return role;
    }



    public void deleteRole(Long roleId) {

    }

    public void correlationPermissions(Long roleId, Long... permissionIds) {

    }

    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {

    }
}
