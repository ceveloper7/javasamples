package patterns.ch01.solid.isp;

public class Car implements HasEngine, Vehicle{
    @Override
    public void setMove(boolean moving) {

    }

    @Override
    public boolean engineOn() {
        return true;
    }
}
