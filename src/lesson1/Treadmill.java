package lesson1;

public class Treadmill {
    private int distance;

    public Treadmill(int distance) {

        this.distance = distance;
    }

    public boolean toRun(int maxDistance) {
        return (maxDistance >= distance);

    }
}
