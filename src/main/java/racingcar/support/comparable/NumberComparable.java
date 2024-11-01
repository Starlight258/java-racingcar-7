package racingcar.support.comparable;

@FunctionalInterface
public interface NumberComparable {

    boolean meetsThreshold(Number value, Number threshold);
}
