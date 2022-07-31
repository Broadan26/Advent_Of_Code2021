package day_five;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day5PartOne day5 = new Day5PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_5_small");
        assertEquals(5, day5.calculateOverlaps());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day5PartOne day5 = new Day5PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_5_medium");
        assertEquals(23, day5.calculateOverlaps());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day5PartOne day5 = new Day5PartOne();
        assertEquals(5306, day5.calculateOverlaps());
    }
}
