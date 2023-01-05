package day_nine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day9PartTwo day9 = new Day9PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_9_small");
        assertEquals(-1, day9.calculateRiskOfLowestPoint());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day9PartTwo day9 = new Day9PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_9_medium");
        assertEquals(-1, day9.calculateRiskOfLowestPoint());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day9PartTwo day9 = new Day9PartTwo();
        assertEquals(-1, day9.calculateRiskOfLowestPoint());
    }
}
