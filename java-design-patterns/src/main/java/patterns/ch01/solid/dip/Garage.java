package patterns.ch01.solid.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * La implementacion de Garage depende de abstraccion Vehicle y no la Jerarquia de clases concretas
 */
public class Garage {
    private List<Vehicle> parkingSpots = new ArrayList<>();

    public void park(Vehicle vehicle){
        parkingSpots.add(vehicle);
    }
}
