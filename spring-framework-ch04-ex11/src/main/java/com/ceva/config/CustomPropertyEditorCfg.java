package com.ceva.config;

import com.ceva.bean.NamePropertyEditor;
import com.ceva.model.FullName;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.ceva.bean"})
public class CustomPropertyEditorCfg {
    @Bean
    CustomEditorConfigurer customEditorConfigurer(){
        var cust = new CustomEditorConfigurer();
        cust.setCustomEditors(Map.of(FullName.class, NamePropertyEditor.class));
        return cust;
    }
}
