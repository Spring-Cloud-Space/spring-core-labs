//: com.yulikexuan.spring.core.di.autowired.JdbcAbstractRepo.java

package com.yulikexuan.spring.core.di.autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.sql.DataSource;


@Getter
@AllArgsConstructor
class JdbcAbstractRepo<T> {

    private final DataSource dataSource;

}///:~