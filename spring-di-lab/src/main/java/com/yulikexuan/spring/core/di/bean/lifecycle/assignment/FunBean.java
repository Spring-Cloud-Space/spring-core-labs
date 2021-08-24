//: com.yulikexuan.spring.core.di.bean.lifecycle.assignment.FunBean.java

package com.yulikexuan.spring.core.di.bean.lifecycle.assignment;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;


@Slf4j
record FunBean(IResource depBean) implements InitializingBean, DisposableBean {

    FunBean {
        log.info(">>>>>>> Stage 1.: Calling constructor of the FunBean ... ");
        Objects.requireNonNull(depBean);
    }

    @PostConstruct
    private void initializeAfterConstructor() {
        log.info(">>>>>>> Stage 2.: Calling @PostConstruct method ... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(">>>>>>> Stage 3.: Calling " +
                "InitializingBean::afterPropertiesSet method ... ");
    }

    private void initializeResource() {
        log.info(">>>>>>> Stage 4.: Calling @Bean::initMethod");
        this.depBean.initialize();
    }

    @PreDestroy
    private void cleanUpBeforeDestroy() {
        log.info(">>>>>>> Stage 5.: Calling @PreDestroy method ... ");
    }

    @Override
    public void destroy() throws Exception {
        log.info(">>>>>>> Stage 6.: Calling DisposableBean::destroy method ... ");
    }

    private void closeResource() throws Exception {
        log.info(">>>>>>> Stage 7.: Calling @Bean::destroyMethod");
        this.depBean.close();
    }

}///:~