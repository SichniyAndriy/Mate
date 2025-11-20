package core.basesyntax;

import java.util.List;

/**
 * Make this class immutable. See requirements in task description.
 */
public class Car {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

    //implement this class

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }
}
