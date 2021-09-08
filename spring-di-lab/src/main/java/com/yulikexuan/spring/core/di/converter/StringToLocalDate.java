//: com.yulikexuan.spring.core.di.converter.StringToLocalDate.java

package com.yulikexuan.spring.core.di.converter;


import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class StringToLocalDate implements Converter<String, LocalDate> {

    private DateTimeFormatter dateTimeFormatter;

    private StringToLocalDate(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    static StringToLocalDate of(@NonNull DateTimeFormatter dateTimeFormatter) {
        return new StringToLocalDate(dateTimeFormatter);
    }

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, dateTimeFormatter);
    }

}///:~