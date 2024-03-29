package day_fourteen;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14PartTwoTest {

    private static String basePath;

    @BeforeAll
    static void setup() {
        basePath = System.getProperty("user.dir");
    }

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day14PartTwo day14PartTwo = new Day14PartTwo(basePath + "\\Input\\input_day_14_small");
        assertEquals(2188189693528L, day14PartTwo.calculate());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day14PartTwo day14PartTwo = new Day14PartTwo();
        assertEquals(2399822193706L, day14PartTwo.calculate());
    }
}
