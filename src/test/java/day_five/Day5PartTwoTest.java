package day_five;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day5PartTwo day5 = new Day5PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_5_small");
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day5PartTwo day5 = new Day5PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_5_medium");
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day5PartTwo day5 = new Day5PartTwo();
    }
}
