//: com.yulikexuan.spring.core.di.bean.factory.TaxFormulaFactory.java

package com.yulikexuan.spring.core.di.bean.factory;


import java.util.Objects;
import java.util.Optional;


class TaxFormulaFactory {

    Optional<TaxFormula> getTaxFormula(TaxPlanCode tpc) {

        if (Objects.isNull(tpc)) {
            return Optional.empty();
        }

        return Optional.ofNullable(tpc.createTaxFormula());
    }

}///:~