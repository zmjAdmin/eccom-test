package com.eccom.starter.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "com.eccom.opensource")
@PropertySource({"classpath:resource.properties"})
@Data
public class Resources {

    // @Value("${com.eccom.opensource.name}")
    private String name;

    // @Value("${com.eccom.opensource.website}")
    private String website;

    // @Value("${com.eccom.opensource.language}")
    private String language;

}
