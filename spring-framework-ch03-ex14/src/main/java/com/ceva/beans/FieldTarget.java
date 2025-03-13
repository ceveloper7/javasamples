package com.ceva.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FieldTarget {

    @Autowired
    @Qualifier("foo")
    public Foo fooOne;

    @Autowired
    @Qualifier("anotherFoo")
    public Foo fooTwo;

    @Autowired
    public Bar bar;
}
