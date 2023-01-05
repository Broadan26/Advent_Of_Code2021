package day_nine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day9PartOne day9 = new Day9PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_9_small");
        assertEquals(15, day9.calculateRiskOfLowestPoint());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day9PartOne day9 = new Day9PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_9_medium");
        assertEquals(112, day9.calculateRiskOfLowestPoint());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day9PartOne day9 = new Day9PartOne();
        assertEquals(537, day9.calculateRiskOfLowestPoint());
    }
}
