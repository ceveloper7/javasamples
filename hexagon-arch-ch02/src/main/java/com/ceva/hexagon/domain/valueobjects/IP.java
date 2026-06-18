package com.ceva.hexagon.domain.valueobjects;

public class IP {
    private final String address;
    private final Protocol protocol;

    public IP(String address, Protocol protocol){
        // prevenimos la construccion erronea del objeto
        if (address == null)
            throw new IllegalArgumentException("Null IP address");
        this.address = address;

        if (address.length() <= 15)
            this.protocol = Protocol.IPV4;
        else
            this.protocol = Protocol.IPV6;
    }

    @Override
    public String toString() {
        return "IP{" +
                "address='" + address + '\'' +
                ", protocol=" + protocol +
                '}';
    }
}
