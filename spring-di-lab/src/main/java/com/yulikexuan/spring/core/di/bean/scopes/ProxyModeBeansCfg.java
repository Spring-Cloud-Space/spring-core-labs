//: com.yulikexuan.spring.core.di.bean.scopes.ProxyModeBeansCfg.java

package com.yulikexuan.spring.core.di.bean.scopes;


import static org.springframework.beans.factory.config.ConfigurableBeanFactory.*;
import static org.springframework.context.annotation.ScopedProxyMode.*;

import com.yulikexuan.spring.core.di.config.YamlPropertySourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.concurrent.ThreadLocalRandom;


@Slf4j
@Configuration
@PropertySource(
        value = "classpath:web/app.yml",
        factory = YamlPropertySourceFactory.class)
public class ProxyModeBeansCfg {

    @Bean
    ThreadLocalRandom random() {
        return ThreadLocalRandom.current();
    }

    @Bean
    @Scope(value = SCOPE_PROTOTYPE, proxyMode = INTERFACES)
    UserSettings userSettings(@Value("${spring.core.di.scopes.defaultThemeName}")
                                      String themeName) {

        String sessionId = RandomStringUtils.randomAlphanumeric(7);
        return new WebUserSettings(sessionId, themeName);
    }

    @Bean
    ThemeManager themeManager(UserSettings userSettings) {
        WebThemeManager themeManager = new WebThemeManager();
        themeManager.setUserSettings(userSettings);
        return themeManager;
    }

    @Bean
    @SalaryScope(value = SCOPE_PROTOTYPE, proxyMode = INTERFACES)
    Salary salary(ThreadLocalRandom random) {
        int amount = random.nextInt(30_000, 1_000_000);
        return new EmployeeSalary(amount);
    }

    @Bean
    Employee employee(Salary salary) {
        return new NormalEmployee(salary);
    }

}///:~