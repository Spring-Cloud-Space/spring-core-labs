//: com.yulikexuan.spring.core.di.bean.lifecycle.BeanLifecycleAppCfg.java

package com.yulikexuan.spring.core.di.bean.lifecycle;


import com.yulikexuan.spring.core.di.config.YamlPropertySourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Slf4j
@Configuration
@ComponentScan("com.yulikexuan.spring.core.di.bean.lifecycle")
@PropertySource(value = "classpath:web/app.yml",
        factory = YamlPropertySourceFactory.class)
public class BeanLifecycleAppCfg {

}///:~