package day_two.entity;

public class Direction {

    private final String direction;
    private final Integer degree;

    public Direction(String direction, Integer degree) {
        this.direction = direction;
        this.degree = degree;
    }

    public String getDirection() {
        return direction;
    }

    public Integer getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "direction='" + direction + '\'' +
                ", degree=" + degree +
                '}';
    }
}
