//: com.yulikexuan.spring.core.di.autowired.AutowiredAppCfg.java

package com.yulikexuan.spring.core.di.autowired;


import com.yulikexuan.spring.core.di.dbcfg.DataSourceAppCfg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;


@Slf4j
@Configuration
@Import(DataSourceAppCfg.class)
@ComponentScan("com.yulikexuan.spring.core.di.autowired")
class AutowiredAppCfg {

    @Autowired
    DataSource dataSource;

}///:~