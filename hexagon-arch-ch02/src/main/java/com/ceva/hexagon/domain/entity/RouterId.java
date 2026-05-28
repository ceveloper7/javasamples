package com.ceva.hexagon.domain.entity;


import java.util.UUID;

public class RouterId {
    private final UUID id;

    public RouterId(UUID id){
        this.id = id;
    }

    public static RouterId withId(String id){
        return new RouterId(UUID.fromString(id));
    }

    public static RouterId withoutId(String id){
        return new RouterId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "RouterId{" +
                "id='" + id + '\'' +
                '}';
    }
}
