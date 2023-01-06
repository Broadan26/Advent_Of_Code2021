package day_eleven;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day11PartTwo day11 = new Day11PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_11_small");
        assertEquals(-1, day11.calculate());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day11PartTwo day11 = new Day11PartTwo();
        assertEquals(-1, day11.calculate());
    }
}
