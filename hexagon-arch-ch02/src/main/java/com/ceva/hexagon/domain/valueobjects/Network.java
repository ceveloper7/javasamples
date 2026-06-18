package com.ceva.hexagon.domain.valueobjects;

public record Network(IP address, String name, int cidr) {

    // prevenimos la construccion erronea del objeto
    public Network{
        if (cidr < 1 || cidr > 32){
            throw new IllegalArgumentException("Invalid CIDR value");
        }
    }

    @Override
    public String toString() {
        return "Network{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", cidr=" + cidr +
                '}';
    }
}
