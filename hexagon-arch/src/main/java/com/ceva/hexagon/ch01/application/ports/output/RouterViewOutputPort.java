package com.ceva.hexagon.ch01.application.ports.output;

import com.ceva.hexagon.ch01.domain.Router;

import java.util.List;

/**
 * Output ports son interfaces que definen como la aplicacion se comunica con
 * sistemas externos.
 */
public interface RouterViewOutputPort {

    List<Router> fetchRouters();
}
