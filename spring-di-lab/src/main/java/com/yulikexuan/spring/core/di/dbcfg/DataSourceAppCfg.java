//: com.yulikexuan.spring.core.di.dbcfg.DataSourceAppCfg.java

package com.yulikexuan.spring.core.di.dbcfg;


import com.yulikexuan.spring.core.di.config.YamlPropertySourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;


@Slf4j
@Configuration
@PropertySource(
        value = "classpath:data/datasource.yml",
        factory = YamlPropertySourceFactory.class)
public class DataSourceAppCfg {

    @Bean
    public DataSource dataSource(
            @Value("${spring.datasource.driverClassName}") String driverClassName,
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String pw) throws
            SQLException {

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(pw);

        return ds;
    }

}///:~