package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.car.InvalidNameException;

@DisplayName("이름 테스트")
class NameTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {

        @Test
        @DisplayName("5글자 이하이면 성공한다")
        void 성공_이름생성_5글자이하() {
            // Given
            String name = "mint";

            // When & Then
            assertThatCode(() -> {
                new Name(name);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("5글자를 초과하면 예외가 발생한다")
        void 실패_이름생성_5글자초과() {
            // Given
            String name = "mintyy";

            // When & Then
            assertThatThrownBy(() -> new Name(name))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 5글자 이하여야 합니다.");
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = " ")
        @DisplayName("빈 문자열이면 예외가 발생한다")
        void 실패_이름생성_빈값(String name) {
            // Given

            // When & Then
            assertThatThrownBy(() -> new Name(name))
                    .isExactlyInstanceOf(InvalidNameException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름은 null이거나 공백일 수 없습니다.");
        }
    }
}
