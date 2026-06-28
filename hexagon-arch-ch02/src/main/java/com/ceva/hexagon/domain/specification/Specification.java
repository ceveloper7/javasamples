package com.ceva.hexagon.domain.specification;

public interface Specification<T> {
    // la implementacion de este metodo permite definir predicados
    boolean isSatisfiedBy(T t);
    Specification<T> and(Specification<T> specification);
}
