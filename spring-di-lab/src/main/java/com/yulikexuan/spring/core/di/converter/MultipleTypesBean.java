//: com.yulikexuan.spring.core.di.converter.MultipleTypesBean.java

package com.yulikexuan.spring.core.di.converter;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;


@Getter
@ToString
@NoArgsConstructor
class MultipleTypesBean {

    private int noOne;
    private Integer noTwo;
    private long longOne;
    private Long longTwo;
    private float floatOne;
    private Float floatTwo;
    private double doubleOne;
    private Double doubleTwo;
    private boolean boolOne;
    private Boolean boolTwo;
    private char charOne;
    private Character charTwo;
    private LocalDate date;

    @Autowired
    void setNoOne(@Value("${spring.core.di.scalars.noOne}") int noOne) {
        this.noOne = noOne;
    }

    @Autowired
    void setNoTwo(@Value("2")Integer noTwo) {
        this.noTwo = noTwo;
    }

    @Autowired
    void setFloatOne(@Value("5.0")float floatOne) {
        this.floatOne = floatOne;
    }

    @Autowired
    void setFloatTwo(@Value("6.0")Float floatTwo) {
        this.floatTwo = floatTwo;
    }

    @Autowired
    void setDoubleOne(@Value("7.0")double doubleOne) {
        this.doubleOne = doubleOne;
    }

    @Autowired
    void setDoubleTwo(@Value("8.0")Double doubleTwo) {
        this.doubleTwo = doubleTwo;
    }

    @Autowired
    void setLongOne(@Value("3")long longOne) {
        this.longOne = longOne;
    }

    @Autowired
    void setLongTwo(@Value("4")Long longTwo) {
        this.longTwo = longTwo;
    }

    @Autowired
    void setBoolOne(@Value("true")boolean boolOne) {
        this.boolOne = boolOne;
    }

    @Autowired
    void setBoolTwo(@Value("false")Boolean boolTwo) {
        this.boolTwo = boolTwo;
    }

    @Autowired
    void setCharOne(@Value("1")char charOne) {
        this.charOne = charOne;
    }

    @Autowired
    void setCharTwo(@Value("A")Character charTwo) {
        this.charTwo = charTwo;
    }

    @Autowired
    void setDate(@Value("1977-10-16") LocalDate date) {
        this.date = date;
    }

}///:~