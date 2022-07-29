package day_four;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day4PartTwo day4 = new Day4PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_4_small");
        assertEquals(40470, day4.calculateWorstBoard());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day4PartTwo day4 = new Day4PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_4_medium");
        assertEquals(19380, day4.calculateWorstBoard());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day4PartTwo day4 = new Day4PartTwo();
        assertEquals(23541, day4.calculateWorstBoard());
    }
}
