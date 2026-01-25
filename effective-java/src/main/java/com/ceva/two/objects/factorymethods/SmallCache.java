package com.ceva.two.objects.factorymethods;

import java.util.HashMap;
import java.util.Map;

public class SmallCache extends Cache{
    private final Map<String, String> map;

    SmallCache(int maxEntries){
        this.map =new HashMap<>(maxEntries);
    }

    @Override
    public void put(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }
}
