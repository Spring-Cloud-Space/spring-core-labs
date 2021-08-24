//: com.yulikexuan.spring.core.di.basic.AppDataResourceCfg.java

package com.yulikexuan.spring.core.di.basic;


import com.yulikexuan.spring.core.di.config.YamlPropertySourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.UUID;


@Slf4j
@Configuration
@PropertySource(
        value = "classpath:data/datasource.yml",
        factory = YamlPropertySourceFactory.class)
public class AppDataResourceCfg {

    @Bean
    static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    SimpleBean simpleBean(
            @Value("${spring.core.di.simpleBeanId}") String uuidStr,
            @Value("${spring.core.di.simpleBeanIsComplicated}") String isComplicatedStr) {

        return new DiSimpleBean(
                UUID.fromString(uuidStr),
                Boolean.getBoolean(isComplicatedStr));
    }

    @Bean
    Item book(@Value("${spring.core.di.assignment.book.title}") String title) {
        return new Book(title);
    }

    @Bean
    Human person(Item book) {
        return new Person(book);
    }

}///:~