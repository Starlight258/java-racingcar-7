package racingcar.view.output;

import java.util.List;
import racingcar.dto.CarPositionDto;
import racingcar.support.formatter.Formatter;

public interface OutputView {

    void showCommentForCarNames();

    void showCommentForRound();

    void showCommentForResult();

    void showCarPosition(List<CarPositionDto> carPositionDtos, Formatter formatter);

    void showWinners(String winners);
}
