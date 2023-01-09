package day_twelve;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day12PartTwo day12PartTwo = new Day12PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_12_small");
        assertEquals(-1, day12PartTwo.calculate());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day12PartTwo day12PartTwo = new Day12PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_12_medium");
        assertEquals(-1, day12PartTwo.calculate());
    }

    @Test
    @DisplayName("Test Large Input")
    void testFileInput() {
        Day12PartTwo day12PartTwo = new Day12PartTwo();
        assertEquals(-1, day12PartTwo.calculate());
    }
}
