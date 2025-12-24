package patterns.ch03.bbb.abstract_factory;

public class LightTruck implements Vehicle{
    @Override
    public void move() {
        System.out.println("light truck, move");
    }
}
