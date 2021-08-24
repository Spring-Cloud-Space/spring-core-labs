//: com.yulikexuan.spring.core.di.config.YamlPropertySourceFactory.java

package com.yulikexuan.spring.core.di.config;


import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;


public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public org.springframework.core.env.PropertySource<?> createPropertySource(
            String name, EncodedResource encodedResource) throws IOException {

        YamlPropertiesFactoryBean yamlPropertiesFactory =
                new YamlPropertiesFactoryBean();
        Resource resource = encodedResource.getResource();
        yamlPropertiesFactory.setResources(resource);

        Properties properties = yamlPropertiesFactory.getObject();

        return new PropertiesPropertySource(resource.getFilename(), properties);
    }
}