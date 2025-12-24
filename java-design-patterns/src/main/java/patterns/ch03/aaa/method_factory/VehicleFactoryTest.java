package patterns.ch03.aaa.method_factory;

public class VehicleFactoryTest {
    public static void main(String[] args) {
        System.out.println("Pattern Factory Method: Vehicle Factory 2");
        var sportCar = VehicleFactory.produce("sport");

        System.out.println("Sport-car: " + sportCar);
        sportCar.move();
    }
}
