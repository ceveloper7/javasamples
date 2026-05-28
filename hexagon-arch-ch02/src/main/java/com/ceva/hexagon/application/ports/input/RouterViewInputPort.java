package com.ceva.hexagon.application.ports.input;

import com.ceva.hexagon.application.ports.output.RouterViewOutputPort;
import com.ceva.hexagon.application.usecases.RouterViewUseCase;
import com.ceva.hexagon.domain.entity.Router;
import com.ceva.hexagon.domain.service.RouterSearch;

import java.util.List;
import java.util.function.Predicate;

/**
 * Los input ports son las implementaciones de los casos de uso.
 * Reciben datos que un output adapter proporciona para que con esos datos
 * realice operaciones.
 */
public class RouterViewInputPort implements RouterViewUseCase {

    private RouterViewOutputPort routerViewOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerViewOutputPort){
        this.routerViewOutputPort = routerViewOutputPort;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerViewOutputPort.fetchRouters();
        return RouterSearch.retrieveRouter(routers, filter);
    }
}
