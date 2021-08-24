//: com.yulikexuan.spring.core.di.bean.scopes.NormalEmployee.java

package com.yulikexuan.spring.core.di.bean.scopes;


import lombok.extern.slf4j.Slf4j;

import java.util.Objects;


@Slf4j
record NormalEmployee(Salary salary) implements Employee {

    NormalEmployee {
        Objects.requireNonNull(salary);
    }

    @Override
    public int getSalaryAmount() {
        log.info(">>>>>>> The actual class of salary here is {}",
                this.salary.getClass().getName());
        return this.salary.getAmount();
    }

}///:~