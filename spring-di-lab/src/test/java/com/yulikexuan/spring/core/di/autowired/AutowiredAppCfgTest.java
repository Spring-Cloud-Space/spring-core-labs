//: com.yulikexuan.spring.core.di.autowired.AutowiredAppCfgTest.java

package com.yulikexuan.spring.core.di.autowired;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@ContextConfiguration(classes = {AutowiredAppCfg.class})
@ExtendWith(SpringExtension.class)
@DisplayName("Test Autowired Annotation - ")
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AutowiredAppCfgTest {

    @Autowired
    private JdbcAbstractRepo<Detective> detectiveRepo;

    @Autowired
    private JdbcAbstractRepo<CriminalCase> criminalCaseRepo;

    @Autowired
    private JdbcEvidenceRepo evidenceRepo;

    @Test
    void autowired_Annotation_Can_Inject_Generic_Type_Instances() {
        assertThat(this.detectiveRepo).isNotNull();
        assertThat(this.criminalCaseRepo).isNotNull();
        assertThat(this.evidenceRepo).isNotNull();
    }

}///:~