package racingcar.model.game;

import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.Name;
import racingcar.model.game.position.History;
import racingcar.model.game.position.Positions;
import racingcar.model.game.round.Round;
import racingcar.model.game.strategy.MovingStrategy;

public class RacingCar {

    private final Cars cars;
    private final Positions positions;
    private final History history;
    private final Round round;
    private final MovingStrategy movingStrategy;

    public RacingCar(final Cars cars, final Round round, final MovingStrategy movingStrategy) {
        this.cars = cars;
        this.positions = Positions.initialize(cars.size());
        this.history = new History();
        this.round = round;
        this.movingStrategy = movingStrategy;
    }

    public void start() {
        for (int currentRound = 0; currentRound < round.getRound(); currentRound++) {
            moveAllCars();
            history.add(positions);
        }
    }

    public String calculateWinners() {
        return positions.findWinnersIndices()
                .stream()
                .map(cars::at)
                .map(Car::getName)
                .map(Name::getName)
                .collect(Collectors.joining(", "));
    }

    private void moveAllCars() {
        for (int i = 0; i < cars.size(); i++) {
            if (movingStrategy.canMove()) {
                positions.increase(i);
            }
        }
    }

    public Cars getCars() {
        return cars;
    }

    public History getHistory() {
        return history;
    }

    public Round getRound() {
        return round;
    }
}
