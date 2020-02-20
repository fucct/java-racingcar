package racinggame.domain;

public class Car {
    private static int FORWARD_NUMBER = 4;
    private static int START_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(Strategy strategy) {
        int random = strategy.generateRandom();
        if (random >= FORWARD_NUMBER) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
