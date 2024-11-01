package racingcar.model.game.strategy;

import racingcar.support.comparable.NumberComparable;
import racingcar.support.random.RandomNumberGenerator;

public class RacingCarMovingStrategy implements MovingStrategy {

    private final RandomNumberGenerator randomNumberGenerator;
    private final NumberComparable numberComparable;
    private final Number forwardMinInclusive;

    public RacingCarMovingStrategy(final RandomNumberGenerator randomNumberGenerator,
                                   final NumberComparable numberComparable, final Number forwardMinInclusive) {
        this.forwardMinInclusive = forwardMinInclusive;
        this.randomNumberGenerator = randomNumberGenerator;
        this.numberComparable = numberComparable;
    }

    @Override
    public boolean canMove() {
        Number value = randomNumberGenerator.pickNumber();
        return numberComparable.meetsThreshold(value, forwardMinInclusive);
    }
}
