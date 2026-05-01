package com.ceva.hexagon.ch01.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Router {

    private final RouterType routerType;
    private final RouterId routerId;

    public Router(RouterType routerType, RouterId routerId){
        this.routerType = routerType;
        this.routerId = routerId;
    }

    public RouterType getRouterType(){
        return routerType;
    }

    private static Predicate<Router> isCore(){
        return p -> p.getRouterType() == RouterType.CORE;
    }

    private static Predicate<Router> isEdge(){
        return p -> p.getRouterType() == RouterType.EDGE;
    }

    public static Predicate<Router> filterRouterByType(RouterType routerType){
        return routerType.equals(RouterType.CORE) ? isCore() : isEdge();
    }

    public static List<Router> retrieveRouter(List<Router> routers, Predicate<Router> predicate){
        return routers.stream()
                .filter(predicate)
                .collect(Collectors.<Router>toList());
    }

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
