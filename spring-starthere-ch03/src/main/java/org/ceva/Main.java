package org.ceva;

import org.ceva.config.ProjectConfigWithQualifier;
import org.ceva.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        //var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//        var context = new AnnotationConfigApplicationContext(OtherProjectConfig.class);
//
//        Person person = context.getBean(Person.class);
//        Parrot parrot = context.getBean(Parrot.class);
//
//        System.out.println("Person's name: " + person.getName());
//        System.out.println("Parrot's name: " + parrot.getName());
//        System.out.println("Person's parrot: " + person.getParrot());

        //var context = new AnnotationConfigApplicationContext(ProjectConfigComponents.class);
        var context = new AnnotationConfigApplicationContext(ProjectConfigWithQualifier.class);
        var persona = context.getBean(Person.class);
        //var persona = context.getBean(PersonAutowiredByConstructor.class);
        //var persona = context.getBean(Persona.class);

        System.out.println("Nombre: " + persona.getName());
        System.out.println("Loro de la persona: " + persona.getParrot());
    }
}