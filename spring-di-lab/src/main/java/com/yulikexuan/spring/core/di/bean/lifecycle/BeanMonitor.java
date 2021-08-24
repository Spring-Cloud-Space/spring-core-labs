//: com.yulikexuan.spring.core.di.bean.lifecycle.BeanMonitor.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import lombok.extern.slf4j.Slf4j;


@Slf4j
class BeanMonitor implements AutoCloseable {

    void logBean(Bean bean) {
        log.info(">>>>>>> Monitor Bean: element id is {}", bean.getBeanElement());
    }

    @Override
    public void close() {
        log.info(">>>>>>> Release resources ... ");
    }

}///:~