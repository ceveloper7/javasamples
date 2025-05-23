package org.ceva.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ceva.repositories", "com.ceva.services"})
public class ProjectConfig {
}
