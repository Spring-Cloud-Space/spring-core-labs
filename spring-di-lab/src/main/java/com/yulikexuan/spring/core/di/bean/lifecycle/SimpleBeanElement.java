//: com.yulikexuan.spring.core.di.bean.lifecycle.SimpleBeanElement.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import lombok.RequiredArgsConstructor;
import lombok.ToString;


@ToString
@RequiredArgsConstructor
class SimpleBeanElement implements BeanElement {

    private final String id;

    @Override
    public String getId() {
        return this.id;
    }

}///:~