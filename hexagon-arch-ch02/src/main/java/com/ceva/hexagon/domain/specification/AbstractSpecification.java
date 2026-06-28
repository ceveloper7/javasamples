package com.ceva.hexagon.domain.specification;

/**
 * Clase abstracta que implementa and method para permitir combinar specifications
 *
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

    public abstract boolean isSatisfiedBy(T t);

    public Specification<T> and(final Specification<T> specification){
        return new AndSpecification<T>(this, specification);
    }
}
