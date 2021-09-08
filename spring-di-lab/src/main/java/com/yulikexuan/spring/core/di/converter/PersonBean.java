//: com.yulikexuan.spring.core.di.converter.PersonBean.java

package com.yulikexuan.spring.core.di.converter;


import lombok.NonNull;

import java.time.LocalDate;


class PersonBean implements Creature {

    private LocalDate birthDate;
    private String name;

    private PersonBean(LocalDate birthDate, String name) {

        this.birthDate = birthDate;
        this.name = name;
    }

    static PersonBean of(@NonNull LocalDate birthDate, @NonNull String name) {
        return new PersonBean(birthDate, name);
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}///:~