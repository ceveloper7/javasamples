package org.ceva.adam;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class JavaRecordTest {

    @Test
    public void entrySetWithRecords(){
        var developers = Map.of(
                "Java", 25,
                "JavaScript", 24,
                "Ruby",30);

        developers
                // transformamos un mapa un Set
                .entrySet()
                // Transformamos el Set a una secuencia procesable
                .stream()
                // Reacord object que actua como contenedor inmutable de informacion
                .map(Developer::new)
                .forEach(System.out::println);
    }
}
