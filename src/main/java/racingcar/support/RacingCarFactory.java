package racingcar.support;

import java.util.Arrays;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.game.RacingCar;
import racingcar.model.game.round.Round;
import racingcar.model.game.strategy.MovingStrategy;
import racingcar.support.splitter.Splitter;

public class RacingCarFactory {

    private final Splitter splitter;
    private final MovingStrategy movingStrategy;

    public RacingCarFactory(final Splitter splitter, final MovingStrategy movingStrategy) {
        this.splitter = splitter;
        this.movingStrategy = movingStrategy;
    }

    public RacingCar create(final String nameInput, final String roundInput) {
        Cars cars = createCars(nameInput);
        Round round = new Round(roundInput);
        return new RacingCar(cars, round, movingStrategy);
    }

    private Cars createCars(final String inputNames) {
        String[] names = splitter.splitFrom(inputNames);
        return new Cars(Arrays.stream(names)
                .map(Car::new)
                .toList());
    }
}
