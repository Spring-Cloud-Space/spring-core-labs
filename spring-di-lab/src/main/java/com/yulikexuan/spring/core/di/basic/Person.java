//: com.yulikexuan.spring.core.di.basic.Person.java

package com.yulikexuan.spring.core.di.basic;


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