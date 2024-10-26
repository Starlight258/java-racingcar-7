package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.InvalidNameException;

public class Cars {

    private final List<Car> values;

    public Cars(final List<Car> values) {
        this.values = new ArrayList<>(values);
    }

    public void add(Car car) {
        validate(car);
        values.add(car);
    }

    public List<Boolean> doMove() {
        return values.stream()
                .map(Car::doesMove)
                .toList();
    }

    private void validate(Car car) {
        if (isDuplicateName(car.name())) {
            throw new InvalidNameException("이름은 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicateName(String name) {
        return values.stream()
                .anyMatch(car -> car.name().equals(name));
    }

    public int size() {
        return values.size();
    }

    public List<String> names() {
        return values.stream()
                .map(Car::name)
                .toList();
    }

    public String name(final Integer index) {
        return values.get(index).name();
    }
}
