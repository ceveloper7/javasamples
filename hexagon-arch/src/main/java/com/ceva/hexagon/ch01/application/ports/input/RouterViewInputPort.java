package com.ceva.hexagon.ch01.application.ports.input;

import com.ceva.hexagon.ch01.application.ports.output.RouterViewOutputPort;
import com.ceva.hexagon.ch01.application.usecases.RouterViewUseCase;
import com.ceva.hexagon.ch01.domain.Router;

import java.util.List;
import java.util.function.Predicate;

/**
 * Los input ports son las implementaciones de los casos de uso
 */
public class RouterViewInputPort implements RouterViewUseCase {

    private RouterViewOutputPort routerListOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerListOutputPort){
        this.routerListOutputPort = routerListOutputPort;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerListOutputPort.fetchRouters();
        return Router.retrieveRouter(routers, filter);
    }
}
