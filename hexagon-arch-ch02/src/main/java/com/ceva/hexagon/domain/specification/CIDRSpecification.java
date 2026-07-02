package com.ceva.hexagon.domain.specification;

/**
 * this code is converted to corresponding specification
 * if(cidr < MINIMUN_ALLOWED_CIDR)
 *      throw new IllegalArgumentException("CIDR is below " + MINIMUN_ALLOWED_CIDR)
 */
public class CIDRSpecification extends AbstractSpecification<Integer>{

    public static final int MINIMUN_ALLOWED_CIDR = 8;

    @Override
    public boolean isSatisfiedBy(Integer cidr) {
        return cidr > MINIMUN_ALLOWED_CIDR;
    }
}
