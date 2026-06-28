package com.ceva.hexagon.domain.service;

import com.ceva.hexagon.domain.entity.Router;
import com.ceva.hexagon.domain.valueobjects.IP;
import com.ceva.hexagon.domain.valueobjects.Network;

/**
 * Delegamos NetworkOperation al domain service la responsabilidad de tratar con las tareas que no
 * encajan con entidades o value objects
 */
public class NetworkOperation {

    private final int MINIMUN_ALLOWED_CIDR = 8;

    /**
     * Metodo responsable para crear un nuevo Network Object y agregarlo a Switch que
     * esta linked a un Router
     * Restricciones:
     * Verificar si el minimo CIDR (class Inter-Domain Routing) no ha sido violado
     * Verificar si el Network address ya ha sido utilizado en algun Network object
     */
    public void createNewNetwork(Router router, IP address, String name, int cidr){
        if(cidr < MINIMUN_ALLOWED_CIDR)
            throw new IllegalArgumentException("CIDR is below " + MINIMUN_ALLOWED_CIDR);
        if(isNetworkAvailable(router, address, cidr))
            throw new IllegalArgumentException("Address already exist");

        Network network = router.createNetwork(address, name, cidr);
        router.addNetworkToSwitch(network);
    }

    private boolean isNetworkAvailable(Router router, IP address, int cidr){
        var availability = false;
        for(Network network : router.retrieveNetworks()){
            if (network.address().equals(address) && network.cidr() == cidr){
                availability = true;
                break;
            }
        }
        return availability;
    }
}
