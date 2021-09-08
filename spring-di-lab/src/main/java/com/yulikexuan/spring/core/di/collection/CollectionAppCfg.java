//: com.yulikexuan.spring.core.di.collection.CollectionAppCfg.java

package com.yulikexuan.spring.core.di.collection;


import static org.springframework.beans.factory.config.ConfigurableBeanFactory.*;
import static org.springframework.context.annotation.ScopedProxyMode.*;

import com.yulikexuan.spring.core.di.config.YamlPropertySourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


@Slf4j
@Configuration
@PropertySource(
        value = "classpath:data/datasource.yml",
        factory = YamlPropertySourceFactory.class)
class CollectionAppCfg {

    @Bean("element")
    Element element() {
        return SimpleElement.of(UUID.randomUUID());
    }

    @Bean("elementCopy")
    @Scope(SCOPE_PROTOTYPE)
    Element elementCopy() {
        return SimpleElement.of(UUID.randomUUID());
    }

    @Bean
    List<Element> simpleBeanList() {
        return List.of(element(), elementCopy());
    }

    @Bean
    Set<Element> simpleBeanSet() {
        return Set.of(element(), elementCopy());
    }

    @Bean
    Map<String, Element> simpleBeanMap() {
        return Map.of(
                "SimpleElement", element(),
                "elementCopy", elementCopy());
    }

    @Bean
    EmptyCollectionHolder collectionHolder() {
        return new EmptyCollectionHolder(simpleBeanList(), simpleBeanSet(),
                simpleBeanMap());
    }

}///:~