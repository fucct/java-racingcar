package racinggame.domain;

public class RacingGame {
    public static final int NUMBER_BOUND = 10;
    private Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public int moveCars(Strategy randomGenerator) {
        for (Car car : cars) {
            car.move(randomGenerator);
        }
        return cars.getMaxPosition();
    }
}
