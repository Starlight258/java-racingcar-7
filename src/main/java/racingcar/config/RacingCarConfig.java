package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.model.game.strategy.MovingStrategy;
import racingcar.model.game.strategy.RacingCarMovingStrategy;
import racingcar.support.RacingCarFactory;
import racingcar.support.comparable.IntegerComparable;
import racingcar.support.formatter.Formatter;
import racingcar.support.random.RandomIntegerGenerator;
import racingcar.support.repeater.StringRepeater;
import racingcar.support.splitter.Splitter;
import racingcar.view.RacingCarView;
import racingcar.view.input.ConsoleInputView;
import racingcar.view.output.ConsoleOutputView;

public class RacingCarConfig {

    private final String DELIMITER;
    private final int RANDOM_NUMBER_START_INCLUSIVE;
    private final int RANDOM_NUMBER_END_INCLUSIVE;
    private final int FORWARD_MIN_INCLUSIVE;
    private final String HYPHEN;

    public RacingCarConfig(final String DELIMITER, final int RANDOM_NUMBER_START_INCLUSIVE,
                           final int RANDOM_NUMBER_END_INCLUSIVE,
                           final int FORWARD_MIN_INCLUSIVE, final String HYPHEN) {
        this.DELIMITER = DELIMITER;
        this.RANDOM_NUMBER_START_INCLUSIVE = RANDOM_NUMBER_START_INCLUSIVE;
        this.RANDOM_NUMBER_END_INCLUSIVE = RANDOM_NUMBER_END_INCLUSIVE;
        this.FORWARD_MIN_INCLUSIVE = FORWARD_MIN_INCLUSIVE;
        this.HYPHEN = HYPHEN;
    }

    public RacingCarController createController() {
        return new RacingCarController(createView(), createFactory());
    }

    private RacingCarView createView() {
        return new RacingCarView(new ConsoleInputView(), new ConsoleOutputView(),
                new Formatter(new StringRepeater(HYPHEN)));
    }

    private RacingCarFactory createFactory() {
        return new RacingCarFactory(new Splitter(DELIMITER), createMovingStrategy());
    }

    private MovingStrategy createMovingStrategy() {
        return new RacingCarMovingStrategy(
                new RandomIntegerGenerator(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE),
                new IntegerComparable(), FORWARD_MIN_INCLUSIVE);
    }
}
