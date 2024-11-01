package racingcar.support.comparable;

public class IntegerComparable implements NumberComparable {

    @Override
    public boolean meetsThreshold(final Number value, final Number threshold) {
        return value.intValue() >= threshold.intValue();
    }
}
