package day_ten;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day10PartOne day10 = new Day10PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_10_small");
        assertEquals(26397, day10.calculateSyntaxErrors());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day10PartOne day10 = new Day10PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_10_medium");
        assertEquals(-1, day10.calculateSyntaxErrors());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day10PartOne day10 = new Day10PartOne();
        assertEquals(-1, day10.calculateSyntaxErrors());
    }
}
