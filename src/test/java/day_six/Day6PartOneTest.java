package day_six;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day6PartOne day6 = new Day6PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_6_small");
        assertEquals(5934, day6.calculateTotalFish());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day6PartOne day6 = new Day6PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_6_medium");
        assertEquals(59321, day6.calculateTotalFish());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day6PartOne day6 = new Day6PartOne();
        assertEquals(352872, day6.calculateTotalFish());
    }
}
