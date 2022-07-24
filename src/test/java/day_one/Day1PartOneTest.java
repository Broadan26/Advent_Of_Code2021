package day_one;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day1PartOne day1PartOne = new Day1PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_1_small");
        assertEquals(8, day1PartOne.calculateIncreases());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day1PartOne day1PartOne = new Day1PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_1_medium");
        assertEquals(44, day1PartOne.calculateIncreases());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day1PartOne day1PartOne = new Day1PartOne();
        assertEquals(1655, day1PartOne.calculateIncreases());
    }
}
