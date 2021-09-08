//: com.yulikexuan.spring.core.di.bean.inheritance.ParentBean.java

package com.yulikexuan.spring.core.di.bean.inheritance;


import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;


@Getter
@ToString
class ParentBean {

    @Value("Smith")
    String faimilyName;

    String surname;

    ParentBean(String surname) {
        this.surname = surname;
    }

}///:~