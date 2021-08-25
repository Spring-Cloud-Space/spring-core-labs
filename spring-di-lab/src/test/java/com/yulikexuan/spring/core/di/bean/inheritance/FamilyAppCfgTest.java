//: com.yulikexuan.spring.core.di.bean.inheritance.FamilyAppCfgTest.java

package com.yulikexuan.spring.core.di.bean.inheritance;


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
@DisplayName("Test the App Context of FamilyAppCfg - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FamilyAppCfgTest {

    private static ConfigurableApplicationContext familyAppCtx;

    @BeforeAll
    static void beforeAll() {
        familyAppCtx = new AnnotationConfigApplicationContext(FamilyAppCfg.class);
    }

    @AfterAll
    static void afterAll() {
        if (Objects.nonNull(familyAppCtx)) {
            familyAppCtx.close();
        }
    }

    @Test
    void given_App_Context_Then_Have_A_Family_Of_Beans_Settle_Down() {

        // Given
        ParentBean parentBean = familyAppCtx.getBean(
                "parentBean", ParentBean.class);

        ChildBean childBean = familyAppCtx.getBean(
                "childBean", ChildBean.class);

        // When
        String parentBeanFamilyName = parentBean.getFaimilyName();
        String childBeanFamilyName = childBean.getFaimilyName();

        String parentBeanSurname = parentBean.getSurname();
        String childBeanSurname = childBean.getSurname();

        // Then
        assertThat(parentBean).isNotNull();
        assertThat(childBean).isNotNull();
        assertThat(childBeanFamilyName).isEqualTo(parentBeanFamilyName);
        assertThat(childBeanSurname).isNotEqualTo(parentBeanSurname);

        log.info(">>>>>>> The parentBean is {}", parentBean);
        log.info(">>>>>>> The childBean is {}", childBean);
    }

}///:~