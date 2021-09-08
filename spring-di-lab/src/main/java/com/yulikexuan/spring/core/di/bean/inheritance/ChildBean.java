//: com.yulikexuan.spring.core.di.bean.inheritance.ChildBean.java

package com.yulikexuan.spring.core.di.bean.inheritance;


import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;


@Getter
@ToString(callSuper = true)
class ChildBean extends ParentBean {

    private Boolean adult;

    ChildBean(@Value("Lil' John") String surname, @Value("false") Boolean adult) {
        super(surname);
        this.adult = adult;
    }

}///:~