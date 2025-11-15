package patterns.ch01.solid.isp;

public class Car implements Vehicle{
    @Override
    public void setMove(boolean moving) {

    }

    @Override
    public boolean engineOn() {
        return true;
    }

    @Override
    public boolean pedalsMove() {
        throw new IllegalStateException("Not supported");
    }
}
