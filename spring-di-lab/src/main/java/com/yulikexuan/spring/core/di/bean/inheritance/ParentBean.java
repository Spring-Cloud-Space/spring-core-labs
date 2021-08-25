//: com.yulikexuan.spring.core.di.bean.inheritance.ParentBean.java

package com.yulikexuan.spring.core.di.bean.inheritance;


import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@ToString
@Component
class ParentBean {

    @Value("Smith")
    String faimilyName;

    String surname;

    ParentBean(@Value("John") String surname) {
        this.surname = surname;
    }

}///:~