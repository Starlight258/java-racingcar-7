package racingcar.controller;

import racingcar.model.game.RacingCar;
import racingcar.support.RacingCarFactory;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView view;
    private final RacingCarFactory carFactory;

    public RacingCarController(final RacingCarView view, final RacingCarFactory carFactory) {
        this.view = view;
        this.carFactory = carFactory;
    }

    public void process() {
        RacingCar racingCar = carFactory.create(view.readCarNames(), view.readRound());

        executeRacing(racingCar);
        racingCar.start();
        view.showRacing(racingCar);
        view.showWinners(racingCar);
    }

    private void executeRacing(final RacingCar racingCar) {
        racingCar.start();
    }
}
