//: com.yulikexuan.spring.core.di.bean.lifecycle.assignment.AssignmentCfg.java

package com.yulikexuan.spring.core.di.bean.lifecycle.assignment;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
class AssignmentCfg {

    @Bean
    IResource DepBean() {
        return new DepBean();
    }

    @Bean(initMethod = "initializeResource", destroyMethod = "closeResource")
    FunBean funBean(IResource resource) {
        return new FunBean(resource);
    }

}///:~