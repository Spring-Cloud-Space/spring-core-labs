//: com.yulikexuan.spring.core.di.spel.InjectFromBeanPropertiesCfg.java

package com.yulikexuan.spring.core.di.spel;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;


@Slf4j
@Configuration
class InjectFromBeanPropertiesCfg {

    @Bean
    public Properties dbProps() {

        Properties p = new Properties();

        p.setProperty("driverClassName", "org.h2.Driver");
        p.setProperty("url", "jdbc:h2:~/sample");
        p.setProperty("username", "sample");
        p.setProperty("password", "sample");

        return p;
    }

    @Bean
    public DataSource dataSource(
            @Value("#{dbProps.driverClassName}") String driverClassName,
            @Value("#{dbProps.url}") String url,
            @Value("#{dbProps.username}") String username,
            @Value("#{dbProps.password}") String password) throws
            SQLException {

        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);

        return ds;
    }

}///:~