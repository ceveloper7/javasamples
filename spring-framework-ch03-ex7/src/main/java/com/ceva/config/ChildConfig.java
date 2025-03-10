package com.ceva.config;

import com.ceva.model.Song;
import com.ceva.model.TitleProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChildConfig implements ApplicationContextAware {

    public ApplicationContext applicationContext;

    // overrides childProvider bean from ParentConfig
    @Bean
    public TitleProvider childProvider(){
        return TitleProvider.instance("No such Thing");
    }

    /*
     * Al bean song1 se le inyecta la propiedad title (valor Gravity) del bean parentProvider definido en el parent Context (ParentConfig.java)
     */
    @Bean
    public Song song1(@Value("#{parentProvider.title}") String title){
        return new Song(title);
    }

    /*
     * Al bean song2 se le inyecta la propieda title (Daughters) del bean childProvider definido en el parent Context (ParentConfig.java)
     * Tambien existe un bean childProvider en el child context, para acceder al childProvider del parent context, se utiliza un
     * codigo feo.
     *
     */
    @Bean
    public Song song2(@Value("#{childConfig.applicationContext.parent.getBean(\"childProvider\").title}") String title){
        return new Song(title);
    }

    /*
     * Al bean song3 se le inyectar la propiedad title (No such a Thing) del bean llamado childProvider ya que hay un bean llamado
     * childProvider en el contexto actual
     */
    @Bean
    public Song song3(@Value("#{childProvider.title}") String title){
        return new Song(title);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
