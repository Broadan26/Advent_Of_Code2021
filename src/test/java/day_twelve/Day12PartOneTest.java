package day_twelve;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12PartOneTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day12PartOne day12PartOne = new Day12PartOne(basePath + "\\Input\\input_day_12_small");
        assertEquals(10, day12PartOne.calculateTotalPaths());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day12PartOne day12PartOne = new Day12PartOne(basePath + "\\Input\\input_day_12_medium");
        assertEquals(19, day12PartOne.calculateTotalPaths());
    }

    @Test
    @DisplayName("Test Large Input")
    void testFileInputLarge() {
        Day12PartOne day12PartOne = new Day12PartOne(basePath + "\\Input\\input_day_12_large");
        assertEquals(226, day12PartOne.calculateTotalPaths());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day12PartOne day12PartOne = new Day12PartOne();
        assertEquals(4707, day12PartOne.calculateTotalPaths());
    }
}
