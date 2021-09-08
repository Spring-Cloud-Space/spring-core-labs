//: com.yulikexuan.spring.core.di.converter.Creature.java

package com.yulikexuan.spring.core.di.converter;


import java.time.LocalDate;


interface Creature {

    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    String getName();

    void setName(String name);

}///:~