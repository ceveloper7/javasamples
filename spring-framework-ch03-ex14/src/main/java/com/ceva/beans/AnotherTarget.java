package com.ceva.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AnotherTarget {
    private static final Logger logger = LoggerFactory.getLogger(AnotherTarget.class);

    public Foo fooOne;
    public Foo fooTwo;
    public Bar bar;

    @Autowired
    public void setFooOne(@Qualifier("foo") Foo fooOne){
        logger.info("--> AnotherTarget#setFooOne(Foo) called");
        this.fooOne = fooOne;
    }

    @Autowired
    public void setFooTwo(@Qualifier("anotherFoo") Foo fooTwo){
        logger.info("--> AnotherTarget#setFooTwo(Foo) called");
        this.fooTwo = fooTwo;
    }

    @Autowired
    public void setBar(Bar bar){
        logger.info("--? AnotherTarget#setBar(Bar) called");
        this.bar = bar;
    }
}
