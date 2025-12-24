package patterns.ch03.bbb.abstract_factory;

public class SlowCar implements Vehicle{
    @Override
    public void move() {
        System.out.println("slow car, move");
    }
}
