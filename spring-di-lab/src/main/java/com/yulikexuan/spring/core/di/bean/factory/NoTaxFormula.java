//: com.yulikexuan.spring.core.di.bean.factory.NoTaxFormula.java

package com.yulikexuan.spring.core.di.bean.factory;


record NoTaxFormula() implements TaxFormula {

    private static final String NO_TAX_FORMULA = "*1.0";

    @Override
    public String getFormula() {
        return NO_TAX_FORMULA;
    }

}///:~