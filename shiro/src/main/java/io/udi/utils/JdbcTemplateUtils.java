package io.udi.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: HWB
 * @DateTime: 2019/6/4 22:04
 * @Description: TODO
 */
public class JdbcTemplateUtils {
    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate jdbcTemplate(){
        if(jdbcTemplate == null){
            jdbcTemplate = createJdbcTemplate();
        }
        return  jdbcTemplate;
    }

    private static JdbcTemplate createJdbcTemplate() {

        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://172.16.10.20:3306/shiro_demo");
        ds.setUsername("root");
        ds.setPassword("Mysql_123");
        return  new JdbcTemplate(ds);
    }
}
