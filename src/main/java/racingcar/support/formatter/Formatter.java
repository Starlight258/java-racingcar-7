package racingcar.support.formatter;

import racingcar.dto.CarPositionDto;
import racingcar.support.repeater.StringRepeater;

public class Formatter {

    private static final String NAME_POSITION_DELIMITER = " : ";

    private final StringRepeater repeater;

    public Formatter(final StringRepeater repeater) {
        this.repeater = repeater;
    }

    public String formatPosition(final CarPositionDto dto) {
        return dto.getName() + NAME_POSITION_DELIMITER + repeater.repeat(dto.getPosition());
    }
}
