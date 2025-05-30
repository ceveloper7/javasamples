package com.ceva.model;

import com.ceva.services.Foo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TrickyTarget {
    private static final Logger logger = LoggerFactory.getLogger(TrickyTarget.class);

    public Foo fooOne;
    public Foo fooTwo;
    public Bar bar;

    public TrickyTarget(){
        logger.info("--> TrickyTarget() called");
    }

    public TrickyTarget(Foo foo){
        this.fooOne = foo;
        logger.info("--> TrickyTarget(Foo) called");
    }

    public TrickyTarget(Foo foo, Bar bar){
        this.fooOne = foo;
        this.bar = bar;
        logger.info("--> TrickyTarget(Foo, Bar) called");
    }

    // comment @Qualifier annotation to cause NoUniqueBeanDefinitionException being thrown at runtime
    @Autowired
    @Qualifier("fooImplOne")
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        logger.info(" --> Property fooOne set");
    }

    // comment @Qualifier annotation to cause NoUniqueBeanDefinitionException being thrown at runtime
    // and make sure for @Primary in FooImpl to be commented as well
    @Autowired
    @Qualifier("fooImplTwo")
    public void setFooTwo(Foo foo) {
        this.fooTwo = foo;
        logger.info(" --> Property fooTwo set");
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        logger.info(" --> Property bar set");
    }
}
