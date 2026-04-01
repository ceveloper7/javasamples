package org.ceva.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.ceva.processors", "org.ceva.repositories", "org.ceva.services"})
public class ProjectConfig {
}
