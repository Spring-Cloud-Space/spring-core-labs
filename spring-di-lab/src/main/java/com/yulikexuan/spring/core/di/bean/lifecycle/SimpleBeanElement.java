//: com.yulikexuan.spring.core.di.bean.lifecycle.SimpleBeanElement.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@ToString
@Component
class SimpleBeanElement implements  BeanElement {

    private String id;

    SimpleBeanElement(
            @Value("${spring.core.di.lifecycle.defaultBeanElementId}")
                    String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

}///:~