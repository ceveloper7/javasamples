package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.helpers.KeyHelper;
import com.ceva.services.LockOpener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

/*
 * Lookup method Injection
 * La inyección del method de búsqueda permite que el bean singleton declare que requiere una dependencia no singleton
 * y que recibirá una nueva instancia del bean no singleton cada vez que necesite interactuar con ella.
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var abstractLockOpener = context.getBean("abstractLockOpener", LockOpener.class);
        var standardLockOpener = context.getBean("standardLockOpener", LockOpener.class);

        displayInfo("abstractLockOpener", abstractLockOpener);
        displayInfo("standardLockOpener", standardLockOpener);
    }

    private static void displayInfo(String beanName, LockOpener lockOpener){
        KeyHelper keyHelperOne = lockOpener.getMyKeyOpener();
        KeyHelper keyHelperTwo = lockOpener.getMyKeyOpener();

        System.out.println("[" + beanName + "]: KeyHelper Instance the same? " + (keyHelperOne == keyHelperTwo));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for(int i = 0; i < 100_000; i++){
            KeyHelper keyHelper = lockOpener.getMyKeyOpener();
            keyHelper.open();
        }

        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}