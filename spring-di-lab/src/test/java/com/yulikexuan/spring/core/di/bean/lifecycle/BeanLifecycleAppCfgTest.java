//: com.yulikexuan.spring.core.di.bean.lifecycle.BeanLifecycleAppCfgTest.java

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
@DisplayName("Test App Context Class BeanLifecycleAppCfg - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BeanLifecycleAppCfgTest {

    private static ConfigurableApplicationContext appCtx;

    @BeforeAll
    static void beforeAll() {
        appCtx = new AnnotationConfigApplicationContext(
                BeanLifecycleAppCfg.class);
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
    void test_ComplexBean_Bean_Has_A_Monitor() {

        log.info(">>>>>>> Start to use Beans from the appCtx");

        // Given
        Bean complexBean = appCtx.getBean(Bean.class);

        // When
        boolean hasBeanMonitor = complexBean.hasBeanMonitor();

        // Then
        assertThat(hasBeanMonitor).isTrue();

        log.info(">>>>>>> End of using Beans from the appCtx");
    }

}