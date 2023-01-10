package day_13;

import day_thirteen.Day13PartOne;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13PartOneTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day13PartOne day13PartOne = new Day13PartOne(basePath + "\\Input\\input_day_13_small");
        assertEquals(17, day13PartOne.calculateVisibleDots());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day13PartOne day13PartOne = new Day13PartOne();
        assertEquals(731, day13PartOne.calculateVisibleDots());
    }
}
