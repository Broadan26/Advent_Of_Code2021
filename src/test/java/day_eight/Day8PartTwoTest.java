package day_eight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day8PartTwo day8 = new Day8PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_8_small");
        assertEquals(61229, day8.calculateSumOfDigits());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day8PartTwo day8 = new Day8PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_8_medium");
        assertEquals(118066, day8.calculateSumOfDigits());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day8PartTwo day8 = new Day8PartTwo();
        assertEquals(1011284, day8.calculateSumOfDigits());
    }
}
