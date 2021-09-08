//: com.yulikexuan.spring.core.di.converter.ConversionAppCfg.java

package com.yulikexuan.spring.core.di.converter;


import com.yulikexuan.spring.core.di.config.YamlPropertySourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;


@Slf4j
@Configuration
@PropertySource(
        value = "classpath:data/datasource.yml",
        factory = YamlPropertySourceFactory.class)
class ConversionAppCfg {

    static final String SIMPLE_DATE_FORMATTER_PATTERN = "yyyy-MM-dd";

    @Bean
    ConversionService conversionService(ConversionServiceFactoryBean factory) {

        return factory.getObject();
    }

    @Bean
    ConversionServiceFactoryBean conversionServiceFactoryBean(
            Converter<String, LocalDate> stringToLocalDateConverter) {

        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        factory.setConverters(Set.of(stringToLocalDateConverter));

        return factory;
    }

    @Bean
    DateTimeFormatter dateTimeFormatter() {
        return DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMATTER_PATTERN);
    }

    @Bean
    Converter<String, LocalDate> stringToLocalDateConverter(
            DateTimeFormatter dateTimeFormatter) {

        return StringToLocalDate.of(dateTimeFormatter);
    }

    @Bean
    Creature personBean(@Value("${spring.core.di.scalars.birthDate}")
                                LocalDate birthDate,
                        @Value("${spring.core.di.scalars.personName}")
                                String name) {

        log.info(">>>>>>> The birthDate param is {}", birthDate.toString());
        return PersonBean.of(birthDate, name);
    }

    @Bean
    MultipleTypesBean multipleTypesBean() {
        return new MultipleTypesBean();
    }

}///:~