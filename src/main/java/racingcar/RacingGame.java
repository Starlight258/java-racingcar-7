package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.attempt.Attempt;
import racingcar.model.car.Cars;
import racingcar.model.position.History;
import racingcar.model.position.Positions;

public class RacingGame {

    private final Cars cars;
    private final Positions positions;
    private final History history;
    private final Attempt attempt;

    public RacingGame(final Cars cars, final Attempt attempt) {
        this.cars = cars;
        this.positions = Positions.initialize(cars.size());
        this.history = new History(new ArrayList<>());
        this.attempt = attempt;
    }

    public void start() {
        for (int round = 0; round < attempt.getValue(); round++) {
            List<Boolean> moves = cars.doMove();
            moveWithPositions(moves);
        }
    }

    public String calculateWinners() {
        return positions.calculateWinners()
                .stream()
                .map(cars::name)
                .collect(Collectors.joining(", "));
    }

    private void moveWithPositions(final List<Boolean> moves) {
        for (int j = 0; j < cars.size(); j++) {
            if (moves.get(j)) {
                positions.increase(j);
            }
        }
        history.add(positions);
    }

    public Cars getCars() {
        return cars;
    }

    public History getHistory() {
        return history;
    }
}
