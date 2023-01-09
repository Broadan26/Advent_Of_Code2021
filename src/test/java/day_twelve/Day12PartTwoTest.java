package day_twelve;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day12PartTwo day12PartTwo = new Day12PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_12_small");
        assertEquals(36, day12PartTwo.findAllPaths());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day12PartTwo day12PartTwo = new Day12PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_12_medium");
        assertEquals(103, day12PartTwo.findAllPaths());
    }

    @Test
    @DisplayName("Test Large Input")
    void testFileInputLarge() {
        Day12PartTwo day12PartTwo = new Day12PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_12_large");
        assertEquals(3509, day12PartTwo.findAllPaths());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInput() {
        Day12PartTwo day12PartTwo = new Day12PartTwo();
        assertEquals(130493, day12PartTwo.findAllPaths());
    }
}
