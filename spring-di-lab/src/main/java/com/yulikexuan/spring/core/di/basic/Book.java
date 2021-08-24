//: com.yulikexuan.spring.core.di.basic.Book.java

package com.yulikexuan.spring.core.di.basic;


import java.util.Objects;


public record Book(String title) implements Item {

    public Book {
        Objects.requireNonNull(title);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

}///:~