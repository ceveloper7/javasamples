package patterns.ch03.ccc.builder_pattern;

public class BuilderMain {
    public static void main(String[] args) {
        System.out.println("Pattern Builder: building vehicles ");

        var slowVehicle = VehicleBuilder.buildSlowVehicle();

        var fastVehicle = new FastVehicle.Builder()
                .addCabin("Cabin")
                .addEngine("Engine")
                .build();

        var superVehicle = new SuperVehicle.Builder()
                .addCabin("Super_Cabin")
                .addEngine("Super_Engine")
                .build();

        slowVehicle.parts();
        fastVehicle.parts();
        System.out.println(superVehicle);
        superVehicle.parts();
    }
}
