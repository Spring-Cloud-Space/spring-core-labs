//: com.yulikexuan.spring.core.di.bean.factory.FactoryBeanAppCfgTest.java

package com.yulikexuan.spring.core.di.bean.factory;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Test FactoryBean - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FactoryBeanAppCfgTest {

    private static ConfigurableApplicationContext appCtx;

    @BeforeAll
    static void beforeAll() {
        appCtx = new AnnotationConfigApplicationContext(FactoryBeanAppCfg.class);
        appCtx.registerShutdownHook();
    }

    @Test
    void given_Factory_Bean_Then_Can_Create_ScotlandRate_Formula() {

        // Given
        TaxFormula taxFormula = appCtx.getBean("taxFormula",
                TaxFormula.class);

        // When
        String formula = taxFormula.getFormula();

        // Then
        assertThat(formula).isEqualTo("*0.25");
    }

    @Test
    void the_Factory_Bean_Is_Able_To_Create_Single_TaxFormular() throws Exception {

        // Given
        TaxFormula taxFormula_1 = appCtx.getBean("taxFormula",
                TaxFormula.class);

        FactoryBean<TaxFormula> factory = appCtx.getBean(FactoryBean.class);

        TaxFormula taxFormula_2 = factory.getObject();

        // When & Then
        assertThat(taxFormula_1).isSameAs(taxFormula_2);
    }

}///:~