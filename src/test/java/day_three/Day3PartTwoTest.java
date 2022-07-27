package day_three;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day3PartTwo day3PartTwo = new Day3PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_3_small");
        assertEquals(-1, day3PartTwo.calculateBits()); // Fails
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day3PartTwo day3PartTwo = new Day3PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_3_medium");
        assertEquals(84567, day3PartTwo.calculateBits());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputFull() {
        Day3PartTwo day3PartTwo = new Day3PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_3");
        assertEquals(2829354, day3PartTwo.calculateBits());
    }
}
