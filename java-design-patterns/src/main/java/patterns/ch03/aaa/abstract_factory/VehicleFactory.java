package patterns.ch03.aaa.abstract_factory;

/**
 * Factory Method Pattern
 * solo funciona bien cuando se trabaja con una familia homogénea de objetos.
 * Si una clase se desvía demasiado de la clase base, se genera un alto acoplamiento
 *
 * El Factory Method Pattern es útil cuando queremos delegar la creación de objetos a subclases,
 * pero su principal debilidad es que asume homogeneidad en los objetos creados.
 */
public final class VehicleFactory {

    private VehicleFactory(){

    }

    public static Vehicle produce(String type){
        Vehicle v = switch (type){
            case "sport" -> new SportCar("porsche 911");
            case "suv" -> new SuvCar("skoda kodiaq");
            default -> throw new IllegalArgumentException("""
                    Not implemented type: '%s' """.formatted(type));
        };
        return v;
    }
}
