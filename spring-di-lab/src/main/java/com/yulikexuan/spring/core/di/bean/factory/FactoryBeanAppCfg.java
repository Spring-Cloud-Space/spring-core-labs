//: com.yulikexuan.spring.core.di.bean.factory.FactoryBeanAppCfg.java

package com.yulikexuan.spring.core.di.bean.factory;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
class FactoryBeanAppCfg {

    @Bean
    FactoryBean<TaxFormula> taxFormulaFactoryBean() {
        return new TaxFormulaFactoryBean();
    }

    @Bean
    TaxFormula taxFormula() throws Exception {
        return taxFormulaFactoryBean().getObject();
    }

}///:~