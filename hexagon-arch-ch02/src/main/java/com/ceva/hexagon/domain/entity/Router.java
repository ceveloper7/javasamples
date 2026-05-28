package com.ceva.hexagon.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Router {

    // continuidad
    private final RouterType routerType;
    // identidad
    private final RouterId routerId;

    public Router(RouterType routerType, RouterId routerId){
        this.routerType = routerType;
        this.routerId = routerId;
    }

    public RouterType getRouterType(){
        return routerType;
    }

    // constraint methods
    private static Predicate<Router> isCore(){
        return p -> p.getRouterType() == RouterType.CORE;
    }

    private static Predicate<Router> isEdge(){
        return p -> p.getRouterType() == RouterType.EDGE;
    }

    // router type check embebido en la entidad
    public static Predicate<Router> filterRouterByType(RouterType routerType){
        return routerType.equals(RouterType.CORE) ? isCore() : isEdge();
    }
    // end constraint method



    public static List<Router> checkRouter(RouterType routerType, List<Router> routes){
        var routerList = new ArrayList<Router>();
        routes.forEach((router -> {
            if (router.routerType == routerType)
                routerList.add(router);
        }));
        return  routerList;
    }

    @Override
    public String toString(){
        return "Router{" +
                "routerType=" + routerType +
                ", routerId=" + routerId +
                '}';
    }
}
