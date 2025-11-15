package patterns.ch01.solid.ocp;

import java.util.Arrays;
import java.util.List;

public class Truck implements Vehicle{

    @Override
    public void move() {}

    public static void main(String[] args) {
        List<Vehicle> vehicles = List.of(new Truck(), new Car());
    }
}
