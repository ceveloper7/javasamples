package com.ceva.two.objects.factorymethods;

import java.util.concurrent.ConcurrentHashMap;

public class LargeCache extends Cache{
    private final ConcurrentHashMap<String, String> map;

    LargeCache(int maxEntries){
        this.map = new ConcurrentHashMap<>(maxEntries);
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
