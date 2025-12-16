package patterns.ch03.aaa.abstract_factory;

public class SuvCar implements Vehicle{
    private final String type;

    public SuvCar(String type){
        this.type = type;
    }

    @Override
    public void move() {
        System.out.println("Moving SUV Car");
    }
}
