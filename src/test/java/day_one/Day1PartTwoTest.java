package day_one;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day1PartTwo day1PartTwo = new Day1PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_1_small");
        assertEquals(7, day1PartTwo.calculateSumIncreases());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day1PartTwo day1PartTwo = new Day1PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_1_medium");
        assertEquals(41, day1PartTwo.calculateSumIncreases());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day1PartTwo day1PartTwo = new Day1PartTwo();
        assertEquals(1683, day1PartTwo.calculateSumIncreases());
    }
}
