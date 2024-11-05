package racingcar.model.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.game.position.History;
import racingcar.model.game.position.Position;
import racingcar.model.game.position.Positions;
import racingcar.model.game.round.Round;
import racingcar.model.game.strategy.MovingStrategy;

@DisplayName("자동차 경주 테스트")
class RacingCarTest {

    @Nested
    @DisplayName("시작 테스트")
    class 시작_테스트 {

        @Test
        @DisplayName("시도횟수가 0이면 모두 출발점에 있다")
        void 성공_시작_시도횟수0() {
            // Given
            MovingStrategy movingStrategy = () -> true;
            Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));
            Round round = new Round("0");
            RacingCar racingCar = new RacingCar(cars, round, movingStrategy);

            // When
            racingCar.start();

            // Then
            assertThat(racingCar).extracting("positions")
                    .isEqualTo(new Positions(List.of(new Position(0), new Position(0))));
        }

        @Test
        @DisplayName("시도횟수가 1 이상이면 경주를 수행한다")
        void 성공_시작_시도횟수1이상() {
            // Given
            Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));
            Round round = new Round("1");
            RacingCar racingCar = new RacingCar(cars, round, () -> true);

            // When
            racingCar.start();

            // Then
            Positions expectedPositions = new Positions(List.of(new Position(1), new Position(1)));
            History expectedHistory = new History();
            expectedHistory.add(expectedPositions);

            assertAll(
                    () -> assertThat(racingCar).extracting("positions")
                            .isEqualTo(expectedPositions),
                    () -> assertThat(racingCar).extracting("history")
                            .isEqualTo(expectedHistory)
            );
        }
    }

    @Nested
    @DisplayName("우승자 계산 테스트")
    class 우승자_계산_테스트 {

        @Test
        @DisplayName("우승자를 모두 출력한다")
        void 성공_우승자계산_우승자여러명() {
            // Given
            Cars cars = new Cars(List.of(new Car("pobi"), new Car("woni")));
            Round round = new Round("1");
            RacingCar racingCar = new RacingCar(cars, round, () -> true);
            racingCar.start();

            // When
            String winners = racingCar.calculateWinners();

            // Then
            assertThat(winners).isEqualTo("pobi, woni");
        }
    }
}
