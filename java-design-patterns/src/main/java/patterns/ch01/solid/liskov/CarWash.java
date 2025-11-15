package patterns.ch01.solid.liskov;

/**
 * Solid: Principio de Susticion Liskov
 */
public class CarWash {

    public void wash(Vehicle vehicle){}

    public static void main(String[] args) {
        CarWash carWash = new CarWash();

        carWash.wash(new Car());
        carWash.wash(new SportCar());
    }
}
