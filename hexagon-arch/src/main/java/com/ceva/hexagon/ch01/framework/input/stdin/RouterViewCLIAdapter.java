package com.ceva.hexagon.ch01.framework.input.stdin;

import com.ceva.hexagon.ch01.application.ports.input.RouterViewInputPort;
import com.ceva.hexagon.ch01.application.usecases.RouterViewUseCase;
import com.ceva.hexagon.ch01.domain.Router;
import com.ceva.hexagon.ch01.domain.RouterType;
import com.ceva.hexagon.ch01.framework.output.file.RouterViewFileAdapter;

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
