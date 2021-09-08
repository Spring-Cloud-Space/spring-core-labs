//: com.yulikexuan.spring.core.di.bean.inheritance.FamilyAppCfg.java

package com.yulikexuan.spring.core.di.bean.inheritance;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.yulikexuan.spring.core.di.bean.inheritance")
class FamilyAppCfg {

    @Bean
    ParentBean parentBean(@Value("John") String surname) {
        return new ParentBean(surname);
    }

    @Bean
    ChildBean childBean(@Value("Lil' John") String surname,
                        @Value("false") Boolean adult) {

        return new ChildBean(surname, adult);
    }

}///:~