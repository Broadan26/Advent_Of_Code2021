package day_two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2PartTwoTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day2PartTwo day2PartTwo = new Day2PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_2_small");
        assertEquals(1378, day2PartTwo.calculatePosition());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day2PartTwo day2PartTwo = new Day2PartTwo("D:\\Projects\\AdventOfCode2021\\Input\\input_day_2_medium");
        assertEquals(343368, day2PartTwo.calculatePosition());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day2PartTwo day2PartTwo = new Day2PartTwo();
        assertEquals(1965970888, day2PartTwo.calculatePosition());
    }
}
