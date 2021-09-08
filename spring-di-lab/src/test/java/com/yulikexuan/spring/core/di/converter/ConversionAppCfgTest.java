//: com.yulikexuan.spring.core.di.converter.ConversionAppCfgTest.java

package com.yulikexuan.spring.core.di.converter;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ConversionServiceFactoryBean;

import java.time.LocalDate;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@DisplayName("Test ConversionAppCfg - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ConversionAppCfgTest {

    private static ConfigurableApplicationContext appCtx;

    @BeforeAll
    static void beforeAll() {
        appCtx = new AnnotationConfigApplicationContext(ConversionAppCfg.class);
        appCtx.registerShutdownHook();
        log.info(">>>>>>> App Context Initialized. Initialization done.");
    }

    @AfterAll
    static void afterAll() {
        if (Objects.nonNull(appCtx)) {
            appCtx.close();
        }
        log.info(">>>>>>> App Context Closed. Usage done.");
    }

    @Test
    void the_ConversionService_Should_Be_Singleton() {
        assertThat(appCtx.getBean(ConversionServiceFactoryBean.class)
                .isSingleton()).isTrue();
    }

    @Test
    void able_To_Create_A_PersonBean() {

        // Given
        Creature personBean = appCtx.getBean(Creature.class);

        // When
        String personName = personBean.getName();

        LocalDate birthDay = personBean.getBirthDate();

        // Then
        assertThat(personName).isEqualTo("John Mayer");
        assertThat(birthDay.getYear()).isEqualTo(1977);
        assertThat(birthDay.getMonthValue()).isEqualTo(10);
        assertThat(birthDay.getDayOfMonth()).isEqualTo(17);
    }

    @Test
    void validate_Scalar_Value_Injection() {

        // Given
        MultipleTypesBean multipleTypesBean = appCtx.getBean(
                MultipleTypesBean.class);

        // When
        int noOne = multipleTypesBean.getNoOne();
        boolean boolOne = multipleTypesBean.isBoolOne();
        Boolean boolTwo = multipleTypesBean.getBoolTwo();
        LocalDate date = multipleTypesBean.getDate();

        // Then
        assertThat(noOne).isEqualTo(27);
        assertThat(boolOne).isTrue();
        assertThat(boolTwo).isFalse();
        assertThat(date.getYear()).isEqualTo(1977);
        assertThat(date.getMonthValue()).isEqualTo(10);
        assertThat(date.getDayOfMonth()).isEqualTo(16);
    }

}///:~