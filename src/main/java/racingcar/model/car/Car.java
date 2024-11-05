package racingcar.model.car;

import java.util.Objects;

public class Car {

    private final Name name;

    public Car(final String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
