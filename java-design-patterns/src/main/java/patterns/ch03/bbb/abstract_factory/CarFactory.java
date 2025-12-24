package patterns.ch03.bbb.abstract_factory;

public class CarFactory extends AbstractFactory{
    @Override
    Vehicle createVehicle(String type) {
        return switch (type){
            case "slow" -> new SlowCar();
            case "fast" -> new FastCar();
            default -> throw new IllegalArgumentException("not implemented");
        };
    }
}
