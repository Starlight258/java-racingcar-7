package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {
    @Override
    public String read() {
        return Console.readLine();
    }
}
