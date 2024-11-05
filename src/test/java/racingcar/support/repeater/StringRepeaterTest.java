package racingcar.support.repeater;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.exception.repeater.InvalidCountException;
import racingcar.exception.repeater.InvalidValueException;

@DisplayName("문자열 리피터 테스트")
class StringRepeaterTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {

        @Test
        @DisplayName("유효한 문자열이면 성공적으로 생성한다")
        void 성공_생성() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new StringRepeater("-");
            }).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("문자열이 비어있거나 null이면 예외가 발생한다")
        void 실패_이름생성_빈값또는null(String name) {
            // Given

            // When & Then
            assertThatThrownBy(() -> new StringRepeater(name))
                    .isExactlyInstanceOf(InvalidValueException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("반복할 문자열은 null이거나 빈 값일 수 없습니다.");
        }
    }

    @Nested
    @DisplayName("반복 테스트")
    class 반복_테스트 {

        @Test
        @DisplayName("주어진 횟수만큼 반복한다")
        void 성공_반복() {
            // Given
            StringRepeater stringRepeater = new StringRepeater("-");

            // When
            String repeat = stringRepeater.repeat(5);

            // Then
            assertThat(repeat).isEqualTo("-----");
        }

        @Test
        @DisplayName("주어진 횟수가 음수이면 예외가 발생한다")
        void 실패_반복_음수() {
            // Given
            StringRepeater stringRepeater = new StringRepeater("-");

            // When & Then
            assertThatThrownBy(() -> stringRepeater.repeat(-1))
                    .isExactlyInstanceOf(InvalidCountException.class)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("count는 음수일 수 없습니다.");
        }
    }
}
