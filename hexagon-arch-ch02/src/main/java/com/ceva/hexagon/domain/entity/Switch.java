package com.ceva.hexagon.domain.entity;

import com.ceva.hexagon.domain.valueobjects.IP;
import com.ceva.hexagon.domain.valueobjects.Network;
import com.ceva.hexagon.domain.valueobjects.SwitchId;
import com.ceva.hexagon.domain.valueobjects.SwitchType;

import java.util.ArrayList;
import java.util.List;

public class Switch {
    private final SwitchType switchType;
    private final SwitchId switchId;
    private List<Network> networks;
    private final IP address;

    public Switch(SwitchType switchType, SwitchId switchId, List<Network> networks, IP address){
        this.switchType = switchType;
        this.switchId = switchId;
        this.networks = networks;
        this.address = address;
    }

    public Switch addNetwork(Network network, Router router) {
        List<Network> newNetworks = new ArrayList<>(router.retrieveNetworks());
        newNetworks.add(network);

        return new Switch(this.switchType, this.switchId, newNetworks, this.address);
    }

    public List<Network> getNetworks() {
        return networks;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "switchType=" + switchType +
                ", switchId=" + switchId +
                ", networks=" + networks +
                ", address=" + address +
                '}';
    }

}
