//: com.yulikexuan.spring.core.di.autowired.JdbcDetectiveRepo.java

package com.yulikexuan.spring.core.di.autowired;


import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
class JdbcDetectiveRepo
        extends JdbcAbstractRepo<Detective>
        implements DetectiveRepo {

    JdbcDetectiveRepo(DataSource dataSource) {
        super(dataSource);
    }

}///:~