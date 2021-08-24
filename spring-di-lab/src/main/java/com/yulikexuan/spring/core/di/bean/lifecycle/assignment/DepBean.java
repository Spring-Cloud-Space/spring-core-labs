//: com.yulikexuan.spring.core.di.bean.lifecycle.assignment.DepBean.java

package com.yulikexuan.spring.core.di.bean.lifecycle.assignment;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@NoArgsConstructor
class DepBean implements IResource {

    @Override
    public void initialize() {
        log.info(">>>>>>> Initializing resource ...");
    }

    @Override
    public void close() {
        log.info(">>>>>>> Closing resource ... ");
    }

}///:~