package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.RacingCarConfig;
import racingcar.controller.RacingCarController;

public class Application {

    private static final String DELIMITER = ",";
    private static final int RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final int RANDOM_NUMBER_END_INCLUSIVE = 9;
    private static final int FORWARD_MIN_INCLUSIVE = 4;
    private static final String HYPHEN = "-";

    public static void main(String[] args) {
        RacingCarConfig config = new RacingCarConfig(DELIMITER, RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE, FORWARD_MIN_INCLUSIVE, HYPHEN);
        RacingCarController controller = config.createController();
        controller.process();
        Console.close();
    }
}
