package org.ceva.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.ceva.proxies", "org.ceva.repositories", "org.ceva.services"})
public class ProjectConfiguration {
}
