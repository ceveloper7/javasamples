package com.ceva.hexagon.domain.entity;

import com.ceva.hexagon.domain.valueobjects.IP;
import com.ceva.hexagon.domain.valueobjects.Network;
import com.ceva.hexagon.domain.valueobjects.RouterId;
import com.ceva.hexagon.domain.valueobjects.RouterType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Router {

    // continuidad
    private final RouterType routerType;
    // identidad
    private final RouterId routerId;
    private Switch networkSwitch;

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

    // router type check incrustado en la entidad
    public static Predicate<Router> filterRouterByType(RouterType routerType){
        return routerType.equals(RouterType.CORE) ? isCore() : isEdge();
    }
    // end constraint method

    public void addNetworkToSwitch(Network network){
        this.networkSwitch = networkSwitch.addNetwork(network, this);
    }

    public Network createNetwork(IP address, String name, int cidr){
        return new Network(address, name, cidr);
    }

    public List<Network> retrieveNetworks(){
        return networkSwitch.getNetworks();
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
