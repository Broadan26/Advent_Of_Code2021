package day_fourteen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14PartOneTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day14PartOne day14PartOne = new Day14PartOne(basePath + "\\Input\\input_day_14_small");
        assertEquals(1588, day14PartOne.calculate());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day14PartOne day14PartOne = new Day14PartOne();
        assertEquals(2321, day14PartOne.calculate());
    }
}
