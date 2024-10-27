package racingcar.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.util.comparable.IntegerComparable;
import racingcar.util.comparable.NumberComparable;
import racingcar.util.random.RandomNumberGenerator;

@DisplayName("자동차 경주 이동 전략 테스트")
class RacingCarMovingStrategyTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("이동 테스트")
    class moveTest {
        @Test
        @DisplayName("랜덤값이 기준값 이상이면 이동한다")
        void 성공_이동_기준값이상() {
            // Given
            RandomNumberGenerator randomNumberGenerator = () -> MOVING_FORWARD;
            NumberComparable numberComparable = new IntegerComparable();
            RacingCarMovingStrategy strategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                    MOVING_FORWARD);

            // When & Then
            assertThat(strategy.canMove()).isTrue();
        }

        @Test
        @DisplayName("랜덤값이 기준값 미만이면 이동하지 않는다")
        void 성공_이동_기준값미만() {
            // Given
            RandomNumberGenerator randomNumberGenerator = () -> STOP;
            NumberComparable numberComparable = new IntegerComparable();
            RacingCarMovingStrategy strategy = new RacingCarMovingStrategy(randomNumberGenerator, numberComparable,
                    MOVING_FORWARD);

            // When & Then
            assertThat(strategy.canMove()).isFalse();
        }
    }

}
