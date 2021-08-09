//: com.yulikexuan.spring.core.di.Person.java

package com.yulikexuan.spring.core.di;


import java.util.Objects;


public record Person(Item item) implements Human {

    public Person {
        Objects.requireNonNull(item);
    }

    @Override
    public Item getItem() {
        return this.item;
    }

}///:~