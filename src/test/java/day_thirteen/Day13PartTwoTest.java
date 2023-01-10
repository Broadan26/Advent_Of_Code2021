package day_thirteen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13PartTwoTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day13PartTwo day13PartTwo = new Day13PartTwo(basePath + "\\Input\\input_day_13_small");
        assertEquals(16, day13PartTwo.calculateVisibleDots());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day13PartTwo day13PartTwo = new Day13PartTwo();
        assertEquals(93, day13PartTwo.calculateVisibleDots());
    }
}
