package day_five;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day5PartTwo day5 = new Day5PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_5_small");
        assertEquals(12, day5.calculateOverlaps());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day5PartTwo day5 = new Day5PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_5_medium");
        assertEquals(142, day5.calculateOverlaps());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day5PartTwo day5 = new Day5PartTwo();
        assertEquals(17787, day5.calculateOverlaps());
    }
}
