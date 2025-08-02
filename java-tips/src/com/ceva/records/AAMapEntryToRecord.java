package com.ceva.records;

import java.util.Map;

/**
 * Converting an Map.Entry to Record
 */
public class AAMapEntryToRecord {
    public static void main(String[] args) {
        var developers = Map.of(
                "java", 25,
                "javascript", 24,
                "ruby", 30
        );

        developers.entrySet().stream()
                .map(ABDeveloperRecord::new)
                .forEach(System.out::println);
    }
}
