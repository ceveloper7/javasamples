package com.ceva.hexagon.application.ports.output;

import com.ceva.hexagon.domain.entity.Router;

import java.util.List;

/**
 * Hexagon Application: Trata con operaciones especificas de la aplicacion.
 * Output ports son interfaces que definen como la aplicacion se comunica con
 * sistemas externos.
 *
 * Un Output Port le dice al sistema que tipos de datos necesita para realizar
 * una tarea especifica de la aplicacion.
 *
 * Un Output Port describe como obtendra los datos
 */
public interface RouterViewOutputPort {

    List<Router> fetchRouters();
}
