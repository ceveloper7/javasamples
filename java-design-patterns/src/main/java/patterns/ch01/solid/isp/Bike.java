package patterns.ch01.solid.isp;

public class Bike implements Vehicle{
    @Override
    public void setMove(boolean moving) {

    }

    @Override
    public boolean engineOn() {
        throw new IllegalStateException("not supported");
    }

    @Override
    public boolean pedalsMove() {
        return true;
    }
}
