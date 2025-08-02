package com.ceva.records;

import java.util.Map;

public record ABDeveloperRecord(String language, int age) {
    public ABDeveloperRecord(Map.Entry<String, Integer> entry){
        this(entry.getKey(), entry.getValue());
    }
}
