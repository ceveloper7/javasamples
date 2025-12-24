package patterns.ch03.bbb.abstract_factory;

public class FastCar implements Vehicle{
    @Override
    public void move() {
        System.out.println("fast car, move");
    }
}
