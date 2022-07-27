package day_three;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day3PartOne day3PartOne = new Day3PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_3_small");
        assertEquals(3769106, day3PartOne.calculateBits());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day3PartOne day3PartOne = new Day3PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_3_medium");
        assertEquals(2408696, day3PartOne.calculateBits());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputFull() {
        Day3PartOne day3PartOne = new Day3PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_3");
        assertEquals(1458194, day3PartOne.calculateBits());
    }
}
