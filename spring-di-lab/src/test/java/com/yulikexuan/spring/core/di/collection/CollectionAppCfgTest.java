//: com.yulikexuan.spring.core.di.collection.CollectionAppCfgTest.java

package com.yulikexuan.spring.core.di.collection;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@Slf4j
@DisplayName("Test CollectionAppCfg - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CollectionAppCfgTest {

    private static ConfigurableApplicationContext appCtx;

    private EmptyCollectionHolder collectionHolder;
    private List<Element> simpleBeanList;
    private List<Element> anotherBeanList;
    private Set<Element> simpleBeanSet;
    private Map<String, Element> simpleBeanMap;

    private Element singleElement;
    private Element copy_1;
    private Element copy_2;

    @BeforeAll
    static void beforeAll() {
        appCtx = new AnnotationConfigApplicationContext(CollectionAppCfg.class);
        appCtx.registerShutdownHook();
    }

    @AfterAll
    static void afterAll() {
        if (Objects.nonNull(appCtx)) {
            appCtx.close();
        }
    }

    @BeforeEach
    void setUp() {

         this.collectionHolder = appCtx.getBean(
                "collectionHolder", EmptyCollectionHolder.class);

        simpleBeanList = collectionHolder.getSimpleBeanList();
        anotherBeanList = collectionHolder.getSimpleBeanList();
        simpleBeanSet = collectionHolder.getSimpleBeanSet();
        simpleBeanMap = collectionHolder.getSimpleBeanMap();

        singleElement = appCtx.getBean("element", Element.class);

        copy_1 = appCtx.getBean("elementCopy", Element.class);
        copy_2 = appCtx.getBean("elementCopy", Element.class);
    }

    @Test
    void collections_Contain_Not_Only_Singleton_Element_But_Also_Prototypes() {

        // When
        boolean isSingleton = this.singleElement ==
                appCtx.getBean("element", Element.class);

        boolean isPrototype = !(copy_1.equals(copy_2));

        boolean isBeanListSingleton = this.simpleBeanList == this.anotherBeanList;

        // Then
        assertThat(isPrototype).isTrue();
        assertThat(isSingleton).isTrue();
        assertThat(isBeanListSingleton).isTrue();

        assertThat(simpleBeanList).contains(singleElement);
        assertThat(simpleBeanSet).contains(singleElement);
        assertThat(simpleBeanSet.size()).isEqualTo(2);
        assertThat(simpleBeanMap.get("SimpleElement")).isSameAs(singleElement);
        assertThat(simpleBeanMap.get("elementCopy"))
                .isNotEqualTo(singleElement)
                .isNotEqualTo(copy_1)
                .isNotEqualTo(copy_2);
    }

}///:~