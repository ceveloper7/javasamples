package com.ceva.ch03;

import com.ceva.model.Apple;

import java.io.IOException;

public interface AppleBooleanPredicate {
    boolean test(Apple apple) throws IOException;
}
