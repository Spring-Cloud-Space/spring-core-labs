//: com.yulikexuan.spring.core.di.bean.lifecycle.ComplicatedAppCfgTest.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@DisplayName("Test ComplicatedAppCfgTest - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ComplicatedAppCfgTest {

    private static ConfigurableApplicationContext appCtx;

    @BeforeAll
    static void beforeAll() {
        appCtx = new AnnotationConfigApplicationContext(ComplicatedAppCfg.class);
        log.info(">>>>>>> The app context for ComplicatedBean initialized.");
    }

    @AfterAll
    static void afterAll() {
        if (Objects.nonNull(appCtx)) {
            appCtx.close();
        }
        log.info(">>>>>>> The app context for ComplicatedBean closed.");
    }

    @Test
    void given_ComplicatedBean_Then_Know_Its_Id() {

        // Given
        log.info(">>>>>>> Start using the app context of the ComplicatedBean");
        ComplicatedBean cb = appCtx.getBean(ComplicatedBean.class);

        // When
        AutoCloseable resource = cb.getResource();

        // Then
        assertThat(resource).isNotNull();
        log.info(">>>>>>> End of using the app context of the ComplicatedBean");
    }

}///:~