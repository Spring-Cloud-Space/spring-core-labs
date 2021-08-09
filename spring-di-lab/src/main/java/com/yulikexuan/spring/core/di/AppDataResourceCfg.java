//: com.yulikexuan.spring.core.di.AppDataResourceCfg.java

package com.yulikexuan.spring.core.di;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.UUID;


@Slf4j
@Configuration
@PropertySource(
        value = "classpath:data/datasource.yml",
        factory = AppDataResourceCfg.YamlPropertySourceFactory.class)
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

    static class YamlPropertySourceFactory implements PropertySourceFactory {

        @Override
        public org.springframework.core.env.PropertySource<?> createPropertySource(
                String name, EncodedResource encodedResource) throws IOException {

            YamlPropertiesFactoryBean yamlPropertiesFactory =
                    new YamlPropertiesFactoryBean();
            Resource resource = encodedResource.getResource();
            yamlPropertiesFactory.setResources(resource);

            Properties properties = yamlPropertiesFactory.getObject();

            return new PropertiesPropertySource(resource.getFilename(), properties);
        }
    }

}///:~