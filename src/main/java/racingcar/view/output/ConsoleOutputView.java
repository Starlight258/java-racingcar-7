package racingcar.view.output;

import java.util.List;
import racingcar.dto.CarPositionDto;
import racingcar.support.formatter.Formatter;

public class ConsoleOutputView implements OutputView {

    @Override
    public void showCommentForCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void showCommentForRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void showCommentForResult() {
        System.out.println("\n실행 결과");
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
        System.out.println("최종 우승자 : " + winners);
    }
}
