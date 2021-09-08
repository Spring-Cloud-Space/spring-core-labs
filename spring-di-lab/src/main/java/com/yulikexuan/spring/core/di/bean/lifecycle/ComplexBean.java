//: com.yulikexuan.spring.core.di.bean.lifecycle.ComplexBean.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Objects;


@Slf4j
@RequiredArgsConstructor
class ComplexBean implements Bean, InitializingBean, DisposableBean {

    private final BeanElement beanElement;

    private BeanMonitor beanMonitor;

    @Override
    public BeanElement getBeanElement() {
        return this.beanElement;
    }

    @Override
    public boolean hasBeanMonitor() {
        return Objects.nonNull(this.beanMonitor);
    }

    @PostConstruct
    private void setBeanMonitor() {
        log.info(">>>>>>> Calling the @PostConstruct annotated method ...");
        this.beanMonitor = new BeanMonitor();
        this.beanMonitor.logBean(this);
    }

    @PreDestroy
    private void releaseResources() {
        log.info(">>>>>>> Destroy resource references ...");
        beanMonitor.close();
        beanMonitor = null;
    }

    @Override
    public void destroy() throws Exception {
        log.info(">>>>>>> Calling destroy method of DisposableBean ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(">>>>>>> Calling the afterPrpertiesSet method of InitializingBean ...");
    }

}///:~