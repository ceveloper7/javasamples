package com.ceva.hexagon.domain.specification;

import com.ceva.hexagon.domain.entity.Router;

/**
 * Regla de negocio donde establecemos el maximo de redes permitidas
 */
public class NetworkAmountSpecification extends AbstractSpecification<Router>{

    public static final int MAXIMUN_ALLOWED_NETWORKS = 6;

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.retrieveNetworks().size() <= MAXIMUN_ALLOWED_NETWORKS;
    }
}
