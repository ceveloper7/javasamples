package com.ceva.services;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class FooImplTwo implements Foo{
    public String id = "two:" + UUID.randomUUID().toString().replace("-","").substring(0,8);

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("id", id)
                .toString();
    }
}
