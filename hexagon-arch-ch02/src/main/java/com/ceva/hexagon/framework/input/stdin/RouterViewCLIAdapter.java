package com.ceva.hexagon.framework.input.stdin;

import com.ceva.hexagon.application.ports.input.RouterViewInputPort;
import com.ceva.hexagon.application.usecases.RouterViewUseCase;
import com.ceva.hexagon.domain.entity.Router;
import com.ceva.hexagon.domain.valueobjects.RouterType;
import com.ceva.hexagon.framework.output.file.RouterViewFileAdapter;

import java.util.List;

/**
 * Input Adapter: Obtiene datos  Standard Input (STDIN)
 * Si queremos activar otras formas de comunicacion en el sistema como RestFul solo tenemos que crear
 * un nuevo adapter Rest
 */
public class RouterViewCLIAdapter {

    private RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter(){
        setAdapters();
    }

    private void setAdapters(){
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }

    public List<Router> obtainRelatedRouters(String type){
        return routerViewUseCase.getRouters(Router.filterRouterByType(RouterType.valueOf(type)));
    }
}
