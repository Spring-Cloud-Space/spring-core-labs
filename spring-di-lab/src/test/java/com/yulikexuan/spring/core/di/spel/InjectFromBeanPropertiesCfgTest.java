//: com.yulikexuan.spring.core.di.spel.InjectFromBeanPropertiesCfgTest.java

package com.yulikexuan.spring.core.di.spel;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
@DisplayName("Test Inject values from another Bean - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InjectFromBeanPropertiesCfgTest {

    private static ConfigurableApplicationContext appCtx;

    @BeforeAll
    static void beforeAll() {
        appCtx = new AnnotationConfigApplicationContext(
                InjectFromBeanPropertiesCfg.class);
        appCtx.registerShutdownHook();
    }

    @Test
    void given_Properties_Then_Used_In_DataSource() throws SQLException {

        // Given
        DataSource dataSource = appCtx.getBean("dataSource", DataSource.class);
        String actualDbUrl = null;

        // When
        try (Connection conn = dataSource.getConnection()) {
            conn.getMetaData().getURL();
            actualDbUrl = dataSource.getConnection().getMetaData().getURL();
        }

        // Then
        assertThat(actualDbUrl).isEqualTo("jdbc:h2:~/sample");
    }

}///:~