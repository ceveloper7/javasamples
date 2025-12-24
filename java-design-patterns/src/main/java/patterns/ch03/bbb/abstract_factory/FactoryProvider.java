package patterns.ch03.bbb.abstract_factory;

/**
 * Distingue que factory es creado basado en un argumento.
 */
public final class FactoryProvider {

    public FactoryProvider(){}

    public static AbstractFactory getFactory(String type){
        return switch (type){
            case "car" -> new CarFactory();
            case "truck" -> new TruckFactory();
            default -> throw new IllegalArgumentException("""
                    this is %s""".formatted(type));
        };
    }
}
