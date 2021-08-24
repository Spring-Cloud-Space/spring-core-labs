//: com.yulikexuan.spring.core.di.bean.scopes.ProxyModeBeansCfgTest.java

package com.yulikexuan.spring.core.di.bean.scopes;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@DisplayName("Test ProxyModeBeansCfg - ")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProxyModeBeansCfgTest {

    private static ConfigurableApplicationContext proxyModeAppCfg;

    @BeforeAll
    static void beforeAll() {
        proxyModeAppCfg = new AnnotationConfigApplicationContext(
                ProxyModeBeansCfg.class);
        proxyModeAppCfg.registerShutdownHook();
        log.info(">>>>>>> App Context Initialized. Initialization done.");
    }

    @AfterAll
    static void afterAll() {
        if (Objects.nonNull(proxyModeAppCfg)) {
            proxyModeAppCfg.close();
        }
        log.info(">>>>>>> App Context Closed. Usage done.");
    }

    @Test
    void having_Default_Theme_Name_For_Any_User() {

        // Given
        UserSettings userSettings = proxyModeAppCfg.getBean(UserSettings.class);

        // When
        String themeName = userSettings.getThemeName();

        // Then
        assertThat(themeName).isEqualTo("light");
    }

    @Test
    void userSettings_Of_ThemeManager_Can_Be_Changed() {

        // Given
        ThemeManager themeManager = proxyModeAppCfg.getBean(ThemeManager.class);
        String sessionId_TM_0 = themeManager.getSessionId();
        String sessionId_TM_1 = themeManager.getSessionId();

        // When
        boolean hasSessionIdChanged = !sessionId_TM_0.equals(sessionId_TM_1);

        // Then
        assertThat(hasSessionIdChanged).isTrue();
    }

    @Test
    void fake_Salary_Always_Give_Different_Salary_Amount() {

        // Given
        Salary fakeSalary = proxyModeAppCfg.getBean(Salary.class);
        Salary anotherFakeSalary = proxyModeAppCfg.getBean(Salary.class);

        // When
        int amount_0 = fakeSalary.getAmount();
        int amount_1 = fakeSalary.getAmount();
        int amount_2 = fakeSalary.getAmount();

        // Then
        assertThat(anotherFakeSalary).isSameAs(fakeSalary);
        assertThat(amount_0).isNotEqualTo(amount_1).isNotEqualTo(amount_2);
    }

    @Test
    void normal_Employee_Has_Different_Salary() {

        // Given
        Employee employee = proxyModeAppCfg.getBean(Employee.class);

        // When
        int salaryAmount_0 = employee.getSalaryAmount();
        int salaryAmount_1 = employee.getSalaryAmount();
        int salaryAmount_2 = employee.getSalaryAmount();

        // Then
        assertThat(salaryAmount_0)
                .isNotEqualTo(salaryAmount_1)
                .isNotEqualTo(salaryAmount_2);
    }

}