package patterns.ch01.solid.isp;

public class Test {

    private static void printIsMoving(Vehicle vehicle){
        if (vehicle instanceof Car){
            System.out.println(vehicle.engineOn());
        }else{
            System.out.println("is not a Car");
        }

        if (vehicle instanceof Bike){
            System.out.println(vehicle.pedalsMove());
        }else{
            System.out.println("is not a Bike");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        printIsMoving(vehicle);
    }
}
