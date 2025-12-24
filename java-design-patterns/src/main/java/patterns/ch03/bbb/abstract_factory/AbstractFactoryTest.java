package patterns.ch03.bbb.abstract_factory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        System.out.println("Pattern Abstract Factory: Vehicle Factory 1...");
        AbstractFactory carFactory = FactoryProvider.getFactory("car");
        Vehicle car = carFactory.createVehicle("fast");
        car.move();
    }
}
