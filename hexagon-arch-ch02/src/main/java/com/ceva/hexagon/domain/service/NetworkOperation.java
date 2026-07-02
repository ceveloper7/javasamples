package com.ceva.hexagon.domain.service;

import com.ceva.hexagon.domain.entity.Router;
import com.ceva.hexagon.domain.specification.CIDRSpecification;
import com.ceva.hexagon.domain.valueobjects.IP;
import com.ceva.hexagon.domain.valueobjects.Network;

/**
 * Delegamos NetworkOperation al domain service la responsabilidad de tratar con las tareas que no
 * encajan con entidades o value objects
 */
public class NetworkOperation {

    /**
     * Metodo responsable para crear un nuevo Network Object y agregarlo a Switch que
     * esta linked a un Router
     * Restricciones:
     * Verificar si el minimo CIDR (class Inter-Domain Routing) no ha sido violado
     * Verificar si el Network address ya ha sido utilizado en algun Network object
     */
    public void createNewNetwork(Router router, IP address, String name, int cidr){

        var cidrSpec = new CIDRSpecification();
        // business rule 1: Limits the minimum CIDR allowed for the creation of new network
        if(cidrSpec.isSatisfiedBy(cidr))
            throw new IllegalArgumentException("CIDR is below " + CIDRSpecification.MINIMUN_ALLOWED_CIDR);

        // business rule 2: Verify if the network address is not already used
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
