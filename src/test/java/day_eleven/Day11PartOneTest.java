package day_eleven;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11PartOneTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day11PartOne day11 = new Day11PartOne(basePath + "\\Input\\input_day_11_small");
        assertEquals(259, day11.calculateOctopiFlashes());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day11PartOne day11 = new Day11PartOne(basePath + "\\Input\\input_day_11_medium");
        assertEquals(1656, day11.calculateOctopiFlashes());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day11PartOne day11 = new Day11PartOne();
        assertEquals(1705, day11.calculateOctopiFlashes());
    }
}
