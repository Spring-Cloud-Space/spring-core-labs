//: com.yulikexuan.spring.core.di.bean.factory.TaxPlanCode.java

package com.yulikexuan.spring.core.di.bean.factory;


enum TaxPlanCode {

    S {
        @Override
        TaxFormula createTaxFormula() {
            return new ScotlandRateFormula();
        }
    },

    NT {
        @Override
        TaxFormula createTaxFormula() {
            return new NoTaxFormula();
        }
    };

    private TaxPlanCode() {
    }

    abstract TaxFormula createTaxFormula();

}///:~