package patterns.ch03.aaa.method_factory;

/**
 * Inmutable class
 * @param type
 */
public record SportCar(String type) implements  Vehicle{
    @Override
    public void move() {
        System.out.println("""
                SportCar, type '%s', move""".formatted(type));
    }
}
