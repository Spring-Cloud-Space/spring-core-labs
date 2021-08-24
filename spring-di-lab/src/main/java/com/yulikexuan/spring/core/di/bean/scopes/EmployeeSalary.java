//: com.yulikexuan.spring.core.di.bean.scopes.EmployeeSalary.java

package com.yulikexuan.spring.core.di.bean.scopes;


import lombok.extern.slf4j.Slf4j;


@Slf4j
record EmployeeSalary(int amount) implements Salary {

    EmployeeSalary {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        log.info(">>>>>>> Creating a new Salary Bean ... ");
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

}///:~