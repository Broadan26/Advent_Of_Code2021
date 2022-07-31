package day_six;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Day6PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day6PartOne day6 = new Day6PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_6_small");
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day6PartOne day6 = new Day6PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_6_medium");
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day6PartOne day6 = new Day6PartOne();
    }
}
