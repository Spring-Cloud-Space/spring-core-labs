//: com.yulikexuan.spring.core.di.collection.SimpleElement.java

package com.yulikexuan.spring.core.di.collection;


import java.util.Objects;
import java.util.UUID;


record SimpleElement(UUID uuid) implements Element {

    SimpleElement {
        Objects.requireNonNull(uuid);
    }

    static SimpleElement of(UUID uuid) {
        return new SimpleElement(uuid);
    }

    @Override
    public UUID getId() {
        return null;
    }

}///:~