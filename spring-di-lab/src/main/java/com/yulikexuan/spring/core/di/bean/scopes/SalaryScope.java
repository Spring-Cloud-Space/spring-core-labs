//: com.yulikexuan.spring.core.di.bean.scopes.SalaryScope.java

package com.yulikexuan.spring.core.di.bean.scopes;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public @interface SalaryScope {

    // Equivalent to @AliasFor(annotation = Scope.class, attribute = "value")
    @AliasFor(annotation = Scope.class)
    String value() default "";

    // Equivalent to @AliasFor(annotation = Scope.class, attribute = "scopeName")
    @AliasFor(annotation = Scope.class)
    String scopeName() default "";

    // Equivalent to @AliasFor(annotation = Scope.class, attribute = "proxyMode")
    @AliasFor(annotation = Scope.class)
    ScopedProxyMode proxyMode() default ScopedProxyMode.INTERFACES;

}///:~
