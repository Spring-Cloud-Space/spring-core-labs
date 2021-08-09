open module com.yulikexuan.spring.core.di {

    exports com.yulikexuan.spring.core.di;

    requires java.validation;
    requires java.annotation;

    requires lombok;
    requires org.slf4j;

    requires spring.core;
    requires spring.beans;
    requires spring.context;

}