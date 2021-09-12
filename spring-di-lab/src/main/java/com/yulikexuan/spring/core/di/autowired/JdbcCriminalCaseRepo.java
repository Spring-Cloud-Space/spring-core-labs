//: com.yulikexuan.spring.core.di.autowired.JdbcCriminalCaseRepo.java

package com.yulikexuan.spring.core.di.autowired;


import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
class JdbcCriminalCaseRepo
        extends JdbcAbstractRepo<CriminalCase>
        implements CriminalCaseRepo {

    JdbcCriminalCaseRepo(DataSource dataSource) {
        super(dataSource);
    }

}///:~