package patterns.ch03.bbb.abstract_factory;

public class HeavyTruck implements Vehicle{
    @Override
    public void move() {
        System.out.println("heavy truck, move");
    }
}
