package com.ceva.hexagon.ch01.domain;

import java.util.ArrayList;
import java.util.List;

public class Router {

    private final RouterType routerType;
    private final RouterId routerId;

    public Router(RouterType routerType, RouterId routerId){
        this.routerType = routerType;
        this.routerId = routerId;
    }

    public static List<Router> checkRouter(RouterType routerType, List<Router> routes){
        var routerList = new ArrayList<Router>();
        routes.forEach((router -> {
            if (router.routerType == routerType)
                routerList.add(router);
        }));
        return  routerList;
    }
}
