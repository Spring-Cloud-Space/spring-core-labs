//: com.yulikexuan.spring.core.di.autowired.JdbcEvidenceRepo.java

package com.yulikexuan.spring.core.di.autowired;


import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
class JdbcEvidenceRepo extends JdbcAbstractRepo<Evidence> implements EvidenceReop {

    JdbcEvidenceRepo(DataSource dataSource) {
        super(dataSource);
    }

}///:~