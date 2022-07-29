package day_four;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day4PartOne day4 = new Day4PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_4_small");
        assertEquals(45511, day4.calculateBestBoard());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day4PartOne day4 = new Day4PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_4_medium");
        assertEquals(45511, day4.calculateBestBoard());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day4PartOne day4 = new Day4PartOne();
        assertEquals(63424, day4.calculateBestBoard());
    }
}
