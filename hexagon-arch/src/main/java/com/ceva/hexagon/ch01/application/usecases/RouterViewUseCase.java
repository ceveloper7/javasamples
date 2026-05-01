package com.ceva.hexagon.ch01.application.usecases;

import com.ceva.hexagon.ch01.domain.Router;

import java.util.List;
import java.util.function.Predicate;

/**
 * Un caso de uso representa un comportamiento del sistema.
 */
public interface RouterViewUseCase {

    // caso de uso para obtener una lista filtrada de routers
    List<Router> getRouters(Predicate<Router> filter);
}
