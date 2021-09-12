//: com.yulikexuan.spring.core.di.bean.factory.FlexTaxFormularFactoryBean.java

package com.yulikexuan.spring.core.di.bean.factory;


import org.springframework.beans.factory.config.AbstractFactoryBean;


class FlexTaxFormularFactoryBean extends AbstractFactoryBean<TaxFormula> {

    public FlexTaxFormularFactoryBean() {
        this.setSingleton(false);
    }

    @Override
    public Class<?> getObjectType() {
        return ScotlandRateFormula.class;
    }

    @Override
    protected TaxFormula createInstance() throws Exception {
        return new ScotlandRateFormula();
    }

}///:~