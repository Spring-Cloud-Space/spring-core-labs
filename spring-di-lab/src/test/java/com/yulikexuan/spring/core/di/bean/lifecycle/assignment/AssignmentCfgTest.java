//: com.yulikexuan.spring.core.di.bean.lifecycle.assignment.AssignmentCfgTest.java

package com.yulikexuan.spring.core.di.bean.lifecycle.assignment;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Test AssignmentCfg Class - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AssignmentCfgTest {

    private static ConfigurableApplicationContext assignmentCtx;

    @BeforeAll
    static void beforeAll() {
        assignmentCtx = new AnnotationConfigApplicationContext(AssignmentCfg.class);
    }

    @AfterAll
    static void afterAll() {
        if (Objects.nonNull(assignmentCtx)) {
            assignmentCtx.close();
        }
    }

    @Test
    void funBean_Must_Have_Resource_As_DepBean() {

        // Given
        FunBean funBean = assignmentCtx.getBean(FunBean.class);

        // When
        IResource resource = funBean.depBean();

        // Then
        assertThat(resource).isNotNull();
    }

}///:~