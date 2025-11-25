package patterns.ch01.solid.isp;

public class Bike implements HasPedal, Vehicle{
    @Override
    public void setMove(boolean moving) {

    }

    @Override
    public boolean pedalsMove() {
        return true;
    }
}
