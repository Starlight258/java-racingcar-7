package racingcar.support.formatter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarPositionDto;
import racingcar.support.repeater.StringRepeater;

@DisplayName("포맷팅 테스트")
class FormatterTest {

    @Test
    @DisplayName("")
    void 성공_포맷팅() {
        // Given
        Formatter formatter = new Formatter(new StringRepeater("-"));
        CarPositionDto dto = new CarPositionDto("mint", 2L);
        // When
        String formattingText = formatter.formatPosition(dto);

        // Then
        assertThat(formattingText).isEqualTo("mint : --");
    }
}
