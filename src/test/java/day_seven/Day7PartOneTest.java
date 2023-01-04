package day_seven;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7PartOneTest {

    @Test
    @DisplayName("Test Small Input")
    void testFileInputSmall() {
        Day7PartOne day7 = new Day7PartOne("Input/input_day_7_small");
        assertEquals(37, day7.calculateFuelCost());
    }

    @Test
    @DisplayName("Test Medium Input")
    void testFileInputMedium() {
        Day7PartOne day7 = new Day7PartOne("Input/input_day_7_small");
        assertEquals(37, day7.calculateFuelCost());
    }

    @Test
    @DisplayName("Test Full Input")
    void testFileInputLarge() {
        Day7PartOne day7 = new Day7PartOne();
        assertEquals(328187, day7.calculateFuelCost());
    }
}
