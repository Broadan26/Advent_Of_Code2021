package day_fifteen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15PartTwoTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day15PartTwo day15PartTwo = new Day15PartTwo(basePath + "\\Input\\input_day_15_small");
        assertEquals(-1, day15PartTwo.calculate());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day15PartTwo day15PartTwo = new Day15PartTwo();
        assertEquals(-1, day15PartTwo.calculate());
    }
}
