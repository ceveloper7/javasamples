package com.ceva;

import com.ceva.beans.DiverseValuesContainer;
import com.ceva.beans.ValuesHolder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * JavaBeans PropertyEditors
 */
public class PropertiesEditorDemo {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext();
        ctx.register(DiverseValuesContainer.class, ValuesHolder.class);
        ctx.refresh();

        ctx.close();
    }
}
