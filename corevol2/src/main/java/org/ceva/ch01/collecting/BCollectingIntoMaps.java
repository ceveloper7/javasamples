package org.ceva.ch01.collecting;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BCollectingIntoMaps {
    public static Stream<Person> getPeople(){
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"),
                new Person(1003, "Mary"));
    }

    public static void main(String[] args) throws IOException {
        // Producimos un mapa key/value
        Map<Integer, String> idToName = getPeople()
                .collect(Collectors.toMap(Person::id, Person::name));
        System.out.println("idToName: " + idToName);

        Map<Integer, Person> idToPerson = getPeople()
                .collect(Collectors.toMap(Person::id, Function.identity()));
        System.out.println("idToPerson: " +  idToPerson);

        // si hay mas de un elemento con la misma clave collector lanzara una excepcion
        idToPerson = getPeople()
                .collect(Collectors.toMap(Person::id, Function.identity(),
                                (existingValue, newValue)-> {throw new IllegalStateException();},
                                TreeMap::new));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

        // contruimos un mapa con cada locale disponible: German as key Deutsch as value
        Map<String, String> languageNames = Locale.availableLocales()
                .collect(Collectors.toMap(
                        Locale::getDisplayLanguage,
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));
        System.out.println("languageNames: " + languageNames);

        // construimos un mapa con todos los lenguajes de un determinado pais
        Map<String, Set<String>> countryLanguageSets = Locale.availableLocales().collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Set.of(l.getDisplayLanguage()),
                        (a, b) ->
                        { // union of a and b
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }));
        System.out.println("countryLanguageSets: " + countryLanguageSets);


        Map<Integer, Person> idToPerson1 = getPeople().collect(
                Collectors.toMap(
                        Person::id,
                        Function.identity(),
                        (existingValue, newValue) -> { throw new
                                IllegalStateException(); },
                        TreeMap::new));
        System.out.println("idToPerson: " + idToPerson1.getClass().getName() + idToPerson1);
    }
}
