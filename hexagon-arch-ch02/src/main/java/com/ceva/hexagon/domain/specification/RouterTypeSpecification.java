package com.ceva.hexagon.domain.specification;

import com.ceva.hexagon.domain.entity.Router;
import com.ceva.hexagon.domain.valueobjects.RouterType;

/**
 * Regla de negocio donde manejamos tipos de router: edge y core
 */
public class RouterTypeSpecification extends AbstractSpecification<Router>{

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.getRouterType().equals(RouterType.EDGE) || router.getRouterType().equals(RouterType.CORE);
    }
}
