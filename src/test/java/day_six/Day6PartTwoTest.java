package day_six;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day6PartTwo day6 = new Day6PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_6_small");
        assertEquals(26984457539L , day6.calculateTotalFish());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day6PartTwo day6 = new Day6PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_6_medium");
        assertEquals(269772542695L, day6.calculateTotalFish());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day6PartTwo day6 = new Day6PartTwo();
        assertEquals(1604361182149L, day6.calculateTotalFish());
    }
}
