package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.game.RacingCar;
import racingcar.model.game.position.History;
import racingcar.model.game.round.Round;
import racingcar.model.game.strategy.MovingStrategy;
import racingcar.support.repeater.StringRepeater;
import racingcar.support.splitter.Splitter;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Splitter splitter;
    private final MovingStrategy movingStrategy;
    private final StringRepeater stringRepeater;

    public RacingCarController(final InputView inputView, final OutputView outputView, final Splitter splitter,
                               final MovingStrategy movingStrategy,
                               final StringRepeater stringRepeater) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.splitter = splitter;
        this.movingStrategy = movingStrategy;
        this.stringRepeater = stringRepeater;
    }

    public void process() {
        Cars cars = generateCars();
        Round round = generateRound();

        RacingCar racingCar = new RacingCar(cars, round);
        executeRacing(racingCar);
        showRacingResult(round, racingCar);
        showWinners(racingCar);
    }

    private Cars generateCars() {
        String inputNames = readNames();
        return initializeCars(inputNames);
    }

    private Round generateRound() {
        String inputRound = readRound();
        return new Round(inputRound);
    }

    private String readNames() {
        outputView.showCommentForCarNames();
        return inputView.read();
    }

    private Cars initializeCars(final String inputNames) {
        Cars cars = new Cars(new ArrayList<>());
        for (String name : splitter.splitFrom(inputNames)) {
            cars.add(new Car(name, movingStrategy));
        }
        return cars;
    }

    private String readRound() {
        outputView.showCommentForRound();
        return inputView.read();
    }

    private void showRacingResult(final Round round, final RacingCar racingCar) {
        outputView.showCommentForResult();
        Cars cars = racingCar.cars();
        History history = racingCar.history();
        for (int currentRound = 0; currentRound < round.round(); currentRound++) {
            outputView.showCarPosition(cars.names(), history.at(currentRound), stringRepeater);
        }
    }

    private void executeRacing(final RacingCar racingCar) {
        racingCar.start();
    }

    private void showWinners(final RacingCar racingCar) {
        String winners = racingCar.calculateWinners();
        outputView.showWinners(winners);
    }
}
