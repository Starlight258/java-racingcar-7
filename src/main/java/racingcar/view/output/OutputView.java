package racingcar.view.output;

import java.util.List;
import racingcar.support.repeater.StringRepeater;

public interface OutputView {
    void showCommentForCarNames();

    void showCommentForRound();

    void showCommentForResult();

    void showCarPosition(List<String> names, List<Long> positions, StringRepeater stringRepeater);

    void showWinners(String winners);
}
