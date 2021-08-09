//: com.yulikexuan.spring.core.di.AppDataResourceCfgTest.java

package com.yulikexuan.spring.core.di;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@DisplayName("Test AppDataResourceCfg - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppDataResourceCfgTest {

    private static ConfigurableApplicationContext dataResAppCfg;

    @BeforeAll
    static void beforeAll() {
        dataResAppCfg = new AnnotationConfigApplicationContext(
                AppDataResourceCfg.class);
    }

    @AfterAll
    static void afterAll() {
        if (Objects.nonNull(dataResAppCfg)) {
            dataResAppCfg.close();
        }
    }

    @Test
    void validate_Generated_Beans() {

        // Given & When
        List<String> beanNames = Arrays.stream(
                dataResAppCfg.getBeanDefinitionNames()).toList();

        // Then
        assertThat(beanNames)
                .contains("appDataResourceCfg")
                .contains("propertySourcesPlaceholderConfigurer")
                .contains("simpleBean");
    }

    @Test
    void validate_Properties_Of_SimpleBean() {

        // Given
        SimpleBean simpleBean = dataResAppCfg.getBean(SimpleBean.class);

        // When
        UUID actualId = simpleBean.getId();

        boolean isComplicated = simpleBean.isComplicated();

        // Then
        assertThat(actualId.toString()).isEqualTo(
                "ff1fcd7a-f7b3-11eb-9a03-0242ac130003");
        assertThat(isComplicated).isFalse();
    }

    @Test
    void validate_Properties_Of_Person_And_Book() {

        // Given
        Human person = dataResAppCfg.getBean(Human.class);
        Item book = person.getItem();

        // When
        String title = book.getTitle();

        // Then
        assertThat(title).isEqualTo("Nevermore");
    }

}