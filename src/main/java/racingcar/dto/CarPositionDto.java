package racingcar.dto;

public class CarPositionDto {

    private final String name;
    private final long position;

    public CarPositionDto(String name, long position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public long getPosition() {
        return position;
    }
}
