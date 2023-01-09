package day_eleven;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11PartTwoTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day11PartTwo day11 = new Day11PartTwo(basePath + "\\Input\\input_day_11_small");
        assertEquals(6, day11.calculateOctopiFlashes());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day11PartTwo day11 = new Day11PartTwo(basePath + "\\Input\\input_day_11_medium");
        assertEquals(195, day11.calculateOctopiFlashes());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day11PartTwo day11 = new Day11PartTwo();
        assertEquals(265, day11.calculateOctopiFlashes());
    }
}
