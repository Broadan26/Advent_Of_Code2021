package day_fifteen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15PartOneTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day15PartOne day15PartOne = new Day15PartOne(basePath + "\\Input\\input_day_15_small");
        assertEquals(-1, day15PartOne.calculate());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day15PartOne day15PartOne = new Day15PartOne();
        assertEquals(-1, day15PartOne.calculate());
    }
}
