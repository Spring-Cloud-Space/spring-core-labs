//: com.yulikexuan.spring.core.di.basic.DiSimpleBean.java

package com.yulikexuan.spring.core.di.basic;


import java.util.Objects;
import java.util.UUID;


record DiSimpleBean(UUID id, boolean complicated) implements SimpleBean {

    DiSimpleBean {
        Objects.nonNull(id);
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public boolean isComplicated() {
        return this.complicated;
    }

}///:~