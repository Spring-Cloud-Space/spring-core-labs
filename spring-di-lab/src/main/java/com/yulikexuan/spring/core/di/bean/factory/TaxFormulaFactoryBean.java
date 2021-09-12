//: com.yulikexuan.spring.core.di.bean.factory.TaxFormulaFactoryBean.java

package com.yulikexuan.spring.core.di.bean.factory;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;


@Slf4j
class TaxFormulaFactoryBean implements FactoryBean<TaxFormula> {

    private TaxFormula taxFormula = new ScotlandRateFormula();

    TaxFormulaFactoryBean() {
        log.info(">>>>>>> Look ma, no definition!");
    }

    @Override
    public TaxFormula getObject() throws Exception {
        return this.taxFormula;
    }

    @Override
    public Class<?> getObjectType() {
        return ScotlandRateFormula.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}///:~