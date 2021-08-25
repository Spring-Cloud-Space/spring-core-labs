//: com.yulikexuan.spring.core.di.bean.inheritance.ChildBean.java

package com.yulikexuan.spring.core.di.bean.inheritance;


import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@ToString(callSuper = true)
@Component
class ChildBean extends ParentBean {

    private Boolean adult;

    ChildBean(@Value("Lil' John") String surname, @Value("false") Boolean adult) {
        super(surname);
        this.adult = adult;
    }

}///:~