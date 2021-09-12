//: com.yulikexuan.spring.core.di.bean.factory.ScotlandRateFormula.java

package com.yulikexuan.spring.core.di.bean.factory;


record ScotlandRateFormula() implements TaxFormula {

    private static final String SCOTLAND_RATE_FORMULA = "*0.25";

    @Override
    public String getFormula() {
        return SCOTLAND_RATE_FORMULA;
    }

}///:~