package day_two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day2PartOne day2PartOne = new Day2PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_2_small");
        assertEquals(195, day2PartOne.calculatePosition());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day2PartOne day2PartOne = new Day2PartOne("D:\\Projects\\AdventOfCode2021\\Input\\input_day_2_medium");
        assertEquals(7448, day2PartOne.calculatePosition());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day2PartOne day2PartOne = new Day2PartOne();
        assertEquals(1868935, day2PartOne.calculatePosition());
    }
}
