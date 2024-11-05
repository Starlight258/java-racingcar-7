package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.CarPositionDto;
import racingcar.model.car.Cars;
import racingcar.model.game.RacingCar;
import racingcar.model.game.position.History;
import racingcar.support.formatter.Formatter;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingCarView {

    private final InputView inputView;
    private final OutputView outputView;
    private final Formatter formatter;

    public RacingCarView(InputView inputView, OutputView outputView, Formatter formatter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.formatter = formatter;
    }

    public String readCarNames() {
        outputView.showCommentForCarNames();
        return inputView.readLine();
    }

    public String readRound() {
        outputView.showCommentForRound();
        return inputView.readLine();
    }

    public void showRacing(final RacingCar racingCar) {
        outputView.showCommentForResult();
        Cars cars = racingCar.getCars();
        History history = racingCar.getHistory();
        for (int currentRound = 0; currentRound < racingCar.getRound().getRound(); currentRound++) {
            int finalCurrentRound = currentRound;
            List<CarPositionDto> carPositions = IntStream.range(0, cars.names().size())
                    .mapToObj(i -> new CarPositionDto(
                            cars.names().get(i),
                            history.at(finalCurrentRound).get(i)))
                    .toList();
            outputView.showCarPosition(carPositions, formatter);
        }
    }

    public void showWinners(RacingCar racingCar) {
        outputView.showWinners(racingCar.calculateWinners());
    }
}
