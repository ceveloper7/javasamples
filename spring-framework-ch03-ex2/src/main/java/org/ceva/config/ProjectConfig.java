package org.ceva.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration -> esta anotacion nos permite definir una clase que configura una aplicacion stand-alone de Spring
 * @ComponentScan -> cuando se inicie el application context, spring buscara (scan) las clases o componentes en los paquetes indicados
 *                   e instancia los mismos como beans con los nombres indicados.
 */
@Configuration
@ComponentScan(basePackages = {"org.ceva.providers", "org.ceva.renders"})
public class ProjectConfig {
}
