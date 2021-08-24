//: com.yulikexuan.spring.core.di.bean.lifecycle.ComplicatedAppCfg.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class ComplicatedAppCfg {

    @Bean(initMethod = "initialize", destroyMethod = "releaseResource")
    ComplicatedBean complicatedBean() {
        return new ComplicatedBean();
    }

}///:~