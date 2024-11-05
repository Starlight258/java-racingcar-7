package racingcar.view.output;

import java.util.List;
import racingcar.dto.CarPositionDto;
import racingcar.support.formatter.Formatter;

public class ConsoleOutputView implements OutputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_ROUND_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String GAME_RESULT = System.lineSeparator() + "실행 결과";
    private static final String WINNERS_FORMAT = "최종 우승자 : %s";

    @Override
    public void showCommentForCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    @Override
    public void showCommentForRound() {
        System.out.println(REQUEST_ROUND_COUNT);
    }

    @Override
    public void showCommentForResult() {
        System.out.println(GAME_RESULT);
    }

    @Override
    public void showCarPosition(final List<CarPositionDto> carPositionDtos, final Formatter formatter) {
        carPositionDtos.stream()
                .map(formatter::formatPosition)
                .forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void showWinners(final String winners) {
        System.out.printf(WINNERS_FORMAT, winners);
    }
}
