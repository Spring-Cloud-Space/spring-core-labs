//: com.yulikexuan.spring.core.di.bean.lifecycle.ComplicatedBean.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;


@Slf4j
@Getter
@ToString
class ComplicatedBean {

    private AutoCloseable resource;

    ComplicatedBean() {
        log.info(">>>>>>> Constructing the ComplicatedBean ...");
    }

    @PostConstruct
    private void setBeanMonitor() {
        log.info(">>>>>>> Calling the @PostConstruct annotated method ...");
    }

    private void initialize() {
        log.info(">>>>>>> Initializing the resource of the ComplicatedBean ... ");
        this.resource = () -> log.info(">>>>>>> Closing the resource of ComplicatedBean ... ");
    }

    private void releaseResource() throws Exception {
        log.info(">>>>>>> Releasing resource before destroy the ComplicatedBean ... ");
        resource.close();
    }

}///:~