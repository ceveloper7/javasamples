package patterns.ch01.solid.isp;

/**
 * ISP -> Principio de Segregacion de INterface
 */
public class Test {

    private static void printIsMoving(Vehicle vehicle){
        if (vehicle instanceof Car){
            System.out.println(((Car) vehicle).engineOn());
        }else{
            System.out.println("is not a Car");
        }

        if (vehicle instanceof Bike){
            System.out.println(((Bike) vehicle).pedalsMove());
        }else{
            System.out.println("is not a Bike");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        printIsMoving(vehicle);
    }
}
